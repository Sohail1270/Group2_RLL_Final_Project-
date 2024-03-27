package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginpage;
//import utilities.logintakeinputusingexcel;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

@Test
public class loginsteps   {
//	public static final Logger logger = (Logger) LogManager.getLogger(loginsteps.class);
 
	 WebDriver driver;
		loginpage lp;
		private static Logger logger = LogManager.getLogger(loginsteps.class);
	    static ExtentTest test;
	 
	    
	   
	   private static ExtentReports extent = new ExtentReports();
	   
	    @Before
	    public void setUp() {
	    	ExtentSparkReporter spark = new ExtentSparkReporter("target/signin.html");
	    	extent.attachReporter(spark);
	    	
	     
	        driver = new ChromeDriver();
 
	       lp = new loginpage(driver);
	    }
	    @BeforeAll
	    public static void before () {
	    	test = extent.createTest("Signin");
	    }
	    @AfterAll
	    public static void after() {
	    	extent.flush();
	    }

	    @After
	    public void tearDown() {
	    	
	    	driver.quit();
	    }
	
	 
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://dbankdemo.com/bank/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
	 lp = new loginpage(driver);
	 logger.info("The user is on sign-in page");
     
     test.pass("The user is on sign-in page");
   
	 
	}
	 
	@When("I enter username {string}  and password {string}")
	public void i_enter_username_and_password(String uname, String psw) {
		
lp.username(uname);
lp.pswd(psw);
logger.info("User entesr username and password");
test.pass("The user logged in sucessfully");
	}
	 
	     

	@When("I click the login button")
	public void i_click_the_login_button() {
lp.clickloginbutton();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement invalidcredentials = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
	if (invalidcredentials.isDisplayed()) {
		System.out.println("Invalid credentials ");	
		captureScreenshot(driver, "Invalicredentialsscreenshot");
		Assert.assertTrue(false);
		logger.info("User clciks on login");
		test.pass("The user clicks onlogins");
 } 
 }

	
	
	@When("I enter invalid username {string} and password {string}")
	public void i_enter_invalid_username_and_password(String uname, String psw) {
	   lp.username(uname);
	   lp.pswd(psw);
	   logger.info("User enetrs invalid cred");
		test.pass("Users recheck invlaid cred");
        }
	   
	

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		 Assert.assertEquals(driver.getTitle(),"Digital Bank");
    	 test.pass("The user will not get signed in");
    	 logger.error("User gets error mesage");
 		test.pass("The user check error messgae");
	}

	@When("I enter invalid password , username {string}   and password {string}")
	public void i_enter_invalid_password_username_and_password(String uname, String psw) {
	    lp.username(uname);
	    lp.pswd(psw); 
	    logger.info("User gives invalid cred");
		test.pass("The user tries to see invalid cred");
      	   
         } 
         
	
 
 

 

 
	@Then("I should be redirected to my account dashboard")
	public void i_should_be_redirected_to_my_account_dashboard() {
	  
		 Assert.assertEquals(driver.getTitle(),"Digital Bank");
	        test.pass("The user is signed in successfully");
	       
	         
	}
	
	

	public static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\91939\\eclipse-workspace\\RLL_Register\\Screenshots_Login\\" + fileName + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot: " + e.getMessage());	
					
		}
	
	}	
}


