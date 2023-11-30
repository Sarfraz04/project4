package practiceTestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExHard1Test {
	@Test
public void hardAssertTest() {
	String exp="Online Banking System";
	SoftAssert sa=new SoftAssert();
	
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	 
	driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	String actTitle=driver.getTitle();
 sa.assertEquals(actTitle, exp, "pass test case");
 
 sa.assertAll();
 System.out.println("pass");
}
}
