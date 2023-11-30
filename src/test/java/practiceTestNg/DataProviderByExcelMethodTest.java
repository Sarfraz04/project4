package practiceTestNg;

import org.testng.annotations.Test;

import com.onlinebanking.GenericUtils.ExcelUtils;

import dataProviderPractice.DataPrivederFromExcelTest;

public class DataProviderByExcelMethodTest {
	
		@Test(dataProviderClass = ExcelUtils.class,dataProvider="data") //  here i use utils pakage
	/**
	 * here data we are taking  from other class 
	 * @param from
	 * @param to
	 * @param price
	 */
		public void getData(String org,String place) {
			System.out.println("organition name :: "+org+" place name is ::"+place);
		}
}
