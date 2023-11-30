package com.onlinebanking.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.objectRepo.HomePage;
import com.objectRepo.StaffLoginPage;

public class BaseClass {
public DatabaseUtils dLib=new DatabaseUtils();
public FileUtils fLib= new FileUtils();
public ExcelUtils eLib=new ExcelUtils();
public WebDriverUtils wLib=new WebDriverUtils();
public WebDriver driver;
public static WebDriver sDriver;
@BeforeSuite
public void config_BS() throws Throwable {
	//dLib.connectDB();
	System.out.println("...comnect to data base");
	
}
  //@Parameters("BROWSER")
@BeforeClass(alwaysRun=true)
 //@before(alwysRun=true) //because its help to run the script in ececution group 
public void config_Bc() throws Throwable {
      String BROWSER=fLib.readDataFromPropertyFile("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("... invalid browser...");
	}
	sDriver=driver;
	
	wLib.maximizeWindow(driver);
}
@BeforeMethod(alwaysRun=true)
public void config_BM() throws Throwable {
	String URL=fLib.readDataFromPropertyFile("url");
	String USERNAME=fLib.readDataFromPropertyFile("username");
	String PASSWORD=fLib.readDataFromPropertyFile("password");
	
	driver.get(URL);
	wLib.waitPageLoad(driver);
	
	StaffLoginPage sLP=new StaffLoginPage(driver);   
	
	System.out.println("...logged in to application....");
	
	
}
@AfterMethod(alwaysRun=true)
public void config_AM() {
	//HomePage hp=new HomePage(driver);
	//hp.signOut(driver);
	//staff page create in pom class and click logout
	
}

@AfterClass(alwaysRun=true)
public void config_AC()throws Throwable  {
	driver.quit();
	System.out.println("....browser closed......");
	
}
@AfterSuite(alwaysRun=true)
public void config_AS () throws Throwable{
	//dLib.disconnectDB();
	System.out.println(".....disconnect the database....");
	
	
}
}
