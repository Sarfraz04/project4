package PracticeScript;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.mysql.cj.jdbc.Driver;
public class WriteDataInDataBasesAssgn{




	public static void main(String[] args) throws Throwable {
		Connection con=null;//global	
	   // int result=0;
//register the database
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//get connection for datbase
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","root");
	
	
	//create staement
	Statement state=con.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a employee name");
	String name=sc.nextLine();
	Random r=new Random();
	int random=r.nextInt(100);
	
	int age=random;
	
	String InsertQuery="insert into employe values('"+name+"',"+age+");";
	String CheckQuery="select * from employe where name='"+name+"';";
	ResultSet set=state.executeQuery(CheckQuery);
	
	if(!(set.next())){
		int result=state.executeUpdate(InsertQuery);
		if(result==1) {
			System.out.println("data insted successfully");
		}
	//	System.out.println("already exist");
	}
	else
	{
	System.out.println("data already exist");
	}
	con.close();
	}
}
			
	


