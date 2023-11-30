package dataProviderPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practiceTestNg.DataProveder1Test;

public class DataProviderTest {
	@Test(dataProviderClass =DataProveder1Test.class,dataProvider="datatravel")
/**
 * here data we are taking  from other class 
 * @param from
 * @param to
 * @param price
 */
	public void getData(String from,String to,int price) {
		System.out.println("travell from "+from+" : to"+to);
	
}
	
	@DataProvider
	public  Object[][]data(){
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
	@DataProvider
	public  Object[][]datastore(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="Banglr";
		obj[0][1]="Delhi";
		
		obj[1][0]="Banglr";
		obj[1][1]="Pune";
		
return obj;
}
}
