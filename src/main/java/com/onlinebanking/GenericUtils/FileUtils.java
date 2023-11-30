package com.onlinebanking.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This method is used to read data from property file
 * @author NIDHI
 * @param key
 * @return
 * @throws Throwable
 */
public class FileUtils {
	public String readDataFromPropertyFile(String key) throws Throwable{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties pLib=new Properties();
		pLib.load(fis);
		String value=pLib.getProperty(key);
		return value;
	}

}
