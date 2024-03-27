package steps;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
 
import org.apache.logging.log4j.Logger;
 
import org.junit.Assert;
//import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;
//import pages.BaseClass;
import pages.DepositPage;
//import pages.SignInPages;
import pages.loginpage;
public class DepositStep {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DepositStep.class);
	ExtentSparkReporter spark = new ExtentSparkReporter("target/error.html");
	ExtentTest test;
	ExtentReports extent = new ExtentReports();
	
	
	   DepositPage ds;
	
	
	loginpage lp;
	
	
	@Given("User is on Deposit page")
	public void user_is_on_deposit_page() {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\vinis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 driver =new  ChromeDriver();
		 driver.get("http://dbankdemo.com/bank/login");
		 driver.navigate().refresh();
		 driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		extent.attachReporter(spark);
		test = extent.createTest("MyFirstTest");
	    lp = new loginpage(driver);
	    ds = new DepositPage(driver);
	  //  sip.enterSignInDetails();
	    lp.username("vinishakonda@gmail.com");
	    lp.pswd("Admin@123");
	    lp.clickloginbutton();
	    ds.clickonDeposit();
	    logger.info("user is in Deposit page");
	}
 
	@When("Validating Reset button")
	public void validating_reset_button() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	//Thread.sleep(3000);
		ds.clickonReset();
		Assert.assertTrue("Assert failed- Reset button not working",ds.validate_Reset_Btn());
		logger.info("Validating Reset button");
	}
 
	@Then("Validating Submit button with no data")
	public void validating_submit_button_with_no_data()  {
		ds.clickonSubmit();
	
		Assert.assertTrue("Assert failed- Reading empty fields",ds.validate_dropdown());
		logger.info(" user Validates submit button with no data");
		test.pass(" user Validates submit button with no data");
		
	}
 
	@Then("Validating Submit button with Amount field as zero")
	public void validating_submit_button_with_amount_field_as_zero() {
		ds.enterDepositDetails("416352", "0");
		ds.clickonSubmit();
		test.pass(" user Validates submit button with amount zero");
 
		Assert.assertTrue("Assert failed- Reading amount as 0",ds.validate_error() );
		System.out.println(ds.captureError());
		logger.error(ds.captureError());
	}
 
	@Then("Validating succesful deposit transaction with valid credentials")
	public void validating_succesful_deposit_transaction_with_valid_credentials() {
		ds.enterDepositDetails("416352", "100");
		ds.clickonSubmit();
		test.pass("user Validates succesful deposit transaction with valid credentials");
		logger.info(" user Validates succesful deposit transaction with valid credentials");
		extent.flush();
		driver.quit();
	
	}
 
	
}
 