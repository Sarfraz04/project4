package com.objectRepo;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.onlinebanking.GenericUtils.WebDriverUtils;

public class OpenAccountFormPage  extends WebDriverUtils{


	

	
		//Initialization
		
		@FindBy(name = "name")
		private WebElement name_txtfld;
		
		@FindBy(name = "gender")
		private WebElement gender_drop;
		
		@FindBy(name = "mobile")
		private WebElement mob_txtfld;
		
		@FindBy(name = "email")
		private WebElement email_txtfld;
		
		@FindBy(name = "landline")
		private WebElement land_txtfld;
		
		@FindBy(name = "dob")
		private WebElement dob_calpopup;
		
		@FindBy(name = "pan_no")
		private WebElement pan_txtfld;
		
		@FindBy(name = "citizenship")
		private WebElement citi_txtfld;
		
		@FindBy(name = "homeaddrs")
		private WebElement home_txtarea;
		
		@FindBy(name = "officeaddrs")
		private WebElement office_txtarea;
		
		// disabled element
		@FindBy(name = "country")
		private WebElement coun;
		
		@FindBy(name = "state")
		private WebElement state_drop;
		
		@FindBy(name = "city")
		private WebElement city_drop;
		
		@FindBy(name = "pin")
		private WebElement pin_txtfld;
		
		@FindBy(name = "arealoc")
		private WebElement area_txtfld;
		
		@FindBy(name = "nominee_name")
		private WebElement nominee_txtfld;
		
		@FindBy(name = "nominee_ac_no")
		private WebElement nominee_ac_txtfld;
		
		@FindBy(name = "acctype")
		private WebElement acctyp_drop;
		
		@FindBy(name = "submit")
		private WebElement submit_btn;
		
		
		//Declaration
		
		public OpenAccountFormPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		
		
		//Utilization
		
		public WebElement getName_txtfld() {
			return name_txtfld;
		}

		public WebElement getGender_drop() {
			return gender_drop;
		}

		public WebElement getMob_txtfld() {
			return mob_txtfld;
		}

		public WebElement getEmail_txtfld() {
			return email_txtfld;
		}

		public WebElement getLand_txtfld() {
			return land_txtfld;
		}

		public WebElement getDob_calpopup() {
			return dob_calpopup;
		}

		public WebElement getPan_txtfld() {
			return pan_txtfld;
		}

		public WebElement getCiti_txtfld() {
			return citi_txtfld;
		}

		public WebElement getHome_txtarea() {
			return home_txtarea;
		}

		public WebElement getOffice_txtarea() {
			return office_txtarea;
		}

		public WebElement getCoun() {
			return coun;
		}

		public WebElement getState_drop() {
			return state_drop;
		}

		public WebElement getCity_drop() {
			return city_drop;
		}

		public WebElement getPin_txtfld() {
			return pin_txtfld;
		}

		public WebElement getArea_txtfld() {
			return area_txtfld;
		}

		public WebElement getNominee_txtfld() {
			return nominee_txtfld;
		}

		public WebElement getNominee_ac_txtfld() {
			return nominee_ac_txtfld;
		}

		public WebElement getAcctyp_drop() {
			return acctyp_drop;
		}

		public WebElement getSubmit_btn() {
			return submit_btn;
		}
		
		//Business logic
		public void OpenAccount(String NAME, String MOBILE, String EMAIL, String LANDLINE, String PAN, String CITI, String HOME, String OFFICE, String PIN, String AREA, String NOMINEE_NAME, String NOMINEE_AC_NO)
		{
			name_txtfld.sendKeys(NAME);
			mob_txtfld.sendKeys(MOBILE);
			email_txtfld.sendKeys(EMAIL);
			land_txtfld.sendKeys(LANDLINE);
			pan_txtfld.sendKeys(PAN);
			citi_txtfld.sendKeys(CITI);
			home_txtarea.sendKeys(HOME);
			office_txtarea.sendKeys(OFFICE);
			pin_txtfld.sendKeys(PIN);
			area_txtfld.sendKeys(AREA);
			nominee_txtfld.sendKeys(NOMINEE_NAME);
			nominee_ac_txtfld.sendKeys(NOMINEE_AC_NO);		
		}
		
		public void OpenAccount_dropdown(String GENDER, String STATE, String CITY, String ACC) 
		{
			Select d1 = new Select(gender_drop);
			d1.selectByVisibleText(GENDER);
		
			Select d2 = new Select(state_drop);
			d2.selectByVisibleText(STATE);

			Select d3 = new Select(city_drop);
			d3.selectByVisibleText(CITY);
		
			Select d4 = new Select(acctyp_drop);
			d4.selectByVisibleText(ACC);
		}
		
	/**	public void OpenAccount_datepopup(WebDriverUtils wlib, WebDriver driver) throws Throwable 
		{	
			dob_calpopup.click();
			for(int i=1; i<=9; i++)
			{
			/*	wlib.keyPress_UpArrow();
				wlib.keyRelease_UpArrow();
			}
			
			wlib.keyPress_Tab();
			wlib.keyRelease_Tab();
			
			for(int i=1; i<=9; i++)
			{
				wlib.keyPress_UpArrow();
				wlib.keyRelease_UpArrow();
			}
			
			wlib.keyPress_Tab();
			wlib.keyRelease_Tab();
			
			for(int i=1; i<=21; i++)
			{
				wlib.keyPress_DownArrow();
				wlib.keyRelease_DownArrow();
			}
			//wlib.alertPopupWithText(driver);
			//wlib.alertPopupAccept(driver);
			
		}
		
		public void submit()
		{
			submit_btn.click();
		}*/
		
	}

