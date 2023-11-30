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

public class ApplyNewBankAccount {

	public static void main(String[] args) throws Throwable {

		// Step 1. Reading from Properties File
		FileInputStream fisP = new FileInputStream(".\\src\\test\\resources\\commonDataOnlineBanking.properties");
		Properties p = new Properties();
		p.load(fisP);
		String URL = p.getProperty("url");
		System.out.println(URL);

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// Step 3.Clicking Open Account Button
		driver.findElement(By.xpath("//ul/a/li[text()='Open Account']")).click();

		FileInputStream fisE = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fisE);
		Sheet sheet = workbook.getSheet("Sheet3");
		int rowCount = sheet.getLastRowNum();

		// Step 4.Creating Hasmap and Storing Key Value from Excel
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i <= rowCount; i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			hm.put(key, value);
		}
		for (Entry<String, String> set : hm.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			Thread.sleep(500);
		}
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


