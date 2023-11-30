package PracticeScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.mysql.cj.jdbc.Driver;

public class Ty_Rmg_Project {

	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//sign in to rmg yantra
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		//create project
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("FirstProject");
		driver.findElement(By.name("createdBy")).sendKeys("sarfraz");
		//status drop down
		
		WebElement statusdd=driver.findElement(By.name("status"));
		//select drop down
		Select drop=new Select(statusdd);
		drop.selectByValue("Created");
		//click on submit button
		driver.findElement(By.xpath("//input[@type='submit' ]")).click();
		
		//validate the data
		

}
}

