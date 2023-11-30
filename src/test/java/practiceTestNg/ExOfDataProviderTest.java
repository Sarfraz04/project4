package practiceTestNg;

import org.testng.annotations.DataProvider;

public class ExOfDataProviderTest {
	@DataProvider
 public Object[][] data(){
	 Object obj[][]=new Object[3][3];
	 obj[0][0]="sarfraz";
	 obj[0][1]=23;
	 obj[0][2]="patna";
	 
	 obj[1][0]="nidhi";
	 obj[1][1]=23;
	 obj[1][2]="patna";
	 
	 obj[2][0]="ashirwad";
	 obj[2][1]=26;
	 obj[2][2]="bhubneswar";
		
 return obj;
 
 
 }
}

