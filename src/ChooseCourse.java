import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//choose courses
public class ChooseCourse extends JPanel implements ActionListener{
	
	private String host;
	private String stuID;// 声明表示当前学生学号的引用
	//声明Connection引用、Statement对象引用与结果集引用
	private connectDB conn = new connectDB();
	
	JSplitPane jsplit;
	JPanel uppart;
	JPanel downpart;
	//uppart
	JLabel intro = new JLabel("Please choose your courses");
	JLabel coll = new JLabel("College : ");
	JLabel dept = new JLabel("Department : ");
	JLabel major = new JLabel("Major : ");
	JLabel prof = new JLabel("Professor : ");
	JLabel weekday = new JLabel("Weekday : ");
	JLabel timepart = new JLabel("Time : ");
	JLabel blank = new JLabel(" ");
	
	private JComboBox coll_jcb = new JComboBox();
	private JComboBox dept_jcb = new JComboBox();
	private JComboBox major_jcb = new JComboBox();
	private JComboBox prof_jcb = new JComboBox();
	private JComboBox weekday_jcb = new JComboBox();
	private JComboBox timepart_jcb = new JComboBox();
	private Vector<String> coll_v = new Vector<String>();
	private Vector<String> dept_v = new Vector<String>();
	private Vector<String> major_v = new Vector<String>();
	private Vector<String> prof_v = new Vector<String>();
	private Vector<String> weekday_v = new Vector<String>();
	private Vector<String> timepart_v = new Vector<String>();
	
	private JButton intro_jb=new JButton("Course Intro");// course intro button
	private JButton add_jb=new JButton("Add Course");// add course button
	
	private JTable jt;
	private JScrollPane jsp;
	//Vector for table header and content
	private Vector<String> v_head=new Vector<String>();
	private Vector<Vector> v_data=new Vector<Vector>();
	//Vector for available course
	private Vector<String> v_couid=new Vector<String>();
	
	//Constructor
	public ChooseCourse(String stuID){
		//this.host=host;
		this.stuID=stuID;
		this.initialTable("","","","","","");//initialize table data
		this.makePanel();//make panel
		makePanel();
	}
	
	//make panel
	public void makePanel(){
		
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		uppart = new JPanel(new GridLayout(5,1,5,5));
		downpart = new JPanel();
		jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,uppart,downpart);
		//jsplit.setDividerLocation(150);
		jsplit.setDividerSize(1);
		uppart.setBackground(Color.WHITE);
		downpart.setBackground(Color.WHITE);
		this.add(jsplit);
		
		//uppart
		uppart.add(intro);
		
		JPanel coll_dept = new JPanel(new GridLayout(1,5,0,0));
		coll_dept.add(coll);
		coll_dept.add(coll_jcb);
		coll_dept.add(blank);
		coll_dept.add(dept);
		coll_dept.add(dept_jcb);
		uppart.add(coll_dept);
		JPanel major_prof = new JPanel(new GridLayout(1,5,0,0));
		major_prof.add(major);
		major_prof.add(major_jcb);
		major_prof.add(blank);
		major_prof.add(prof);
		major_prof.add(prof_jcb);
		uppart.add(major_prof);
		JPanel weekday_timepart = new JPanel(new GridLayout(1,5,0,0));
		weekday_timepart.add(weekday);
		weekday_timepart.add(weekday_jcb);
		weekday_timepart.add(blank);
		weekday_timepart.add(timepart);
		weekday_timepart.add(timepart_jcb);
		uppart.add(weekday_timepart);
		
		//downpart 
		this.setLayout(null);
		DefaultTableModel dtm=new DefaultTableModel(v_data,v_head);
		jt = new JTable(dtm);//创建表格
		jsp = new JScrollPane(jt);//将表格放入JScrollPane中
		jsp.setBounds(0,0,800,400);
		downpart.add(jsp);
		add_jb.setBounds(500,450,100,30); 
		downpart.add(add_jb);
		add_jb.addActionListener(this);	  //add course
	}
	
	// comboBox actionListener
	class itemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
		   if (e.getStateChange() == ItemEvent.SELECTED) {
			   if(e.getItem() == coll_v.get(0));
		    
		    
		   } else {

		   }
		}
	}
	
	public void initialCombox_coll(){
		try{//initialize table
			String sql="select college.collName from college";
			conn.rs=conn.stmt.executeQuery(sql);
			while(conn.rs.next()){
				
			}
				conn.rs.close();
			}
			catch(Exception e){e.printStackTrace();}
			
	}
	
	public void initialCombox_dept(){
		
	}

	public void initialCombox_major(){
		
	}
	public void initialCombox_prof(){
		
	}
	public void initialCombox_weekday(){
		
	}
	public void initialCombox_timepart(){
		
	}
	
	//initialize table data
	public void initialTable(String coll, String dept, String major, String prof, String wday, String timepart)
	{   //initialize table head
		v_head.add("College");v_head.add("Major");v_head.add("Course ID");v_head.add("Course Name");
		v_head.add("Weekday");v_head.add("Time");v_head.add("Location");v_head.add("Instructor");
		v_head.add("Credits");v_head.add("Available");
		try{//initialize table
			String sql="select college.collName, major.majorName, courseinfo.courseID, course.courseName, "+
			           "courseinfo.courseDay, courseinfo.courseTime, courseinfo.location, courseinfo.teacher, "+
			           "course.credit, courseinfo.restCapacity from course,courseinfo,college,major where "+
			           "courseinfo.courseID=course.courseID and course.majorID=major.majorID and "+
			           "course.collID=college.collID";
			conn.rs=conn.stmt.executeQuery(sql);
			while(conn.rs.next()){
				Vector v = new Vector();
				String collName = conn.rs.getString(1);
				String majorName=conn.rs.getString(2);
				String courseID=conn.rs.getString(3);
				String courseName=conn.rs.getString(4);
				String courseDay=conn.rs.getString(5);
				String courseTime=conn.rs.getString(6);
				String location=conn.rs.getString(7);
				String teacher=conn.rs.getString(8);
				String credit=conn.rs.getDouble(9)+"";
				String restCapacity=conn.rs.getInt(10)+"";
				String weekday, time;
				//translate number into weekday
				if(courseDay.equals("1"))
					weekday = "Mon";
				else if(courseDay.equals("2"))
					weekday = "Tue";
				else if(courseDay.equals("3"))
					weekday = "Wed";
				else if(courseDay.equals("4"))
					weekday = "Thu";
				else if(courseDay.equals("5"))
					weekday = "Fri";
				else if(courseDay.equals("6"))
					weekday = "Sat";
				else
					weekday = "Sun";
				//translate number into time
				if(courseTime.equals("1"))
					time = "9:00-11:30";
				else if(courseTime.equals("2"))
					time = "12:00-14:30";
				else if(courseTime.equals("3"))
					time = "15:00-17:30";
				else
					time = "18:15-20:45";
				v.add(collName);v.add(majorName);v.add(courseID);v.add(courseName);v.add(weekday);
				v.add(time);v.add(location);v.add(teacher);v.add(credit);v.add(restCapacity);
				v_data.add(v);
			}
			conn.rs.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
	//Buttons ActionListener
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==add_jb)
		{	
			
			String courseID = (String)jt.getValueAt(jt.getSelectedRow() , 2);//获取输入的课程号
			if(courseID.equals("")){//课程号为空
				JOptionPane.showMessageDialog(this,"请输入课程号","错误",
				                               JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!v_couid.contains(courseID)){//该课程不在可选列表之中
				JOptionPane.showMessageDialog(this,"请输入正确的课程号","错误",
				                                     JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				String sql1="select * from grade where stuID='"+stuID+"' and "+
				             "courseID='"+courseID+"'";
				conn.rs=conn.stmt.executeQuery(sql1);
				if(conn.rs.next()){//已经选过这门课程
					JOptionPane.showMessageDialog(this,"你已经选过这门课程了","错误",
					                                       JOptionPane.ERROR_MESSAGE);	
				}
				else{   //判断是否与已经选的课程时间冲突
				    conn.rs.close();
					String sql2="select cou_name from course,courseinfo,grade "+
					             "where grade.courseID=course.courseID "+
					            "and grade.courseID=courseinfo.courseID "+
					            "and grade.stuID='"+stuID+"' "+
					            "and grade.isdual=0 "+
					            "and (courseinfo.cou_day,courseinfo.cou_time) in "+
					            "(select cou_day,cou_time from courseinfo where "+
					            "courseID='"+courseID+"')";
					 conn.rs=conn.stmt.executeQuery(sql2);
					 if(conn.rs.next())
					 {//时间冲突，给出提示信息
					 	String cou_name=new String(conn.rs.getString(1).getBytes("ISO-8859-1"));
					 	JOptionPane.showMessageDialog(this,"与"+cou_name+"时间冲突","错误",
					 	                                        JOptionPane.ERROR_MESSAGE);
					 }
					 else
					 {//开始添加课程
					 	String sql="insert into grade(stuID,courseID) values"+
					 	            "('"+stuID+"','"+courseID+"')";
						int i=conn.stmt.executeUpdate(sql);
						if(i==1)
						{//添加成功
							JOptionPane.showMessageDialog(this,"添加成功","提示",
							                            JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{//添加失败
							JOptionPane.showMessageDialog(this,"提交失败","错误",
							                                 JOptionPane.ERROR_MESSAGE);
						}
					 }
				}
				conn.rs.close();
			}
			catch(Exception ea){ea.printStackTrace();}
		}
	}

	public static void main(String args[])
	{
		ChooseCourse cc=new ChooseCourse("200501030318");
		JFrame jf=new JFrame();
		jf.setBounds(10,10,900,600);
		jf.add(cc);
		jf.setVisible(true);
	}
}
