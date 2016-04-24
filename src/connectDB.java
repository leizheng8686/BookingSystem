import java.sql.*;
import java.util.*;

//connect MySQL
//define actionMethod to MySQL
public class connectDB {
	String host = "localhost";
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
		
	//connect to local MySQL database
	public void connect(){
			try
			{//load JDBC driver, make Connection and Statement
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://"+host+"/test","root","");
				stmt=conn.createStatement();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		public void closeConn()
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
}
