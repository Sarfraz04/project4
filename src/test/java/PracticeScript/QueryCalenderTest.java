package PracticeScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QueryCalenderTest {
	public static void main(String[] args) {
		String ExpYear="2025";
		String ExpMonth="February";
		String ExpDay="15";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		for(;;) {
			try {
				//to select the date
			
			driver.findElement(By.xpath("//span[text()='"+ExpYear+"']/parent::div//preceding-sibling::span[text()='"+ExpMonth+"']/ancestor::div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']/descendant::a[text()='"+ExpDay+"']")).click();
			break;
			}
			
			
			catch(Exception e) {
				//for next arrowbutton
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		
	}

}
}
