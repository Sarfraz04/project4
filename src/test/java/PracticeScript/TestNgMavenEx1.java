package PracticeScript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNgMavenEx1 {
	@Test
	public void amazon() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName="usa";
		List<WebElement> ele =driver.findElements(By.xpath("//table//tr[*]/td[2]//span[2]"));
		boolean flag=false;
		for(WebElement webele:ele) {
			String countryNames=webele.getText();
			if(countryNames.equals(countryName)){
				System.out.println("is present");
				flag=true;
				break;
				
				
			}
		}
		if(flag) {
			System.out.println("not present");
		}
		
		}

}
