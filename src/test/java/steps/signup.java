package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pages.registerpagefactory;


public class signup {

	static	WebDriver driver;
	registerpagefactory rp;
	
	
	private static Logger logger = LogManager.getLogger(signup.class);

	
	public signup() {
		driver = new ChromeDriver();
		rp = new registerpagefactory(driver);
	}
	
	
	
	
	@Given("User is on Chrome browser and he opens the link")
	public void OpenBrowser() throws InterruptedException
	{
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");
		driver.navigate().refresh();
		
		
		
	}

	@When("User fills the details on the page")
	public void EnterURL() throws IOException, InterruptedException
	{
		
		
		rp.signupbutton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//select is a class to handle dropdown
		
		
		
		
		
		
		
		Select title = new Select(driver.findElement(By.xpath("//select[@id='title']")));
		title.selectByIndex(1);
		  
		FileInputStream file = new FileInputStream("C:\\Users\\91939\\OneDrive\\Desktop\\loginpagedata.xlsx");
	         Workbook workbook = new XSSFWorkbook (file);
	         Sheet sheet = workbook.getSheet("Sheet1");
	         
	         Iterator<Row> rowIterator = sheet.iterator();
	         rowIterator.next();
	         logger.info("I enter username and password and other details");
	         while (rowIterator.hasNext ()) {
	      	  
	      	  Row row = rowIterator.next();
	      	  
	      	 String firstname = row.getCell(0).getStringCellValue();
	      	 String lastname = row.getCell(1).getStringCellValue();
	      	 String date = row.getCell(2).getStringCellValue();
	      	 String ssn = row.getCell(3).getStringCellValue();
	      	 String email = row.getCell(4).getStringCellValue();
	      	 String password = row.getCell(5).getStringCellValue();
	      	 String confirmpassword = row.getCell(6).getStringCellValue();
	      	 
	      	 

	      	   rp.registerdetails(firstname,lastname,date,ssn,email,password,confirmpassword); 
		  

	         }
		  
		  
		
	}


	@Then ("User fills the details of next page and fills details")
	public void Details () throws IOException {
		
		rp.nextpagelink();
			
		FileInputStream file = new FileInputStream("C:\\Users\\91939\\OneDrive\\Desktop\\loginpagedata.xlsx");
        Workbook workbook = new XSSFWorkbook (file);
        Sheet sheet = workbook.getSheet("Sheet2");
        
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        logger.info("User fills the details of next page and fills details");
        while (rowIterator.hasNext ()) {
        	
     	  Row row = rowIterator.next();
     	  
     	 String address = row.getCell(0).getStringCellValue();
     	 String location = row.getCell(1).getStringCellValue();
     	 String region = row.getCell(2).getStringCellValue();
     	 String postalcode = row.getCell(3).getStringCellValue();
     	 String country = row.getCell(4).getStringCellValue();
     	 String homephone = row.getCell(5).getStringCellValue();
     	 String mobile = row.getCell(6).getStringCellValue();
     	 String work = row.getCell(7).getStringCellValue(); 
     	 

     	   rp.nextpagedetails(address,location,region,postalcode,country,homephone,mobile,work); 
	

		
	}}
	
	@And ("user clicks on register and he comes on login")
	public void finished() {
		//driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		rp.registerbutton();
		driver.quit();
	}
	//scenario 2
	@Given("User is on Chrome browser and he opens the links")
	public void user_is_on_chrome_browser_and_he_opens_the_links() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");
		driver.navigate().refresh();
	
		
		
	    
	}

	@When("User fills the invalid details on the page")
	public void user_fills_the_invalid_details_on_the_page() throws IOException, InterruptedException {
	//	rp.button();
		rp.signupbutton();
		
		  Select title = new Select(driver.findElement(By.xpath("//select[@id='title']")));
		  title.selectByIndex(1);
		  FileInputStream file = new FileInputStream("C:\\Users\\91939\\OneDrive\\Desktop\\loginpagedata.xlsx");
	         Workbook workbook = new XSSFWorkbook (file);
	         Sheet sheet = workbook.getSheet("Sheet1");
	         
	         Iterator<Row> rowIterator = sheet.iterator();
	         rowIterator.next();
	         logger.info("I enter username and password with same credentials");
	         while (rowIterator.hasNext ()) {
	      	  
	      	  Row row = rowIterator.next();
	      	  
	      	 String firstname = row.getCell(0).getStringCellValue();
	      	 String lastname = row.getCell(1).getStringCellValue();
	      	 String date = row.getCell(2).getStringCellValue();
	      	 String ssn = row.getCell(3).getStringCellValue();
	      	 String email = row.getCell(4).getStringCellValue();
	      	 String password = row.getCell(5).getStringCellValue();
	      	 String confirmpassword = row.getCell(6).getStringCellValue();
	      	 
	      	 

	      	 rp.registerdetails(firstname,lastname,date,ssn,email,password,confirmpassword); 
	      	 
	      	rp.nextpagelink();
	      	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	      	//Thread.sleep(2500);
	      	WebElement Already = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
	  		if (Already.isDisplayed()) {
	  			System.out.println("already registered");	
	  			captureScreenshot(driver, "registeredfail");
	  			Assert.assertTrue(false);
	      	   
	         } 
	         }
		  
	  
	}

	@Then("User will gets message that it has been already registered")
	public void user_gets_message_to_fill_all_the_details() throws IOException {
	   
		rp.nextpagelink();
		
		FileInputStream file = new FileInputStream("C:\\Users\\91939\\OneDrive\\Desktop\\loginpagedata.xlsx");
        Workbook workbook = new XSSFWorkbook (file);
        Sheet sheet = workbook.getSheet("Sheet2");
        
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        logger.info("User gets message that it has been already registered");
        while (rowIterator.hasNext ()) {
        	
     	  Row row = rowIterator.next();
     	  
     	 String address = row.getCell(0).getStringCellValue();
     	 String location = row.getCell(1).getStringCellValue();
     	 String region = row.getCell(2).getStringCellValue();
     	 String postalcode = row.getCell(3).getStringCellValue();
     	 String country = row.getCell(4).getStringCellValue();
     	 String homephone = row.getCell(5).getStringCellValue();
     	 String mobile = row.getCell(6).getStringCellValue();
     	 String work = row.getCell(7).getStringCellValue(); 
     	 

     	   rp.nextpagedetails(address,location,region,postalcode,country,homephone,mobile,work); 
     	   
     	  
  		
		//System.out.println("User is already registered");
	  
		
		
		
	}
              
	}
	
	
	
	public static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\91939\\eclipse-workspace\\RLL_Register\\Screenshots_Signup\\" + fileName + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot: " + e.getMessage());	
					
		}
	
	}	
	
	
	
	
	@Then("user closes the browser")
	public void user_closes_the_browser() {
	  driver.quit();
	}

	
	
	
	
	
	
	
	
}