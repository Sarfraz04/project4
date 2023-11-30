package practiceTestNg;

import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.BaseClass;

public class PracticeTest extends BaseClass {
	@Test
	public void practice5_Test() {
		System.out.println("practice 5");
	}
	@Test(groups="smoke")
	public void practice6_Test() {
		System.out.println("practice 6");
	}
}
