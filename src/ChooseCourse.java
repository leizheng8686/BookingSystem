import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//choose courses
public class ChooseCourse extends JPanel{
	
	//labels
	JLabel intro = new JLabel("Please choose your courses");
	JLabel coll = new JLabel("College : ");
	JLabel dept = new JLabel("Department : ");
	JLabel major = new JLabel("Major : ");
	JLabel prof = new JLabel("Professor : ");
	JLabel weekday = new JLabel("Weekday : ");
	JLabel timepart = new JLabel("Time : ");
	JLabel blank = new JLabel(" ");
	//comboBoxes
	String coll_s[]  = {"I'm a college", "B", "C"};   	//according to database
	JComboBox coll_jcb = new JComboBox(coll_s);
	String dept_s[]  = {"I'm a department", "B", "C"};   	//according to database
	JComboBox dept_jcb = new JComboBox(dept_s);
	String major_s[]  = {"I'm a major", "B", "C"};   	//according to database
	JComboBox major_jcb = new JComboBox(major_s);
	String prof_s[]  = {"I'm a professor", "B", "C"};   	//according to database
	JComboBox prof_jcb = new JComboBox(prof_s);
	String weekday_s[]  = {"I'm weekday", "B", "C"};   	//according to database
	JComboBox weekday_jcb = new JComboBox(weekday_s);
	String timepart_s[]  = {"I'm morning", "B", "C"};   	//according to database
	JComboBox timepart_jcb = new JComboBox(timepart_s);
	
	//Constructor
	ChooseCourse(){
		makePanel();
	}
	public void makePanel(){
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		JPanel uppart = new JPanel(new GridLayout(5,1,5,5));
		JPanel downpart = new JPanel();
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,uppart,downpart);
		uppart.setBackground(Color.WHITE);
		downpart.setBackground(Color.WHITE);
		this.add(jsp);
		
		//setup labels and comboBoxes
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
		
		
	}
	
//	class itemListener implements ItemListener {
//		public void itemStateChanged(ItemEvent e) {
//		   if (e.getStateChange() == ItemEvent.SELECTED) {
//			   if(e.getItem() == coll_s[0]);
//		    
//		    
//		   } else {
//
//		   }
//		}
//	}
}
