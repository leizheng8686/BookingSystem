import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//administration client window
public class adminClient extends JFrame{
	private String host;
	private String adminID;
	private String stuID;
	//window size variable
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width/2;
	private int height = screenSize.height/2;

	private Container c = getContentPane();  
	//setPreferredSize(new Dimension(725,50));
	// TabbedPane and items
	private JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	//private JTextArea ta = new JTextArea(20,30);
	private StuInfo stuInfo_jp;
	private courseManagement courseM_jp;
	private gradeManagement gradeM_jp;
	//private JScrollPane courseTable_jsp = new JScrollPane();

	//Buttons
//	private JButton addCourse;
//	private JButton dropCourse;
//	private JButton courseTable;
//	private JButton Grades;
	
	// Menu and items
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	private JMenuItem setting = new JMenuItem("Setting");
	private JMenuItem signout = new JMenuItem("Sign Out");
	
	public adminClient(String adminID){
		//initialize window title and size
		super("SIT Course System Client for Administrator");
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int centerX=screenSize.width/2;
		int centerY=screenSize.height/2;
		this.setLocation(centerX-width/2,centerY-height/2-100);
		this.setSize(new Dimension(860,600));
		tabbedPane_main.setBackground(Color.WHITE);

		this.adminID = adminID;

		//create new panels
		stuInfo_jp = new StuInfo(this.stuID,host);
		courseM_jp = new courseManagement();
		//dropCourse_jp = new DropCourse(this.stuID,host);
		gradeM_jp = new gradeManagement();
		//initialize frame
		setMenu();
		setMainFrame();
	}
	
	//set menu	
	private void setMenu(){
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(setting);
		menu.add(signout);
	}
	
	private void setMainFrame(){
		tabbedPane_main.addTab(" Student Management  ", stuInfo_jp);
		tabbedPane_main.addTab("  Course Management  ", courseM_jp);
		tabbedPane_main.addTab("  Grades Management  ", gradeM_jp);

		c.add(tabbedPane_main);
		
	}
	
	public void addListener(){
		//Menu items
		setting.addActionListener(new menuActionListener());
		signout.addActionListener(new menuActionListener());
		
		
	}
	
	public class menuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	//set action when the tab is changed
	public class myChangeListener  implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			//courseTable_jp.updateCourseTable();
		}
	}
	
	public static void main(String[] arg){
		new adminClient("Lei");
	}
}
