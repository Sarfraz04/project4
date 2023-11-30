package com.OnlineBankingTestScript;
import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.objectRepo.HomePage;
import com.objectRepo.OpenAccountConfirmPage;
import com.objectRepo.OpenAccountFormPage;
import com.onlinebanking.GenericUtils.BaseClass;
import com.onlinebanking.GenericUtils.ExcelUtils;
import com.onlinebanking.GenericUtils.FileUtils;
import com.onlinebanking.GenericUtils.WebDriverUtils;

//@Listeners(com.onlinebanking.GenericUtils.ImplementClass.class)
public class ApplyaNewBankAccount_Tc_05_Test extends BaseClass {
	

	

	
@Test //(retryAnalyzer = com.onlinebanking.GenericUtils.RetryImplements.class)//here anotaion for retry method 
		public void tc05Test() throws Throwable {
			ExcelUtils eu=new ExcelUtils();
            FileUtils fLibs=new FileUtils();
            WebDriverUtils wb=new WebDriverUtils();
          /**  
			// Step 1. Reading from Properties File
			FileInputStream fisP = new FileInputStream(".//src/test/resources/commonDataOnlineBanking.properties");
			Properties p = new Properties();
			p.load(fisP);
			String URL = p.getProperty("url");*/
          String URL=  fLibs.readDataFromPropertyFile("url");
          
			System.out.println(URL);

			// Step 2. Opening Browser and Launching to Application
			WebDriver driver = new ChromeDriver();
			
			wb.maximizeWindow(driver);
			wb.waitPageLoad(driver);
			
			driver.get(URL);

			// Step 3.Clicking Open Account Button
			HomePage hp=new HomePage(driver);
			
			//driver.findElement(By.xpath("//ul/a/li[text()='Open Account']")).click();
			hp.clickOnRegisterInternetBanking(driver);
//reading data from excel through generic class
			
		eu.readMultipleData("Sheet3", driver);
		
			// Step 4.Entering DOB
			Robot r = new Robot();
			driver.findElement(By.name("dob")).click();
			r.keyPress(KeyEvent.VK_0);
			r.keyPress(KeyEvent.VK_4);
			r.keyPress(KeyEvent.VK_0);
			r.keyPress(KeyEvent.VK_4);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_1);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_9);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_9);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_9);

			// Step 5.Selecting DropDowns
			OpenAccountFormPage opnAcc=new OpenAccountFormPage(driver);
			
			WebElement stateDD = driver.findElement(By.name("state"));
			Select s1 = new Select(stateDD);
			s1.selectByIndex(2);

			WebElement cityDD = driver.findElement(By.name("city"));
			Select s2 = new Select(cityDD);
			s2.selectByIndex(2);

			WebElement accountDD = driver.findElement(By.name("acctype"));
			Select s3 = new Select(accountDD);
			s3.selectByIndex(2);

			// Step 6.Clicking Submit
			driver.findElement(By.name("submit")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("cnfrm-submit")).click();

			// Step 7.Handling Popup

			String confirmationMsg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			// Step 8.Validation
			if (confirmationMsg.contains("Application submitted successfully")) {
				System.out.println("Pass");
				
				System.out.println("Account created Successfully");
			} else {
				System.out.println("Failed");
				System.out.println("Account not created");
			}

		}

	}


