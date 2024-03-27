package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pagefactory.Visapage;
import pages.Visapage;

public class VisaStepDefs {
	
	
	static	WebDriver driver;
	Visapage vs;
	
	private static Logger logger = LogManager.getLogger(VisaStepDefs.class);

	public VisaStepDefs() {
		driver = new ChromeDriver();
		vs = new Visapage(driver);
		
	}
	
	@Given("User Navigate to the URL")
	public void user_navigate_to_the_url() {
		driver.get("http://dbankdemo.com/bank/home");
		driver.manage().window().maximize();
		driver.navigate().refresh();
			
		vs.logindetails();	
		
		logger.info("User navigates to the URL");
		
		
		/*
		 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys(
		 * "Selvakumar.18ee051@gmail.com");
		 * 
		 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Selva@2021"
		 * );
		 * 
		 * driver.findElement(By.xpath("//button[@id='submit']")).click();
		 */
	
		
	}

	@When("User click on the Visa Transfer")
	public void user_click_on_the_visa_transfer() {
	logger.info("User click on the Visa Transfer");
		vs.Visaclick();		
		
		/*
		 * driver.findElement(By.xpath("//a[@id='visa-transfer-menu-item']")).click();
		 */
	  
	}

	@Then("User choose the Visa Account Number with Zero")
	public void user_choose_the_visa_account_number() throws InterruptedException {
		logger.info("User choose the Visa Account Number");		
		 Select Accountnumber = new Select(driver.findElement(By.xpath("//select[@id='extAccount']")));
		  Accountnumber.selectByIndex(1);
			
			
			  vs.clickvisabutton(); Thread.sleep(1000);
			  
			  WebElement zerovalue =
			  driver.findElement(By.xpath("//small[@class='form-text text-muted']"));
			  if(zerovalue.isDisplayed()) { 
				  System.out.println("Enter value");
			  captureScreenshot(driver, "0visafail"); 
			  Assert.assertTrue(true);
			  
			  
			  }
			 
		 
		  
		  	 
	}

	@Then("User enter the transfer amount {string}")
	public void user_enter_the_transfer_amount(String Amount) {
		logger.info("User enter the transfer amount");
		vs.amounttransfer(Amount);
		
		
		/*
		 * driver.findElement(By.xpath("(//input[@id='extAmount'])[1]")).sendKeys(Amount
		 * );
		 */	
	}

	@Then("User click submit to VISA")
	public void user_click_submit_to_visa() {
		logger.info("User click submit to VISA");
		
		vs.clickvisabutton();

	 
		WebElement serverError = driver.findElement(By.xpath("//span[contains(text(),'The VISA API service is temporarily unavailable. W')]"));
		if (serverError.isDisplayed()) {
			System.out.println("server unavailable");	
			captureScreenshot(driver, "visafail");
			Assert.assertTrue(false);

		}
		}	  		
	
	
	public static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\91939\\eclipse-workspace\\RLL_Register\\Screenshots_Visa\\" + fileName + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot: " + e.getMessage());	
					
		}
	
	}	
	
	 @After public void close() {
	 
	 driver.quit(); }
	 
	
}