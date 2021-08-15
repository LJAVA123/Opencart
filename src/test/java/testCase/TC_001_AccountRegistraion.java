package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistraion extends BaseClass{

	
	
	//public WebDriver driver;
	
	@Test(groups= {"regression","mastersuit"})
	public void test_account_registration() {
		
		
		logger.info(" Starting TC_001_AccountRegistration ");
		try {
			
		driver.get(rb.getString("appURL"));
		logger.info("Home page Displayed");
		driver.manage().window().maximize();
		
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clcickRegister();
		logger.info("Clicked on Register ");
	    
		AccountRegisterPage regpage = new AccountRegisterPage(driver);
		regpage.setFirstName("ABC");
		logger.info("Provided First Name ");
		regpage.setLasttName("EFG");
		logger.info("Provided Last Name ");
		regpage.setEmail(randomstring()+"@gmail.com");
		logger.info("Provided Email ");
		
		regpage.setPhone("123456");
		logger.info("Provided Telephone ");
		regpage.setPassword("ab123456");
		logger.info("Provided Password ");
		regpage.setConfirmedPassword("ab123456");
		logger.info("Provided Confrmed Password ");
		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		regpage.click_Continue();
		logger.info("Clicked on Continue ");

		
		
		String confmsg=regpage.getConfirmatingMsg();
		
		//correct message suppose to be : Your Account Has Been Created!
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{
			
			logger.error("Account Registration Failed ");
			captureScreen(driver,"test_account_registration");
			Assert.assertTrue(false);
		}	
	
		
	}catch(Exception e){
		logger.fatal("Account Registration Failed ");
		Assert.fail();
	}	

	logger.info(" Finished TC_001_AccountRegistration");
}
	
}
