package practiceTestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnootationTest {
	@Test
	public void testScriptTest() {
		System.out.println(" execute test script 1 ");
	}
	@BeforeSuite
	public void configuration() {
		System.out.println("....DB connection ,,,,,");
	}
	@AfterSuite
	public void  confi_AS() {
	System.out.println(".......discconect from DB");	
	}
	@BeforeClass
	public void confi_BC() {
		System.out.println(".......launch the browser");
	}
	@AfterClass
	public void configu_AC() {
		System.out.println("........close the browser...");
	}
	@BeforeMethod
	public void confi_Bm() {
		System.out.println(" .......login to application...");
	}
	@AfterMethod
	public void confi_AM() {
		System.out.println("....logout app....");
	}
	@Test
	public void test() {
		System.out.println();
	}

}
