package com.OnlineBankingTestScript;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC_8_smoke_Test {
	

	
		public static void main(String[] args) throws IOException, InterruptedException 
		{
			Properties pobj = new Properties();
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\commonDataOnlineBanking.properties");
			pobj.load(fi);
			
			String Browser = pobj.getProperty("browser");
			String URL = pobj.getProperty("url");
			String Title = pobj.getProperty("title");
					
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
			String ac_title = driver.getTitle();
			if(Title.equals(ac_title))
			{
				System.out.println("**** Redirecting to 'Apply Debit Card' Page ***");
			}
			else
			{
				System.out.println(" NOT Redirecting to 'Apply Debit Card' Page ");
			}		
			driver.quit();

		}

	}

