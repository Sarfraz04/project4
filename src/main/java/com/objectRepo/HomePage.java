package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.GenericUtils.WebDriverUtils;

public class HomePage extends WebDriverUtils{
	
	
	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement openAcc_Tab;
	
	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement applyDebit_Tab;
	
	@FindBy(xpath="//a[contains(.,'Internet Banking')]")
	private WebElement InternetBanking_Tab;
	
	@FindBy(xpath="//li[text()='Register']")
	private WebElement registerInternetBanking;
	
	@FindBy(linkText="Staff Login")
	private WebElement staffLink;
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement fundTransferTab;
	
	@FindBy(xpath="//li[text()='Login ']")
	
	private WebElement loginInternetBanking;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	//business logic 
	public void clickOnOpenAccountTab() {
		openAcc_Tab.click();
	}
	
	public void clickOnApplyDebitCardTab() {
		applyDebit_Tab.click();
	}
	
	public void clickOnRegisterInternetBanking(WebDriver driver) {
		mousehover(driver, InternetBanking_Tab);
		registerInternetBanking.click();
	 
	}
	public void clickOnLoginInternetBanking(WebDriver driver) {
		mousehover(driver, InternetBanking_Tab);
		loginInternetBanking.click();
	}
	
	public WebElement getOpenAcc_Tab() {
		return openAcc_Tab;
	}
	public WebElement getApplyDebit_Tab() {
		return applyDebit_Tab;
	}
	public WebElement getInternetBanking_Tab() {
		return InternetBanking_Tab;
	}
	public WebElement getRegisterInternetBanking() {
		return registerInternetBanking;
	}
	public WebElement getStaffLink() {
		return staffLink;
	}
	public WebElement getFundTransferTab() {
		return fundTransferTab;
	}
	public WebElement getLoginInternetBanking() {
		return loginInternetBanking;
	}
	public void clickOnStaffLink() {
		staffLink.click();
	}
		public void clickonfundTransferTab() {
			fundTransferTab.click();
		}
	}
	
	
	


