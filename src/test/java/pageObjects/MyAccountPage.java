package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class MyAccountPage {
        
	   public WebDriver driver;
	   
	   
	   public MyAccountPage(WebDriver driver) {
	      
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		   
	   }
	   
	   //Element 
	
	   
	   @FindBy(linkText="Logout")
	   WebElement clickLogOut;
	   
	
	   //Action 
	   

	   
	   public void clickLogOut() {
		   
		   clickLogOut.click();
	   }
}
