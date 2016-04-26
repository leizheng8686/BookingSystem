import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;

//student client window
public class StuClient extends JFrame{
	
	private Container c = getContentPane();  
	// TabbedPane and items
	private JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
	private JLabel jl_addCourse = new JLabel("Add Course");
	private JLabel jl_dropCourse = new JLabel("Drop Course");
	private JLabel jl_coursetable = new JLabel("Course Table");
	private JLabel jl_grades = new JLabel("Grades");
	
	//Buttons
//	private JButton addCourse;
//	private JButton dropCourse;
//	private JButton courseTable;
//	private JButton Grades;
	
	// Menu and items
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	private JMenuItem menuItem = new JMenuItem("Setting");
	
	StuClient(String ID){
		//initialize window title and size
		super("SIT Course System Client for Student");
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX=screenSize.width/2;
		int centerY=screenSize.height/2;
		int width = screenSize.width/2;
		int height = screenSize.height/2;
		this.setBounds(centerX-width/2,centerY-height/2-100,width,height);
		
		setMenu();
		setMainFrame();
	}
	
	//set menu	
	private void setMenu(){
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(menuItem);
	}
	
	private void setMainFrame(){
		tabbedPane_main.add(jl_addCourse.getText(), jl_addCourse);
		c.add(tabbedPane_main);
	}
	
	public void addListener(){
		menuItem.addActionListener(new menuActionListener());
	}
	
	public class menuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	
	public static void main(String[] arg){
		new StuClient("123456789");
	}
}
