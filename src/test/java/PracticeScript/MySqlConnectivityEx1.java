package PracticeScript;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class MySqlConnectivityEx1 {
public static void main(String[] args) throws SQLException {
	//register the driver
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//get connection of data base
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	
	//create staement
	Statement state=con.createStatement();
	String query="select * from student;";
	
	
	
	//executed result
	ResultSet result=state.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		
	}
	//close database
}
}