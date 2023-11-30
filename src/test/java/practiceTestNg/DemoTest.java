package practiceTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.BaseClass;

public class DemoTest extends BaseClass{
	@Test(groups="regression")
	
	
	public void demo3_Test() {
		//WebDriver driver=new ChromeDriver();
		
		System.out.println("demo 3");
	}
	
	@Test
	public void demo4_Test() {
		System.out.println("demo 4");
	}
}
