package PracticeScript;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromJson {
	public static void main(String[] args) throws Exception {
		 
		FileReader filePath=new FileReader(".\\src\\main\\resources\\dataJson.json");
		//JSONParser Is used to read //write json from 
		JSONParser jsonp=new JSONParser();
		Object obj=jsonp.parse(filePath);
		
		//read data from json file
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("Browser"));
		System.out.println(map.get("Url"));
		
		
		//
		WebDriver driver=new ChromeDriver();
		//driver.get();
		
	}

}
