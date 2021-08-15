package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
          
	
	public WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);  // this is used to initialize the object when instances are created for page objects 
		
	}
	
	
	//element 
	    @FindBy(xpath="//span[normalize-space()='My Account']")
	    WebElement lnKMyAccount;
	
	    
	    @FindBy(xpath="//a[normalize-space()='Register']")
	    WebElement lnKRegister;
	    
	   
	    @FindBy(xpath="//a[normalize-space()='Login']")
	    WebElement lnKLogin;
	    
	    
	    
	    //Action
	    
	public void clickMyAccount() {
	    	
		lnKMyAccount.click();
    }
	
	public void clcickRegister() {
		lnKRegister.click();
	}
	
	
	public void clickLogin() {
		lnKLogin.click();
	}
}
