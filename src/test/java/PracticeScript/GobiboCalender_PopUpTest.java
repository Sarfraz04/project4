package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GobiboCalender_PopUpTest {
public static void main(String[] args) {
	String monthAndYear="November 2024";
	int date=15;
	//launch the empty browser
	WebDriver driver=new ChromeDriver();
	//maximise the browser
	driver.manage().window().maximize();
	//navigate the url
	driver.get("https://www.goibibo.com/");
	//wait for page load
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//close login pop-up
	driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	//click on deptrature 
	driver.findElement(By.xpath("//span[text()='Departure']")).click();
	for(;;) {
		try {
			//to select the date
		
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		break;
		}
		
		
		catch(Exception e) {
			//for next arrowbutton
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}
 driver.findElement(By.xpath("//span[text()='Done']")).click();
}
}
