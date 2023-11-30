package dataProviderPractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataPrivederFromExcelTest {
	@DataProvider
	public Object[][]data() throws Throwable{
		
		
	FileInputStream fi=new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh=wb.getSheet("Sheet2");
	int countRow=sh.getPhysicalNumberOfRows();
	int countCell=sh.getRow(0).getLastCellNum();//if it talking then dont give equals in for loop
	 Object obj[][]=new Object[countRow][countCell];//
	  for(int i=0;i<countRow;i++) {
		  for(int j=0;j<countCell;j++) {
			  obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			  
		  }
	  }
	 
return obj;
}
}