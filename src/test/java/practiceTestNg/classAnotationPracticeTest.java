package practiceTestNg;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class classAnotationPracticeTest {
	

	


		
		
		@BeforeSuite
		public void configuration() {
			System.out.println("....DB connection ,,,,,");
		}
		@BeforeClass
		public void confi_BC() {
			System.out.println(".......launch the browser");
		}
		@BeforeClass
		public void confi_BC1() {
			System.out.println(".......launch the browser1");
		}
		
		@Test
		public void testScriptTest() {
			System.out.println(" execute test script 1 ");
		}
		@BeforeMethod
		public void confi_Bm1() {
			System.out.println(" .......login to application...");
		}
		@AfterClass
		public void configu_AC() {
			System.out.println("........close the browser...");
		}
		
		@BeforeMethod
		public void confi_Bm2() {
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
		
		@AfterSuite
		public void  confi_AS() {
		System.out.println(".......discconect from DB");	
		}

	}


  
