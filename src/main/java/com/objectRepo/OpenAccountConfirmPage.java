package com.objectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountConfirmPage {
	

	
	
		@FindBy(xpath = "//input[@type='submit']")
		private WebElement btn_confirm;
		
		@FindBy(xpath = "//input[@type='button']")
		private WebElement btn_goback;
		
		public  OpenAccountConfirmPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}

		public WebElement getBtn_confirm() {
			return btn_confirm;
		}

		public WebElement getBtn_goback() {
			return btn_goback;
		}
		
		//Business Logic
		public void click_submit() 
		{
			btn_confirm.click();
		}
		
		public void click_goback() 
		{
			btn_goback.click();
		}
	
}
