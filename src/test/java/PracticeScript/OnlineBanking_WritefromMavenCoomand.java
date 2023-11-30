package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//online banking login by maven commend data read from commond 
//it is a coomond
//rmgtestingserver/domain/Online_Banking_System/ -DstaffId=210001 -Dpassword=password -Dtest=OnlineBanking_WritefromMavenCoomand test
public class OnlineBanking_WritefromMavenCoomand {
@Test
public void cmdParametertest() {
	String Browser=System.getProperty("browser");//browser here key
	String url=System.getProperty("url");
	String staffid=System.getProperty("staffId");
	String password=System.getProperty("password");
	WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
   driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
    
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	   driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();

	
}
}
