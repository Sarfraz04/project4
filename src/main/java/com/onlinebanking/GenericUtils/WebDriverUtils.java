package com.onlinebanking.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizedWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method wait for 10 sec for the page load
	 * @param driver
	 */
	
	public void waitPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
	public void waitForToBeClickable(WebDriver driver,WebElement element,int sec) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this mthod is used to be clickable 
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilEleToBeVisible(WebDriver driver,WebElement element,int sec) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * this method is used to select drop down by using index 
	 * @param element
	 * @param index
	 */
	public void dropDown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 * this method is used to select drop down by using visiable text
	 * @param element
	 * @param text
	 */
	
	public void dropDown(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);	
	}
	/**
	 * This method will be select data dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
		
		
	}
	/**
	 * this method will performe mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this methos will performe drag drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement src, WebElement dst) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	/**
	 * this method will be performe double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).click().perform();
	}
	/**
	 * This method will perform Right click on Element
	 * @param driver
	 */
	
	public void rightClickWebElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).click().perform();
	}
	/**
	 * this method will perform right click on webpage
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebPage(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().click().perform();
	}
	/**
	 * this method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * this method will press enter key 
	 * @throws Throwable
	 */
	
	public void keyPressEnter()throws Throwable {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * this method is to release the key 
	 * @throws Throwable
	 */
	public void keyReleaseEnter()throws Throwable {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to the frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	
	public void switchToFrame(WebDriver driver,String nameOrId ) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will switch to the frame based on adresss of the element
	 * @param driver
	 * @param adress
	 */
	
	public void switchToFrame(WebDriver driver,WebElement adress) {
		driver.switchTo().frame(adress);
	}
	/**
	 * this method will accpet alert popup
	 * @param driver
	 */
 public void accpteAlert(WebDriver driver) {
	 driver.switchTo().alert().accept();
 }
 /**
  * this method will cancel alret popup
  * @param driver
  */
 public void cancelAlert(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
 }
 /**
  * This method will switch between windows
  * @param driver
  * @param partialWinTitle
  */
 public void switchToWindow(WebDriver driver,String partialWinTitle) {
	 //step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
 }
 /**
 * This method will take screenshot and store it in folder called as Screenshot
 * @param driver
 * @param screenShotName
 * @throws Throwable
 */
	public  static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot/"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
	 //	FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
public static void getScreenshot(WebDriver sDriver, String fScript) {
	// TODO Auto-generated method stub
	
}
}
