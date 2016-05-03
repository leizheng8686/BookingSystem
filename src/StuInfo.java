import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StuInfo extends JPanel{
	StuInfo(){
		setup();
	}
	public void setup(){
	//course table
			SpringLayout table_jsl = new SpringLayout();
			this.setLayout(table_jsl);
			this.setBackground(Color.WHITE);
			//basic info
			JLabel StuName_jl = new JLabel("Student Name:  ");          //JLabel Student Name
			JLabel stuName_jl = new JLabel("Lei Zheng");
			StuName_jl.setFont(new Font("Serif", Font.BOLD, 14));
			stuName_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel StuID_jl = new JLabel("Student ID:  ");				//JLabel Student ID
			JLabel stuID_jl = new JLabel("xxxxxxx");
			StuID_jl.setFont(new Font("Serif", Font.BOLD, 14));
			stuID_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Gender_jl = new JLabel("Gender:  ");						//JLabel Gender
			JLabel gender_jl = new JLabel("xxxxxxxx");
			Gender_jl.setFont(new Font("Serif", Font.BOLD, 14));
			gender_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Nation_jl = new JLabel("Nationality:  ");			//JLabel Nationality
			JLabel nation_jl = new JLabel("xxxxxxx");
			Nation_jl.setFont(new Font("Serif", Font.BOLD, 14));
			nation_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Birth_jl = new JLabel("Birthday:  ");				//JLabel Birthday
			JLabel birth_jl = new JLabel("xxxxxxx");
			Birth_jl.setFont(new Font("Serif", Font.BOLD, 14));
			birth_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel splitline = new JLabel("------------------------------------------------------------------------------------"); //JLabel split line
			JLabel Major_jl = new JLabel("Major:  ");						//JLabel Major
			JLabel major_jl = new JLabel("xxxxxxxx");
			Major_jl.setFont(new Font("Serif", Font.BOLD, 14));
			major_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Department_jl = new JLabel("Department:  ");			//JLabel Department
			JLabel department_jl = new JLabel("xxxxxxx");
			Department_jl.setFont(new Font("Serif", Font.BOLD, 14));
			department_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Enrolltime_jl = new JLabel("Enrollment Time:  ");				//JLabel Enrollment Time
			JLabel enrolltime_jl = new JLabel("xxxxxxx");
			Enrolltime_jl.setFont(new Font("Serif", Font.BOLD, 14));
			enrolltime_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			JLabel Gradtime_jl = new JLabel("Estimated Graduate Time:  ");				//JLabel Estimated Graduate Time
			JLabel gradtime_jl = new JLabel("xxxxxxx");
			Gradtime_jl.setFont(new Font("Serif", Font.BOLD, 14));
			gradtime_jl.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
			
			
			//set gap size between labels
			int gap = 60;
			this.add(StuName_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, StuName_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, StuName_jl, 20, SpringLayout.WEST, this);
			this.add(stuName_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, stuName_jl, 10, SpringLayout.NORTH, this);
			table_jsl.putConstraint(SpringLayout.WEST, stuName_jl, gap, SpringLayout.EAST, StuName_jl);
			this.add(StuID_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, StuID_jl, 10, SpringLayout.SOUTH, StuName_jl);
			table_jsl.putConstraint(SpringLayout.WEST, StuID_jl, 20, SpringLayout.WEST, this);
			this.add(stuID_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, stuID_jl, 10, SpringLayout.SOUTH, StuName_jl);
			table_jsl.putConstraint(SpringLayout.WEST, stuID_jl, 0, SpringLayout.WEST, stuName_jl);
			this.add(Gender_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, Gender_jl, 10, SpringLayout.SOUTH, StuID_jl);
			table_jsl.putConstraint(SpringLayout.WEST, Gender_jl, 20, SpringLayout.WEST, this);
			this.add(gender_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, gender_jl, 10, SpringLayout.SOUTH, StuID_jl);
			table_jsl.putConstraint(SpringLayout.WEST, gender_jl, 0, SpringLayout.WEST, stuName_jl);
			this.add(Nation_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, Nation_jl, 10, SpringLayout.SOUTH, Gender_jl);
			table_jsl.putConstraint(SpringLayout.WEST, Nation_jl, 20, SpringLayout.WEST, this);
			this.add(nation_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, nation_jl, 10, SpringLayout.SOUTH, Gender_jl);
			table_jsl.putConstraint(SpringLayout.WEST, nation_jl, 0, SpringLayout.WEST, stuName_jl);
			this.add(Birth_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, Birth_jl, 10, SpringLayout.SOUTH, Nation_jl);
			table_jsl.putConstraint(SpringLayout.WEST, Birth_jl, 20, SpringLayout.WEST, this);
			this.add(birth_jl);
			table_jsl.putConstraint(SpringLayout.NORTH, birth_jl, 10, SpringLayout.SOUTH, Nation_jl);
			table_jsl.putConstraint(SpringLayout.WEST, birth_jl, 0, SpringLayout.WEST, stuName_jl);
			this.add(splitline);
			table_jsl.putConstraint(SpringLayout.NORTH, splitline, 10, SpringLayout.SOUTH, Birth_jl);
			table_jsl.putConstraint(SpringLayout.WEST, splitline, 20, SpringLayout.WEST, this);
			
			
	}
}

