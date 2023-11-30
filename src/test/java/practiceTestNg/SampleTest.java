package practiceTestNg;

import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.BaseClass;

public class SampleTest extends BaseClass {
@Test(groups={"smoke","regional"})
public void sample1_Test() {
	System.out.println("sample 1");
}
@Test(groups= {"smoke","regression"})
public void sample2_Test() {
	System.out.println("sample 2");
}

}
