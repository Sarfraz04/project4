package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetOneWayTicketBookingTest {
public static void main(String[] args) {
	//launch empty browser
	WebDriver driver=new ChromeDriver();
	//maximize the browser
	driver.manage().window().maximize();
	driver.get("https://www.spicejet.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//div[text()='one way']")).click();
	driver.findElement(By.xpath("//div[text()='From']")).click();
	driver.findElement(By.xpath("//div[text()='India']")).click();
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	for(;;) {
		try {
			WebElement fromCity=driver.findElement(By.xpath("//div[text()='Tezpur']"));
			fromCity.click();
			break;
			
		}
		catch (NoSuchElementException e) {
			jse.executeScript("window.scrollBy(0,200)");
		}
	}
	
	
	driver.findElement(By.xpath("//div[text()='To']")).click();
	//driver.findElement(By.xpath("//div[text()='India']")).click();
	for(;;) {
		try {
			WebElement fromCity=driver.findElement(By.xpath("//div[text()='Agartala']"));
			fromCity.click();
			break;
			
		}
		catch (NoSuchElementException e) {
			jse.executeScript("window.scrollBy(0,200)");
		}
	}
}
}
