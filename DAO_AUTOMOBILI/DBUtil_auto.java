package DAO_AUTOMOBILI;
import java.sql.*;
public class DBUtil_auto {
	public static Connection connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost/dao_auto";
			// Database credentials
			String USER = "root";
			String PASS = "";
			Connection con=	DriverManager.getConnection(DB_URL,USER,PASS);
			return con;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
