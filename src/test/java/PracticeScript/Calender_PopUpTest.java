package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_PopUpTest {
public static void main(String[] args) {
	//launch the empty browser
	WebDriver driver=new ChromeDriver();
	
	//maximise the browser
	driver.manage().window().maximize();
	
	//enter the url
	driver.get("https://www.ksrtc.in");
	//wait for page load
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
	//click on departure date
	driver.findElement(By.id("txtJourneyDate")).click();
	//select date
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
	//close the browser
	driver.quit();
}

}
