package PracticeScript;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class NonSelectQueryex2 {
	

	

	
		public static void main(String[] args) throws Throwable {
			Connection con=null;//global	
			int result=0;
	//register the database
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection for datbase
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		
		//create staement
		Statement state=con.createStatement();
		String query="insert into student values('sarfraz','34567',76);";
		
		//executeUpdate query
		 result=state.executeUpdate(query);
		if(result==1) {
			System.out.println("data inserted is successfully");
		}
		else {
			System.out.println("data inserted is not successfully");
		}
		
		
			//to handle exception here but now no exception 
		
	
			con.close();
		//close database
		}
	}
	



