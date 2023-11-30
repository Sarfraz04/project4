package practiceTestNg;

import org.testng.annotations.Test;
/**
 * depends method is alwys execute in the end
 */
public class TestNgPracticeTest {
	@Test(dependsOnMethods="deleteTest",priority=0)
	public void createTest() {
		System.out.println("create test .......");
		
	}
	@Test(priority=1)
	public void editTest() {
		System.out.println("edit test .......");
		
	}
	@Test
	public void deleteTest() {
		System.out.println("delete test .......");
		
	}
	

}
