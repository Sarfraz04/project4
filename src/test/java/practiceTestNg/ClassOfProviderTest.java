package practiceTestNg;

import org.testng.annotations.Test;

public class ClassOfProviderTest {
	@Test(dataProviderClass=ExOfDataProviderTest.class,dataProvider="data")
	public void getData(String name,int age,String place) {
		System.out.println(name+ " "+age +" "+place);
	}

}
