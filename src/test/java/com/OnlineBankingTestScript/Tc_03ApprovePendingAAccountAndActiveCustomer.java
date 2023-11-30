package com.OnlineBankingTestScript;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.BaseClass;
import com.onlinebanking.GenericUtils.FileUtils;

public class Tc_03ApprovePendingAAccountAndActiveCustomer extends BaseClass{
@Test
public void Tc_03() throws Exception {
	FileUtils fLiU=new FileUtils();
	
	Properties pObj=new Properties();
	pObj.setProperty("browser", "chrome");
	pObj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/");
	pObj.setProperty("staff id", "210001");
	pObj.setProperty("password", "password");
	
	//create object for FileOutPutStream
	FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\commonDataOnlineBanking.properties");
	pObj.store(fout, "Write Test Data");
	
	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\commonDataOnlineBanking.properties");
	pObj.load(fi);
	
	        String BROWSER=pObj.getProperty("browser");
			String URL=pObj.getProperty("url");
		    String STAFFID=pObj.getProperty("staff id");
		    String PASSWORD=pObj.getProperty("password");
	
	
	
	//Luanch The Browser
	WebDriver driver=new ChromeDriver();
	//maximize the browser
	driver.manage().window().maximize();
	//Enter the Url
	driver.get(URL);
	//wait page load
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//click on staff login link
	driver.findElement(By.linkText("Staff Login")).click();
	//enter staff id in staff id text fild
	driver.findElement(By.name("staff_id")).sendKeys(STAFFID);
	//enter Password in Password Text Field
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	//click on login on login button
	driver.findElement(By.name("staff_login-btn")).click();
	//click on view Active Button in Active customer button
	driver.findElement(By.name("viewdet")).click();
	//CHECK IF THE ACCOUNT NO CREATED IS PRESENT OR NOT BY SCROLLING TO THE END OF THE PAGE.
	//account no  =1011951011621 it is active or not
   
	
	
	//String	cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']")).findElement(By.xpath("//td[text()='1011951011621']")).getText();
   //validate the test case THE ACCOUNT NO WITH ALL DETAILS SHOULD BE DISPLAYED 

	String	cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
	if(cusDetail.contains("1011951011621")) {
	   System.out.println("test Case Pass");
	   
   }
	else {
		System.out.println("failed");
	}
	
	//close browser
	driver.quit();
	
 
	
	
	
	
}
}
