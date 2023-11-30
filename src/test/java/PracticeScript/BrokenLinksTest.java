package PracticeScript;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;

public class BrokenLinksTest {
public static void main(String[] args) throws IOException  {
	//launch empty browser
	WebDriver driver=new ChromeDriver();
	//maximise the browser
	driver.manage().window().maximize();
	driver.get("https://www.airindia.com/");
	//wait page load
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//find all links present in webpage
	
	List<WebElement> AllLinks= driver.findElements(By.xpath("//a"));
System.out.println(AllLinks.size());
//create empty array to store all broken links
ArrayList<String> ArraLink= new ArrayList<String>();
//apply for loop to get attribute name
	for(int i=0;i<AllLinks.size();i++) {
		String eachLink=AllLinks.get(i).getAttribute("href");
		URL url=null;
		int statuscode=0;
		
		try {
			url=new URL(eachLink);
			HttpURLConnection httpsurlconn=(HttpURLConnection) url.openConnection();
			statuscode= httpsurlconn.getResponseCode();
			if(statuscode >=400) {
				ArraLink.add(eachLink);
				System.out.println(eachLink+"-Broken--> " +statuscode);
			}
		}
		catch(MalformedURLException e) {
			System.out.println(eachLink+" -------->"+statuscode);
			
		}
		
		//driver.quit();		
	}
}
}