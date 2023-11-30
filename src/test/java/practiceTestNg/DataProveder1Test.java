package practiceTestNg;

import org.testng.annotations.DataProvider;

public class DataProveder1Test {
	@DataProvider
	public  Object[][]datatravel(){
		Object[][] obj=new Object[4][3];
		obj[0][0]="Banglr";
		obj[0][1]="Delhi";
		obj[0][2]=1000;
		
		obj[1][0]="Banglr";
		obj[1][1]="Pune";
		obj[1][2]=30000;
		
		obj[2][0]="patna";
		obj[2][1]="kolkata";
		obj[2][2]=7000;
		
		obj[3][0]="patna";
		obj[3][1]="kolkata";
		obj[3][2]=7000;
		return obj;
		
	}

}
