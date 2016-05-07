import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//drop course
public class DropCourse extends JFrame implements ActionListener{
	
	private String host="127.0.0.1:3306";
	private String stuID;
	private GetStuInfo getsi;
	
	private JLabel currentCourses = new JLabel("Your Current Course:");
	private JTable course = new JTable();
	private JButton drop=new JButton("drop");
	private connectDB conn = new connectDB();
	//private JTable jt;
	private JScrollPane jsp;
	private Vector<String> v_head=new Vector<String>();
	private Vector<Vector> v_data=new Vector<Vector>();
	private Vector<String> v_couid=new Vector<String>();
	private SpringLayout jspring;
	
	public DropCourse(String stuID){
		this.stuID=stuID;
		getsi=new GetStuInfo(host);
		makePanel();
	}
	
	public void makePanel(){
		this.add(currentCourses);
		//currentCourses.setBounds(40,40,20,10);
		jspring = new SpringLayout();
		this.setLayout(jspring);
		this.setVisible(true);
		this.setBackground(Color.white);
		jspring.putConstraint(SpringLayout.NORTH, currentCourses, 20, SpringLayout.SOUTH, jsp);
		jspring.putConstraint(SpringLayout.EAST, currentCourses, 20, SpringLayout.WEST, jsp);
		
		DefaultTableModel dtm=new DefaultTableModel(v_data,v_head);
		course=new JTable(dtm);
		jsp=new JScrollPane(course);
		jsp.setBackground(Color.WHITE);
		this.add(jsp);
		jspring.putConstraint(SpringLayout.NORTH, jsp, 50, SpringLayout.NORTH, this);
		jspring.putConstraint(SpringLayout.WEST, jsp, 20, SpringLayout.WEST, this);
		jspring.putConstraint(SpringLayout.EAST, jsp, 756, SpringLayout.WEST, this);
		
		drop.setSize(50,30);
		this.add(drop);
		drop.setVisible(true);
		jspring.putConstraint(SpringLayout.NORTH, drop, 20, SpringLayout.SOUTH, jsp);
		jspring.putConstraint(SpringLayout.EAST, drop, 700, SpringLayout.WEST, jsp);
		//this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] arg){
		DropCourse a=new DropCourse("a");
	}
}
