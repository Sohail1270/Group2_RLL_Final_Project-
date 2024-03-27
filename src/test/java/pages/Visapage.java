package pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Visapage {
	WebDriver driver;	
	
	public Visapage (WebDriver driver) {
	
		this.driver = driver;
		
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//input[@id='username']")
	static WebElement Usermail;
	
	@FindBy(xpath="//input[@id='password']")
	static WebElement Userpassword;
	
	@FindBy(xpath="//button[@id='submit']")
	static WebElement ClickLogin;
	
	
	@FindBy(xpath="((//a[normalize-space()='VISA Direct Transfer'])[1])")
	static WebElement VisaTransfer;
	
	//for select account 
	
	@FindBy(xpath="//input[@id='extAmount']")
	static WebElement Transferamount;
	
	@FindBy(xpath="//button[normalize-space()='Submit to VISA']")
	static WebElement Visaamounttransfer ;
	
	
	
	
	
	
	public void logindetails (){
		Usermail.sendKeys("Selvakumar.18ee051@gmail.com");
		Userpassword.sendKeys("Selva@2021");
		ClickLogin.click();
	}
	
	public void Visaclick () {
		
		VisaTransfer.click();
		
	}
		
	
	/*
	 * public void select_account () {
	 * 
	 * Accountnumber.selectByIndex(1);
	 * 
	 * }
	 */
	 
	
	public void amounttransfer (String amount) {
		
		Transferamount.sendKeys(amount);
		
	}
	
	
	public void clickvisabutton () {
		
		Visaamounttransfer.click();
		
	}
	
		
	
}