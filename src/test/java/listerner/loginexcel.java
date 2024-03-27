package listerner;


import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginexcel {
public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");
		driver.navigate().refresh();
		
	}
	 
 
	@Test(dataProvider = "testdata")
	public void register_user(String email, String password  ) throws InterruptedException
	{
		
 
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
	 
//	 
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div[1]/div/a[5]")).click();	
	}
	
	 
	
	@DataProvider(name="testdata")
	public   Object[][] datasupply() throws FileNotFoundException
	{ 
		Object[][] inputdata = Xls_DataProvider.getTestData("Sheet1");
		
		return inputdata;
		
	}
	
	
}