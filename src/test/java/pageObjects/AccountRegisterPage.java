package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegisterPage {
	
	public WebDriver driver;
	
	
	public AccountRegisterPage(WebDriver driver) {
		
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Element 
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	
	@FindBy(id="input-telephone")
	WebElement txt_phone;
	
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(id="input-confirm")
	WebElement txt_ConfirmPassword;
	
	
	@FindBy(id="//input[@value='0']")
	WebElement click_subscribe;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement readPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement click_Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
   //action 
	
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLasttName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phone) {
		txt_phone.sendKeys(phone);
	}
	
	
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void setConfirmedPassword(String confirmedPassword) {
		txt_ConfirmPassword.sendKeys(confirmedPassword);
	}
	
	public void setPrivacyPolicy() {
		readPolicy.click();
	}
	
	public void click_Continue() {
		click_Continue.click();
	}
	
	public String getConfirmatingMsg() {
		try
		{
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
