package com.OnlineBankingTestScript;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.IpathConstants;
import com.onlinebanking.GenericUtils.WebDriverUtils;

public class ViewActiveCustomerCreditCheckBalanceInViewActiveCustomer_Tc10 {
	@Test
	public void Tc_10() throws Exception {
		//create object of webdriverutils generic  class
		WebDriverUtils wu=new WebDriverUtils();
		
		Properties pObj=new Properties();
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/");
		pObj.setProperty("staff id", "210001");
		pObj.setProperty("password", "password");
		pObj.setProperty("credit_amount", "1000");
		
		//create object for FileOutPutStream
		FileOutputStream fout=new FileOutputStream(IpathConstants.FilePath);//here file path taken by ipathconstants interface
		pObj.store(fout, "Write Test Data");
		//output data from common data proties files
		FileInputStream fi=new FileInputStream(IpathConstants.FilePath);
		pObj.load(fi);
		 String BROWSER=pObj.getProperty("browser");
			String URL=pObj.getProperty("url");
		    String STAFFID=pObj.getProperty("staff id");
		    String PASSWORD=pObj.getProperty("password");
		    String CreditAmount=pObj.getProperty("credit_amount");
	
	//Luanch The Browser
		    
	WebDriver driver=new ChromeDriver();
	//maximize the browser
	wu.maximizeWindow(driver);
	//Enter the Url
	driver.get(URL);
	//wait page load
	wu.waitPageLoad(driver);
	
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

	//find account deatail
	String	cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
	//check current bal
	String bal=driver.findElement(By.xpath("//td[text()='1011951011621']/../td[8]")).getText();
	bal=bal.replace("$", "");
	double balance=Double.parseDouble(bal);
	//Number balance=
	  
	   
  
	//CLICK ON HOME BUTTON

	driver.findElement(By.xpath("//input[@name='home']")).click();
	
	//driver.findElement(By.linkText("Staff Login")).click();
	//CLICK ON CREDIT CUSTOMER TAB
	//driver.findElement(By.name("viewdet")).click();
//ENTER CUSTOMER ACC NO,AMOUNT AND CLICK ON CREDIT BUTTON
	driver.findElement(By.name("credit_cust_ac")).click();
	
driver.findElement(By.xpath("//input[@name='customer_account_no']")).sendKeys("1011951011621");
driver.findElement(By.name("credit_amount")).sendKeys(CreditAmount);
driver.findElement(By.name("credit_btn")).click();
//handle pop up
wu.accpteAlert(driver);
//String confrm=driver.switchTo().alert().getText();
//driver.switchTo().alert().accept();
//validate the popup


//if(confrm.contains("Amount credited Successfully")) {
//	System.out.println("amount credit");


//CLICK ON VIEW ACTIVE CUSTOMER TAB AND SCROLL DOWN AND FIND THE CUSOMER
driver.findElement(By.xpath("//input[@name='home']")).click();
//click on view Active Button in Active customer button
	driver.findElement(By.name("viewdet")).click();
		//cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
		String UpdatedBalance=driver.findElement(By.xpath("//td[text()='1011951011621']/../td[8]")).getText();
		//remove $ for validate balnce
		UpdatedBalance=UpdatedBalance.replace("$", "");
		double updbal=Double.parseDouble(UpdatedBalance);
		//validate the test case
		
if((balance+1000)==updbal) {
	System.out.println("Test pass");
}
else {
	System.out.println("test cse fail");
}

//close the browser
wu.minimizedWindow(driver);
driver.quit();
	
}
	
}