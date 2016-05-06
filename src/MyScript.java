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
public class MyScript extends JPanel{
	
	private String host;
	private String stuID;
	
	//connect to MySQL database
	//private connectDB conn = new connectDB();
	//panels
	private JSplitPane jsplit;
	private JPanel jp;
	private JPanel uppart;
	private JPanel downpart;
	//uppart
	private JLabel intro = new JLabel("Please choose your courses");
	private JLabel coll = new JLabel("College : ");
	private JLabel dept = new JLabel("Department : ");
	private JLabel major = new JLabel("Major : ");
	private JLabel prof = new JLabel("Professor : ");
	private JLabel weekday = new JLabel("Weekday : ");
	private JLabel timepart = new JLabel("Time : ");
	private JLabel blank = new JLabel(" ");
	
	private JComboBox coll_jcb = new JComboBox();
	private JComboBox dept_jcb = new JComboBox();
	private JComboBox major_jcb = new JComboBox();
	private JComboBox prof_jcb = new JComboBox();
	private JComboBox weekday_jcb = new JComboBox();
	private JComboBox timepart_jcb = new JComboBox();
	private Vector coll_v = new Vector();
	private Vector dept_v = new Vector();
	private Vector major_v = new Vector();
	private Vector prof_v = new Vector();
	private Vector weekday_v = new Vector();
	private Vector timepart_v = new Vector();
	
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
	public MyScript(){
		 JFrame f=new JFrame("JSplitPaneDemo");
	     Container contentPane=f.getContentPane();
	     JLabel label1=new JLabel("Label 1",JLabel.CENTER);                            
	     label1.setBackground(Color.green);
	     label1.setOpaque(true);//setOpaque(ture)方法的目的是让组件变成不透明，这样我们在JLabel上所设置的颜色显示出来。

	     JLabel label2=new JLabel("Label 2",JLabel.CENTER);                            
	     label2.setBackground(Color.pink);
	     label2.setOpaque(true);                           

	     JLabel label3=new JLabel("Label 3",JLabel.CENTER);                            
	     label3.setBackground(Color.yellow);
	     label3.setOpaque(true);     
	     /*加入label1,label2到splitPane1中，并设置此splitPane1为水平分割且具有Continuous Layout的
	      *功能。
	      */
	     JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,label1,label2);
	     /*设置splitPane1的分隔线位置，0.3是相对于splitPane1的大小而定，因此这个值的范围在0.0～1.0
	      *中。若你使用整数值来设置splitPane的分隔线位置，如第34行所示，则所定义的值以pixel为计算单位
	      */
	     	splitPane1.setDividerLocation(0.3);

		splitPane1.setResizeWeight(0.3);
	     /*设置JSplitPane是否可以展开或收起(如同文件总管一般)，设为true表示打开此功能。
	      */
	     splitPane1.setOneTouchExpandable(true);
	     splitPane1.setDividerSize(10);//设置分隔线宽度的大小，以pixel为计算单位。
	     
	     JSplitPane splitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,splitPane1,label3);
	     splitPane2.setDividerLocation(35);
	     //设置JSplitPane是否可以展开或收起(如同文件总管一般),设为true表示打开此功能.
	     splitPane2.setOneTouchExpandable(false);
	     splitPane2.setDividerSize(5);
	     
	     contentPane.add(splitPane2);
	     
	      f.setSize(250,200);
	      f.show();
	      f.addWindowListener(
	           new WindowAdapter(){
	               public void windowClosing(WindowEvent e){
	                  System.exit(0);        
	               }        
	           }        
	      );   
	}
	
	

	public static void main(String args[])
	{
		MyScript cc=new MyScript();
	}
}
