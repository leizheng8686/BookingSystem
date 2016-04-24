import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

public class SignUp extends JFrame {
	private Container c = getContentPane();
	private JLabel myTitle = new JLabel("Create an account");
	private JLabel jl_user=new JLabel("Username");
	private JLabel jl_pwd=new JLabel("Password");
	private JLabel jl_pwdConf=new JLabel("Confirm Password");
	private JTextField jtf_user=new JTextField();
	private JPasswordField jpwf=new JPasswordField();
	private JPasswordField jpwf_conf=new JPasswordField();
	private JButton jb1=new JButton("Sign Up");
	
	SignUp(){
		super("Sign Up");
		connectDB cdb = new connectDB();
		cdb.connect();
		//this.setTitle("WELCOME");
		//Image image=new ImageIcon("Stevens_Statue.png").getImage(); 
		//this.getContentPane().add(imgl);
 		//this.setIconImage(image);
		this.setResizable(false);    //can not be resized
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX=screenSize.width/2;
		int centerY=screenSize.height/2;
		int w=290;// width
		int h=320;// Height
		this.setBounds(centerX-w/2,centerY-h/2-100,w,h);//set Window in the center of screen
		this.setVisible(true);
		//jp.setBackground(Color.CYAN);    //set background color
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
