package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 

public class loginpage   {
	 WebDriver driver;
	 public loginpage(WebDriver d) {
	      driver = d;
//	        PageFactory.initElements(driver, this);
	    }
	 //
	 By username=By.id("username");
	 By password=By.id("password");
	 By submit=By.id("submit");
	public void username(String uname) 
	{
		  	
 driver.findElement(username).sendKeys(uname);  
 
 
		
	}
	public void pswd(String psw) 
	{
		  	
 driver.findElement(password).sendKeys(psw);  
 
 
		
	}
	 
	public void clickloginbutton()
	{
	 
		 driver.findElement(submit).click(); 
	}

	}
 
