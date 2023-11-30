package practiceTestNg;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void hardAssertTest() {
String exp="B";
String act="b";
		System.out.println("........ts1.........");
		System.out.println(".........ts2........");
		Assert.assertEquals("B", exp,"a");
		System.out.println("........ts3.........");
		System.out.println(".........ts4........");
		Assert.assertNotEquals("a", "v");
		System.out.println("........ts5.........");
		System.out.println(".........ts6........");
		Assert.assertSame(act, exp);
		System.out.println("..............t7............");
	}

}
