package practiceTestNg;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgPractice2Test {
	@Test(priority=3)
	public void createTest() {      //it will fail beacuse its give arrayoutofbound exception
		int []a= {1,2,3,4,5};
		System.out.println(a[1]);
		System.out.println("create test .......");
		
	}
	@Test(dependsOnMethods="deleteTest")//delete method is depend on edit //depends method first
	public void editTest() {
		System.out.println("edit test .......");
		
	}
	@Test(priority=2)
	public void deleteTest() {
		System.out.println("delete test .......");
		
	}
	@Test(dependsOnMethods={"createTest"},priority=1)    //it will skip because it is dependend on create method
	public void modifyTest() {
		System.out.println("modify test .......");
		

}
	@Ignore
	public void homeTest() {   //it will ingonre because ingonre annotns use
		System.out.println("home page ....");
	}
	}
