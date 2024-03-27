package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpagefactory {

	
	
WebDriver driver;	
	//public class name and public void name should be same//constructor
	public registerpagefactory (WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//a[normalize-space()='Sign Up Here']")
	static WebElement signup;
	
	@FindBy(xpath="//input[@id='firstName']")
	static WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	static WebElement lastname;
	
	@FindBy(xpath="//label[@for='male']//input[@id='gender']")
	static WebElement gender;
	
	@FindBy(xpath="//input[@id='dob']")
	static WebElement date;
	
	
	@FindBy(xpath="//input[@id='ssn']")
	static WebElement ssn;
	
	
	@FindBy(xpath="//input[@id='emailAddress']")
	static WebElement email;
	
	
	@FindBy(xpath="//input[@id='password']")
	static WebElement password;
	
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	static WebElement confirmpassword;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	static WebElement nextpage;
	//////
	@FindBy(xpath="//input[@id='address']")
	static WebElement address;
	
	@FindBy(xpath="//input[@id='locality']")
	static WebElement location;
	
	
	@FindBy(xpath="//input[@id='region']")
	static WebElement region;
	
	
	@FindBy(xpath="//input[@id='postalCode']")
	static WebElement postalcode;
	
	
	@FindBy(xpath="//input[@id='country']")
	static WebElement country;
	
	
	@FindBy(xpath="//input[@id='homePhone']")
	static WebElement homephone;
	
	
	@FindBy(xpath="//input[@id='mobilePhone']")
	static WebElement mobile;
	
	
	@FindBy(xpath="//input[@id='workPhone']")
	static WebElement work;
	
	
	@FindBy(xpath="//input[@id='agree-terms']")
	static WebElement terms;
	
	///
	@FindBy(xpath="//button[normalize-space()='Register']")
	static WebElement register;
	
	
public void signupbutton() {
		
	signup.click();
	}	
	
	
	//function-keys,clcik
public void registerdetails (String fname, String lname,String da , String ssnnumber, String mail, String pss ,String cpss ) {
		
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	gender.click();
	date.sendKeys(da);
	ssn.sendKeys(ssnnumber);
	email.sendKeys(mail);
	password.sendKeys(pss);
	confirmpassword.sendKeys(cpss);
	
	}
public void nextpagelink() {
	
	nextpage.click();
}

public void nextpagedetails(String addrs, String loct, String reg , String pscode, String ctry, String hph , String mphone, String wrk ) {
		
	address.sendKeys(addrs);
	location.sendKeys(loct);
	region.sendKeys(reg);
	postalcode.sendKeys(pscode);
	country.sendKeys(ctry);
	homephone.sendKeys(hph);
	mobile.sendKeys(mphone);
	work.sendKeys(wrk);
	terms.click();
		
	}
	public void registerbutton() {
		
		register.click();
	}
	
	
}
