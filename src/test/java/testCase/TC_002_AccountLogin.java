package testCase;


import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_AccountLogin extends BaseClass{
    
	   
@Test(groups= {"sanity","mastersuit"})
public void test_account_loin() {
	
	  logger.info(" Starting TC_002_AccountLogin ");
	  
	  try {
		 
		  driver.get(rb.getString("appURL"));   //get the url from the config class
		  logger.info("Home page Displayed");
		  driver.manage().window().maximize();
		  
		   HomePage hp = new HomePage(driver);
		   hp.clickMyAccount();
		   logger.info("Clicked on My Account ");
		   hp.clickLogin();
		   logger.info("Clicked on Register ");
		
		   
		   LoginPage lp = new LoginPage(driver);
		   
		   lp.login_email(rb.getString("email"));
		   logger.info("Provided Email ");
		   
		   lp.login_password(rb.getString("password"));
		   logger.info("Provided Password ");
		   
		   lp.loginAccount();
		   logger.info("Clicked on Login ");
		   
		   
		   boolean targetpage =lp.isMyAccountPageExist() ;
		   
		   if(targetpage) {
			   logger.info("Login Success ");
			   Assert.assertTrue(true);
		   }else {
			   logger.info("Login Failed ");
			   Assert.assertTrue(false);
		   }
		   
	  }catch(Exception e) {
		  logger.fatal("Login Failed ");
			Assert.fail();
		  
		  
	  }
	 
	   
	  logger.info(" Finished TC_002_AccountLogin");
	
	
}
	 
}
