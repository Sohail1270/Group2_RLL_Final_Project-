
  package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		    features = {"C:\\Users\\91939\\eclipse-workspace\\RLL_Register\\src\\test\\java\\feature"}, // Path to your feature files
		
		
		    glue = {"steps"},
		    dryRun=false,  // it means you want Cucumber to execute the actual test code associated with the Gherkin's steps during the test run and if you give true it will only provide the steps that are not glued.
		    plugin = {
		        "html:target/Digital_bank.html",
		        
		        "pretty",
		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        "timeline:test-output-thread/"
		    }
		// Package where your step definitions are located
		)
	
  
  public class testngrunner extends AbstractTestNGCucumberTests {
  
  }
 