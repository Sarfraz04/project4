package PracticeScript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BigBasketPractice {

	@Test
	public void bigbasket() throws Throwable
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	WebElement showCategory = driver.findElement(By.xpath("//div[contains(@class,\"Menu2-sc-19kl9m3-13 ibVaum\")]//button[contains(@class,'h-full px-2.5 lg:py-1')]"));
	showCategory.click();
	Actions action=new Actions(driver);
	//action.click()showCategory).perform();
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa\"]//ul[contains(@class,'jsx-1259984711 w-56 px-2.5 bg-d')]/li[@class='jsx-1259984711']"));
	
	for(WebElement element:elements)
	{
		action.moveToElement(element).perform();
		Thread.sleep(2000);
	}
	
	}
}
