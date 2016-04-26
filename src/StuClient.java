import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;

//student client window
public class StuClient extends JFrame{
	//window size variable
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width/2;
	private int height = screenSize.height/2;

	private Container c = getContentPane();  
	// TabbedPane and items
	private JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
	//private JTextArea ta = new JTextArea(20,30);
	private JPanel courseTable_jp = new JPanel();
	private JPanel addCourse_jp = new JPanel();
	private JPanel dropCourse_jp = new JPanel();
	private JPanel grades_jp = new JPanel();
	private JScrollPane courseTable_jsp = new JScrollPane(courseTable_jp);
	private JLabel jl_addCourse = new JLabel();
	private JLabel jl_dropCourse = new JLabel();
	private JLabel jl_coursetable = new JLabel();
	private JLabel jl_grades = new JLabel();

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
		int centerX=screenSize.width/2;
		int centerY=screenSize.height/2;
		this.setBounds(centerX-width/2,centerY-height/2-100,width,height);
		
		//initialize frame
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
		tabbedPane_main.addTab("Course Table", courseTable_jsp);
		tabbedPane_main.addTab("Add Course", jl_addCourse);
		tabbedPane_main.addTab("Drop Course", jl_dropCourse);
		tabbedPane_main.addTab("Grades", jl_grades);
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
