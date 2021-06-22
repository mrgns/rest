package entitybeans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public  Connection Dbconnection()
{
	Connection con = null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=Hello@dude1");
	}
	catch(Exception ex)
	{
		System.out.print(ex.toString());
	}
	return con;
}
}