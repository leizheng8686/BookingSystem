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
	     label1.setOpaque(true);//setOpaque(ture)������Ŀ�����������ɲ�͸��������������JLabel�������õ���ɫ��ʾ������

	     JLabel label2=new JLabel("Label 2",JLabel.CENTER);                            
	     label2.setBackground(Color.pink);
	     label2.setOpaque(true);                           

	     JLabel label3=new JLabel("Label 3",JLabel.CENTER);                            
	     label3.setBackground(Color.yellow);
	     label3.setOpaque(true);     
	     /*����label1,label2��splitPane1�У������ô�splitPane1Ϊˮƽ�ָ��Ҿ���Continuous Layout��
	      *���ܡ�
	      */
	     JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,label1,label2);
	     /*����splitPane1�ķָ���λ�ã�0.3�������splitPane1�Ĵ�С������������ֵ�ķ�Χ��0.0��1.0
	      *�С�����ʹ������ֵ������splitPane�ķָ���λ�ã����34����ʾ�����������ֵ��pixelΪ���㵥λ
	      */
	     	splitPane1.setDividerLocation(0.3);

		splitPane1.setResizeWeight(0.3);
	     /*����JSplitPane�Ƿ����չ��������(��ͬ�ļ��ܹ�һ��)����Ϊtrue��ʾ�򿪴˹��ܡ�
	      */
	     splitPane1.setOneTouchExpandable(true);
	     splitPane1.setDividerSize(10);//���÷ָ��߿�ȵĴ�С����pixelΪ���㵥λ��
	     
	     JSplitPane splitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,splitPane1,label3);
	     splitPane2.setDividerLocation(35);
	     //����JSplitPane�Ƿ����չ��������(��ͬ�ļ��ܹ�һ��),��Ϊtrue��ʾ�򿪴˹���.
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
