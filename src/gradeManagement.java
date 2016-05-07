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

public class gradeManagement extends JPanel{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width/2;
	private int height = screenSize.height/2;
	
	private connectDB conn = new connectDB(); //connect to database
	//JPanels
	private JPanel search_jp; // for major search
	private JPanel grid_jp;  //for comboxBox
	private JScrollPane jsp;  //for course table
	//Layout
	private SpringLayout jspring;
	//JLabels
	private JLabel coll = new JLabel("College : ");
	private JLabel dept = new JLabel("Department : ");
	private JLabel major = new JLabel("Major : ");
	private JLabel prof = new JLabel("Professor : ");
	//JTextField
	private JTextField search_tf = new JTextField("Please type a course ID");
	//JComboBoxes
	private JComboBox coll_jcb = new JComboBox();
	private JComboBox dept_jcb = new JComboBox();
	private JComboBox major_jcb = new JComboBox();
	private JComboBox prof_jcb = new JComboBox();
	//Vectors for setting JComboBox items
	private Vector coll_v = new Vector();
	private Vector dept_v = new Vector();
	private Vector major_v = new Vector();
	private Vector prof_v = new Vector();
	//JButtons
	private JButton search_jb = new JButton("Search");// delete-course button
	private JButton edit_jb = new JButton("View and Edit");// edit-course button
	//JTable for course list
	private JTable jt;
	//Vector for table header and content
	private Vector<String> v_head=new Vector<String>();
	private Vector<Vector> v_data=new Vector<Vector>();
	
	//define table model to make cells not editable but selectable
	public class MyTableModel extends DefaultTableModel{ 
		public MyTableModel(Vector<Vector> v_data, Vector<String> v_head)
		{
			super(v_data, v_head);
		}
	    public boolean isCellEditable(int row, int column) { 
		   return false;
	    }
   }
	
	public gradeManagement(){
		jspring = new SpringLayout();
		this.setLayout(jspring);
		this.setVisible(true);
		this.setBackground(new Color(255,250,240));
		makePanel();
		addListener();
	}
	
	public void initialData(){
		this.initialCombox_coll();
		this.initialCombox_dept();
		this.initialCombox_major();
		this.initialCombox_prof();
		this.initialTable("","","","","","");//initialize table data

	}
	
	public void makePanel(){
		jspring = new SpringLayout();
		this.setLayout(jspring);
		this.setVisible(true);
		//this.setSize(800,600);
		this.setBackground(Color.WHITE);
		grid_jp = new JPanel(new GridLayout(3,1,5,5));
		grid_jp.setBackground(Color.WHITE);
		
		//options area
		JPanel coll_dept = new JPanel(new GridLayout(1,4,10,0));
		coll_dept.add(coll);
		coll_dept.add(coll_jcb);
		coll_dept.add(dept);
		coll_dept.add(dept_jcb);
		grid_jp.add(coll_dept);
		JPanel major_prof = new JPanel(new GridLayout(1,4,10,0));
		major_prof.add(major);
		major_prof.add(major_jcb);
		major_prof.add(prof);
		major_prof.add(prof_jcb);
		grid_jp.add(major_prof);
		grid_jp.add(new JLabel());
		//set the options area location
		this.add(grid_jp);
		jspring.putConstraint(SpringLayout.NORTH, grid_jp, 10, SpringLayout.NORTH, this);
		jspring.putConstraint(SpringLayout.WEST, grid_jp, 20, SpringLayout.WEST, this);
		jspring.putConstraint(SpringLayout.EAST, grid_jp, 756, SpringLayout.WEST, this);
		
		//table 
		//DefaultTableModel dtm=new DefaultTableModel(v_data,v_head);
		MyTableModel tm = new MyTableModel(v_data,v_head);
		jt = new JTable(tm);// create JTable for course info
		jsp = new JScrollPane(jt);//put JTable in JScrollPane
		jsp.setBackground(Color.WHITE);
		
		//set the table location
		this.add(jsp);
		jspring.putConstraint(SpringLayout.NORTH, jsp, 10, SpringLayout.SOUTH, grid_jp);
		jspring.putConstraint(SpringLayout.WEST, jsp, 20, SpringLayout.WEST, this);
		jspring.putConstraint(SpringLayout.EAST, this, 20, SpringLayout.EAST, jsp);
		jspring.putConstraint(SpringLayout.SOUTH, jsp, 200, SpringLayout.NORTH, jsp);
		//set the View-and-Edit button location
		edit_jb.setSize(100, 30);
		this.add(edit_jb);
		jspring.putConstraint(SpringLayout.NORTH, edit_jb, 0, SpringLayout.SOUTH, grid_jp);
		jspring.putConstraint(SpringLayout.WEST, edit_jb, 350, SpringLayout.WEST, this);
		
	}
	
	public void addListener(){
		edit_jb.addActionListener(new myActionListener());
		search_jb.addActionListener(new myActionListener());
		coll_jcb.addItemListener(new itemListener());
		dept_jcb.addItemListener(new itemListener());
		major_jcb.addItemListener(new itemListener());
		prof_jcb.addItemListener(new itemListener());
	}
	
	public class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == edit_jb){
				if(isSelected())
					new makeEditWin();
			}
			if(e.getSource() == search_jb){
					try{
						String courseID = search_tf.getText();
						String sql = "select * from grade where courseID='"+courseID+"'";
						conn.rs = conn.stmt.executeQuery(sql);
						if(conn.rs.next()){//successful
							updateTable(courseID);
						}
						else
						{//failed
							JOptionPane.showMessageDialog(getParent(),"Not Available! No student took this course(ID:"+courseID+").","Error",
							                                 JOptionPane.ERROR_MESSAGE);
							
						}
					}catch(Exception E){E.printStackTrace();}
			}
		}
	}
	
	class itemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
		   if (e.getStateChange() == ItemEvent.SELECTED) { //update table when options are changed
			   if(e.getSource() == coll_jcb){
				   initialCombox_dept();
				   initialCombox_major();
			   }
			   if(e.getSource() == dept_jcb){
				   initialCombox_major();
			   }

			   updateTable();
		   } 
		}
	}
	//View-and-Edit window
	public class makeEditWin{
		
	}
	
	//initialize college items
	public void initialCombox_coll(){
		try{
			String sql="select distinct collName from college";
			conn.rs=conn.stmt.executeQuery(sql);
			coll_jcb.removeAllItems();
			coll_jcb.addItem("All");
			while(conn.rs.next()){
				coll_jcb.addItem(conn.rs.getString(1));
			}
			conn.rs.close();
			}
			catch(Exception e){e.printStackTrace();}
			
	}
	
	public void initialCombox_dept(){
		//initialize combox_dept according to coll_jcb selected item
		if(coll_jcb.getSelectedItem().equals("All")){
			try{
				dept_jcb.removeAllItems();
				dept_jcb.addItem("All");
				String sql = "select distinct deptName from dept";
				conn.rs = conn.stmt.executeQuery(sql);
				while(conn.rs.next()){
					dept_jcb.addItem(conn.rs.getString(1));
				}
				conn.rs.close();
			}catch(Exception e){e.printStackTrace();}
		}else{
			try{
				dept_jcb.removeAllItems();
				dept_jcb.addItem("All");
				String sql = "select collID from college where collName='"+coll_jcb.getSelectedItem()+"'";
				conn.rs = conn.stmt.executeQuery(sql);
				conn.rs.next();
				String collID = conn.rs.getString(1);
				sql = "select distinct deptName from dept where collID='"+collID+"'";
				conn.rs = conn.stmt.executeQuery(sql);
				while(conn.rs.next()){
					dept_jcb.addItem(conn.rs.getString(1));
				}
			}catch(Exception e){e.printStackTrace();}
		}
	}

	public void initialCombox_major(){
		//initialize combox_major according to coll_jcb and combox_dept selected items
				if(dept_jcb.getSelectedItem().equals("All")){//dept is all
					if(coll_jcb.getSelectedItem().equals("All")){ // college is all
						try{
							major_jcb.removeAllItems();
							major_jcb.addItem("All");
							String sql = "select distinct majorName from major";
							conn.rs = conn.stmt.executeQuery(sql);
							while(conn.rs.next()){
								major_jcb.addItem(conn.rs.getString(1));
							}
							conn.rs.close();
						}catch(Exception e){e.printStackTrace();}
					}else{//college is specific
						try{
							major_jcb.removeAllItems();
							major_jcb.addItem("All");
							String sql = "select collID from college where collName='"+coll_jcb.getSelectedItem()+"'";
							conn.rs = conn.stmt.executeQuery(sql);
							conn.rs.next();
							String collID = conn.rs.getString(1);
							sql = "select distinct majorName from major where collID='"+collID+"'";
							conn.rs = conn.stmt.executeQuery(sql);
							while(conn.rs.next()){
								major_jcb.addItem(conn.rs.getString(1));
							}
							conn.rs.close();
						}catch(Exception e){e.printStackTrace();}
					}
				}else{ // dept is specific
					try{
						major_jcb.removeAllItems();
						major_jcb.addItem("All");
						String sql = "select deptID from dept where deptName='"+dept_jcb.getSelectedItem()+"'";
						conn.rs = conn.stmt.executeQuery(sql);
						conn.rs.next();
						String deptID = conn.rs.getString(1);
						if(coll_jcb.getSelectedItem().equals("All")){//college is all
							sql = "select distinct majorName from major where deptID='"+deptID+"'";
							conn.rs = conn.stmt.executeQuery(sql);
							while(conn.rs.next()){
								major_jcb.addItem(conn.rs.getString(1));
							}
						}else{// college is specific
								sql = "select collID from college where collName='"+coll_jcb.getSelectedItem()+"'";
								conn.rs = conn.stmt.executeQuery(sql);
								conn.rs.next();
								String collID = conn.rs.getString(1);
								sql = "select distinct majorName from major where collID='"+collID+"' and deptID='"+deptID+"'";
								conn.rs = conn.stmt.executeQuery(sql);
								while(conn.rs.next()){
									major_jcb.addItem(conn.rs.getString(1));
								}
						}
						conn.rs.close();
					}catch(Exception e){e.printStackTrace();}
				}
	}
	
	public void initialCombox_prof(){
		try{//initialize professor options
			String sql="select distinct teacher from courseinfo";
			conn.rs=conn.stmt.executeQuery(sql);
			prof_jcb.removeAllItems();
			prof_jcb.addItem("All");
			while(conn.rs.next()){
				prof_jcb.addItem(conn.rs.getString(1));
			}
			conn.rs.close();
			}
			catch(Exception e){e.printStackTrace();}
	}
	
		//initialize table header and data
		public void initialTable(String coll, String dept, String major, String prof, String wday, String timepart)
		{   //initialize table head
			v_head.add("Course ID");v_head.add("Course Name");v_head.add("Instructor");
			v_head.add("Credits");v_head.add("Average Score");
			updateTable();
		}
		
		//update table data
		public void updateTable(){
			try{//initialize table
				String sql="select grade.courseID, grade.courseName, grade.instructor,"+
				           "grade.credit, avg(grade.score) from grade where grade.score>-1 "
						+ getSQL_college() + getSQL_dept() + getSQL_major() + getSQL_prof() ;
				          								  
				conn.rs=conn.stmt.executeQuery(sql);
				v_data.clear();
				while(conn.rs.next()){
					Vector v = new Vector();
					String courseID = conn.rs.getString(1);
					String courseName=conn.rs.getString(2);
					String instructor=conn.rs.getString(3);
					String credit=conn.rs.getString(4);
					String AvgScore=conn.rs.getString(5);
					
					v.add(courseID);v.add(courseName);v.add(instructor);v.add(credit);v.add(AvgScore);
					v_data.add(v);
				}
				//DefaultTableModel tmodel=new DefaultTableModel(v_data,v_head);
				MyTableModel tm = new MyTableModel(v_data,v_head);
				jt.setModel(tm);
			}
			catch(Exception e){e.printStackTrace();}
			finally{try{conn.rs.close();}catch(Exception E){E.printStackTrace();}
			}
		}
		public void updateTable(String courseId){
			try{//initialize table
				String sql="select grade.courseID, grade.courseName, grade.instructor,"+
				           "grade.credit, avg(grade.score) from grade where grade.courseID='"+courseId+"'" ;        								  
				conn.rs=conn.stmt.executeQuery(sql);
				v_data.clear();
				while(conn.rs.next()){
					Vector v = new Vector();
					String courseID = conn.rs.getString(1);
					String courseName=conn.rs.getString(2);
					String instructor=conn.rs.getString(3);
					String credit=conn.rs.getString(4);
					String AvgScore=conn.rs.getString(5);
					
					v.add(courseID);v.add(courseName);v.add(instructor);v.add(credit);v.add(AvgScore);
					v_data.add(v);
				}
				//DefaultTableModel tmodel=new DefaultTableModel(v_data,v_head);
				MyTableModel tm = new MyTableModel(v_data,v_head);
				jt.setModel(tm);
				//TODO: initialize comboBox
			}
			catch(Exception e){e.printStackTrace();}
			finally{try{conn.rs.close();}catch(Exception E){E.printStackTrace();}
			}
		}
	
	public String getSQL_college(){
		String coll = (String)(coll_jcb.getSelectedItem());
		if(coll.equals("All"))
			coll = "";
		else{
			try{
				String sql = "select collID from college where collName='"+coll+"' ";
				conn.rs = conn.stmt.executeQuery(sql);
				conn.rs.next();
				String collID = conn.rs.getString(1);
				coll = " and course.collID = '"+collID+"'";
				conn.rs.close();
			}catch(Exception e){e.printStackTrace();}
		}
		return coll;
	}
	public String getSQL_dept(){
		String dept = (String)(dept_jcb.getSelectedItem());
		if(dept.equals("All"))
			dept = "";
		else{
			try{
				String sql = "select deptID from dept where deptName='"+dept+"'";
				conn.rs = conn.stmt.executeQuery(sql);
				conn.rs.next();
				String deptID = conn.rs.getString(1);
				dept = " and course.deptID = '"+deptID+"' ";
				conn.rs.close();
			}catch(Exception e){e.printStackTrace();}
		}
		return dept;
	}
	public String getSQL_major(){
		String major = (String)(major_jcb.getSelectedItem());
		if(major.equals("All"))
			major = "";
		else{
			try{
				String sql = "select majorID from major where majorName='"+major+"'";
				conn.rs = conn.stmt.executeQuery(sql);
				conn.rs.next();
				String majorID = conn.rs.getString(1);
				major = " and course.majorID = '"+majorID+"' ";
				conn.rs.close();
			}catch(Exception e){e.printStackTrace();}
		}
		return major;
	}
	public String getSQL_prof(){
		String prof = (String)(prof_jcb.getSelectedItem());
		if(prof.equals("All"))
			prof = "";
		else{
			prof = " and courseinfo.teacher = '"+prof+"' ";
		}
		return prof;
	}
	//is any table row selected?
	public boolean isSelected(){
		if(jt.getSelectedRow() == -1){//no course selected
			JOptionPane.showMessageDialog(this,"Please select a course.","Error",
			                               JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static void main(String[] arg){
		gradeManagement cc=new gradeManagement();
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(10,10,900,600);
		jf.add(cc);
		jf.setVisible(true);
	}
}
