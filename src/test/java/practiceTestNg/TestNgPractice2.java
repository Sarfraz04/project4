package practiceTestNg;

import org.testng.annotations.Test;

public class TestNgPractice2 {
	@Test(invocationCount=1)
	public void createTest() {
		System.out.println("create test .......");
		
	}
	@Test(dependsOnMethods="deleteTest")//delete method is depend on edit
	public void editTest() {
		System.out.println("edit test .......");
		
	}
	@Test
	public void deleteTest() {
		System.out.println("delete test .......");
		
	}
	@Test(dependsOnMethods="createTest")
	public void modifyTest() {
		System.out.println("modify test .......");
		
	}

}
