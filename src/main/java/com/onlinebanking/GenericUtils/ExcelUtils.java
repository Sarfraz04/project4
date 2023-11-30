package com.onlinebanking.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
	

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;



public class ExcelUtils {
	/**
	 * This method is used to read data from excel
	 * @author sarfraz
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName,int row,int cell)throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.EXcel_Path);
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		String value=sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	/**
	 * This method is used to get the total row count
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * 
	 */
	public int getLastRowNo(String sheetName) throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.EXcel_Path);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write data into excel
	 * @author sarfraz
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * 
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.EXcel_Path);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IpathConstants.EXcel_Path);
		wb.write(fout);
		wb.close();
		
	}
	
	public void readMultipleData(String sheetName,WebDriver driver) throws Throwable{
		JavaUtils jLib=new JavaUtils();
		FileInputStream fi=new FileInputStream(IpathConstants.EXcel_Path);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		HashMap<String,String>map=new HashMap<String,String>();
		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
					
		}
	
			
		for(Entry<String,String> set:map.entrySet()) {
			
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	
	
		
		
	}
	@DataProvider
	public Object[][]data() throws Throwable{
		
		
		FileInputStream fi=new FileInputStream(IpathConstants.EXcel_Path);
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
