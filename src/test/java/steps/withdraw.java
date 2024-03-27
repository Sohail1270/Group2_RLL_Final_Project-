package steps;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pages.checkingpages;
import pages.withdrawpage;



public class withdraw {

    private static final Logger logger = LogManager.getLogger(withdraw.class);
    private WebDriver driver;
    public withdrawpage Withdraw_Method;
    


    public withdraw() {
        //driver=new EdgeDriver();
    	//Withdraw_Method = new withdrawpage(driver);
        SoftAssert s = new SoftAssert();
    }


		
		
	
	@Given("User navigates to the URL")
	
	public void user_navigates_to_the_url() {
		//System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
		 driver =new  ChromeDriver();
		 
		 Withdraw_Method = PageFactory.initElements(driver,withdrawpage.class);
		 
		logger.info("User navigates to the URL");
		driver.get("http://dbankdemo.com/bank/login"); //url 
		driver.navigate().refresh();
		
	}

	@When("User performs the login process")
	public void user_performs_the_login_process() {   //id , pass
		logger.info("User performs the login process");

			Withdraw_Method.performLogin("siddesh7897@gmail.com", "Siddesh@1811");
      
	}
	    

	@Then("User clicks on withdraw")
	public void click_Withdraw() {
		logger.info("User clicks on withdraw link");
			Withdraw_Method.clickonWithdraw();
       	
		
	}
	
	@Then("check RestButton")
	public void select_Reset_Button() {
		logger.info("check ResetButton");
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.clickonReset();
	
		
		
	}
		
	@Then("select DropDown button and test")
	public void select_DropDown_button()  {
		logger.info("select DropDown button and test");
		
			Withdraw_Method.clickselectaccount();
		
	}
	
	@Then("check withdraw with no value in input")
	public void empty_Input_amount()  {
		logger.info("check withdraw with no value in input");

			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("");

        
	}
	@Then("check withdraw with zero amount")
	public void invalid_input_amount()  {
		logger.info("check withdraw with invalid amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_Zero("0");
		
		
		System.out.println(Withdraw_Method.captureError_Zero_text());
		logger.error(Withdraw_Method.captureError_Zero_text());
		
		WebElement invalidamount = driver.findElement(By.xpath("//button[@data-dismiss='alert']//span[@aria-hidden='true'][normalize-space()='×']"));
		if (invalidamount.isDisplayed()) {
			System.out.println("Invalid amount ");	
			captureScreenshot(driver, "Invalidprice");
			//Assert.assertTrue(false);
		   
	 } 
	 }
	
	
	
	
	@Then("check withdraw with exceed bank amount")
	public void Exceed_bank_balance() throws InterruptedException  {
		logger.info("check withdraw with exceed bank amount");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Thread.sleep(1000);
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.exceedbankbalance("10000000000000000");
			
			System.out.println(Withdraw_Method.captureError_maximum_amount_Text());
			
			logger.error(Withdraw_Method.captureError_maximum_amount_Text());
			
   
		
	}
	
	
	
	@Then("give valid amount and deposite")
	public void Withdraw_Amount_from_Bank_account() throws InterruptedException {
		logger.info("give valid amount and deposite");
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("120");
      

        
		driver.quit();
}
	public static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\91939\\eclipse-workspace\\RLL_Register\\Screenshots_Withdraw\\" + fileName + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot: " + e.getMessage());	
					
		}
	
	}	
	
}
	
