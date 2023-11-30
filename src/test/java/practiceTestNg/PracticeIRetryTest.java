package practiceTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeIRetryTest {
	@Test(retryAnalyzer = com.onlinebanking.GenericUtils.RetryImplements.class)
public void practiceRetry() {
		
		System.out.println(".........execution starts....");
		Assert.fail();
	
}
}
