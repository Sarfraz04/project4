package PracticeScript;


	

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class MakeMyTripCalender_popPup {
		public static void main(String[] args) {
			//choose date in int form
			int actualdate = 7 ;
			//choose month and year 
			String actualmonth = "November 2024";
			//launch empty browser
			WebDriver driver = new ChromeDriver();
			//maximize the browser
			driver.manage().window().maximize();
			//navigate the url
			driver.get("https://www.makemytrip.com/flights/?");
			//wait for load page
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			// driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
			//create action class 
			Actions action = new Actions(driver);
			//click on webpage
			action.doubleClick().perform();
			//find depture xpath
			driver.findElement(By.xpath("//span[text()='Departure']")).click();
			//create infinty loop
			for (;;) {
				try {
					//xpath ofclender date
					driver.findElement(By.xpath("//div[text()='" + actualmonth
							+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + actualdate + "']"))
							.click();
					break;
				} catch (Exception e) {
					driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				}

				
			}
		}

	}

