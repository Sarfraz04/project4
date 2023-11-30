package PracticeScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TyData {
	

	
	
			public static void main(String[] args) throws SQLException 
			{
				//Register the Driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//Get connection of Database (Search in Google: mysql connection url)
				Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				
				//Create Statement
				Statement state = con.createStatement();
				String query = "select * from project;";
				
				//Execute Query
				 ResultSet result = state.executeQuery(query);
				 String id = "sarfraz";
				while(result.next())
				{
					if(result.getString(2).equals(id))
					{
						System.out.println(result.getString(1)+"-------"+result.getString(2)+"--------"+result.getString(3)+"--------"+result.getString(4)+"--------"+result.getString(5)+"--------"+result.getString(6));
						System.out.println("*Project Created*");
					}
				}
				
				//Close Database
				con.close();
			}
		
	}
	
	


