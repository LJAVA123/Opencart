package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//elemetns 
	
	@FindBy(id="input-email")
	WebElement txt_EmailAddress;
	
	@FindBy(id="input-password")
	WebElement txt_passwordLogin;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement click_login;
	
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	//actions 
	
	public void login_email(String loginEmail) {
		txt_EmailAddress.sendKeys(loginEmail);
		
	}
	
	
	public void login_password(String loginPassword) {
		txt_passwordLogin.sendKeys(loginPassword);
		
	}
	
	public void loginAccount() {
		click_login.click(); 
		
	}
	
	public boolean isMyAccountPageExist() {
		try {
			return(msgHeading.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}


	
}
