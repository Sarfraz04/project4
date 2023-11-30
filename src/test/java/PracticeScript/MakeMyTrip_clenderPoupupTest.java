package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip_clenderPoupupTest {
public static void main(String[] args) throws InterruptedException {
	//launch the browser
	WebDriver driver=new ChromeDriver();
	// maximize the browser
	driver.manage().window().maximize();
	//navigate the url
	driver.get("https://www.makemytrip.com/");
	//wait page load
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	Actions act=new Actions(driver);
	Thread.sleep(3000);
	act.doubleClick().perform();
	Thread.sleep(3000);
	act.doubleClick().perform();
	//driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	//driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	
}
}
