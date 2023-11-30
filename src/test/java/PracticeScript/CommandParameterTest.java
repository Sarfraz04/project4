package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//command maven
public class CommandParameterTest {
@Test
public void cmdParametertest() {
	String Browser=System.getProperty("browser");//browser here key
	String url=System.getProperty("url");
	String userName=System.getProperty("username");
	String password=System.getProperty("password");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	   driver.findElement(By.id("email")).sendKeys(userName);
	    
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.id("loginbutton")).click();
	    
	   


	
	
}

}
