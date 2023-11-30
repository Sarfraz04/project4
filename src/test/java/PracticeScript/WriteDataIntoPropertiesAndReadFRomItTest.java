package PracticeScript;
// online banking test yantra
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertiesAndReadFRomItTest {
	public static void main(String[] args) throws Exception {
		
	
	//create Object for Properties class
			Properties pObj=new Properties();
			pObj.setProperty("browser", "chrome");
			pObj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/");
			pObj.setProperty("staff id", "210001");
			pObj.setProperty("pasword", "password");
			
			//create object for FileOutPutStream
			FileOutputStream fout=new FileOutputStream(".\\src\\main\\resources\\testData.properties");
			pObj.store(fout, "Write Test Data");
			
			FileInputStream fi=new FileInputStream(".\\src\\main\\resources\\testData.properties");
			pObj.load(fi);
			
			        String BROWSER=pObj.getProperty("browser");
					String URL=pObj.getProperty("url");
				    String USERNAME=pObj.getProperty("staff id");
				    String PASSWORD=pObj.getProperty("paswword");
				   /*  //to know it is entered or not print
				    System.out.println(BROWSER);
				    System.out.println(URL);
				    System.out.println(USERNAME);
				    System.out.println(PASSWORD);
				    
			*/
				   WebDriver driver=new ChromeDriver();
				    driver.manage().window().maximize();
				    driver.get(URL);
				    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
				    driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				  // driver.findElement(By.id("email")).sendKeys(USERNAME);
				    
				   // driver.findElement(By.id("pass")).sendKeys(PASSWORD);
				  //  driver.findElement(By.id("loginbutton")).click();
			
			
			
			
			}

	}

