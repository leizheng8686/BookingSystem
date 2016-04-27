import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//student courses table
public class CourseTable extends JPanel{
	CourseTable(){
		setup();
	}
	public void setup(){
	//course table
			SpringLayout table_jsl = new SpringLayout();
			this.setLayout(table_jsl);
			this.setBackground(Color.WHITE);
			//basic info
			JLabel StuName_jl = new JLabel("Student Name: ");           //JLabel Student Name
			JLabel stuName_jl = new JLabel("Lei Zheng");
			StuName_jl.setFont(new Font("Serif", Font.BOLD, 14));
			stuName_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel StuID_jl = new JLabel("Student ID: ");				//JLabel Student ID
			JLabel stuID_jl = new JLabel("123456789");
			StuID_jl.setFont(new Font("Serif", Font.BOLD, 14));
			stuID_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel CurrentTerm_jl = new JLabel("Current Term: ");          //JLabel Current Term
			JLabel currentTerm_jl = new JLabel("2016 Fall");
			CurrentTerm_jl.setFont(new Font("Serif", Font.BOLD, 14));
			currentTerm_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			
			//set gap size between basic info labels
			this.add(StuName_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, StuName_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, StuName_jl, 20, SpringLayout.WEST, this);
			this.add(stuName_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, stuName_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, stuName_jl, 10, SpringLayout.EAST, StuName_jl);
			this.add(StuID_jl);
			Spring name_id = Spring.constant(10,50,100);
			table_jsl.putConstraint(SpringLayout.NORTH, StuID_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, StuID_jl, name_id, SpringLayout.EAST, stuName_jl);
			this.add(stuID_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, stuID_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, stuID_jl, 10, SpringLayout.EAST, StuID_jl);
			this.add(CurrentTerm_jl);
			Spring id_term = Spring.constant(10,50,100);
			table_jsl.putConstraint(SpringLayout.NORTH, CurrentTerm_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, CurrentTerm_jl, id_term, SpringLayout.EAST, stuID_jl);
			this.add(currentTerm_jl);
			Spring termMargin = Spring.constant(10,50,1000);
			table_jsl.putConstraint(SpringLayout.NORTH, currentTerm_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, currentTerm_jl, 10, SpringLayout.EAST, CurrentTerm_jl);
			table_jsl.putConstraint(SpringLayout.EAST, currentTerm_jl, termMargin, SpringLayout.EAST, this);
			
			
	}
}
