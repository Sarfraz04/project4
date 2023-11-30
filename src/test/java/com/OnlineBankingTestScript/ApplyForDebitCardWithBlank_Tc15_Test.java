package com.OnlineBankingTestScript;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.BaseClass;
import com.onlinebanking.GenericUtils.ExcelUtils;
import com.onlinebanking.GenericUtils.FileUtils;
import com.onlinebanking.GenericUtils.WebDriverUtils;
@Listeners(com.onlinebanking.GenericUtils.ImplementClass.class)
public class ApplyForDebitCardWithBlank_Tc15_Test extends BaseClass{
	
WebDriverUtils wb=new WebDriverUtils();
	ExcelUtils eu=new ExcelUtils();
	
	FileUtils fils=new FileUtils();
	
	@Test
		public  void Tc_15() throws Throwable 
		{
			/*Properties pobj = new Properties();
			FileInputStream fi = new FileInputStream(".\\src\\main\\resources\\testData.properties");
			pobj.load(fi);*/
			
			String BROWSER = fils.readDataFromPropertyFile("browser");
			String URL = fils.readDataFromPropertyFile("url");
			String TITLE = fils.readDataFromPropertyFile("title");
			
			WebDriver driver = new ChromeDriver();
			wb.maximizeWindow(driver);
			
			
			driver.get(URL);
			wb.waitPageLoad(driver);
			
			
			
			driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
			
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet("Sheet4"); 
		    int count = sheet.getLastRowNum();
		    
			HashMap<String, String> map = new HashMap<String, String>();
			for(int i=1;i<=count;i++)
			{
				String key = sheet.getRow(i).getCell(0).getStringCellValue();
				String value = sheet.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
			}
			for(Entry<String, String> set:map.entrySet())
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			//Assert.fail();
			Alert alertpopup = driver.switchTo().alert();
			String errormsg = alertpopup.getText();
			System.out.println("Error message displayed as: "+errormsg);
			alertpopup.accept();
			
			driver.quit();

		}

	}


