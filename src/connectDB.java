import java.sql.*;
import java.util.*;

//connect MySQL
//define actionMethod to MySQL
public class connectDB {
	String host = "localhost";
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
		
	//connect to local MySQL database
	public connectDB(){
			try
			{//load JDBC driver, make Connection and Statement
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://"+host+"/courseBooking","root","");
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
