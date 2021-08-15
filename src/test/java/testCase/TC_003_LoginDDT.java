package testCase;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void test_loginDDT(String email, String pwd, String exp) {

		  logger.info("  Starting TC_003_LoginDDT");
	  
		  
		  try {
			  
			  driver.get(rb.getString("appURL"));   //get the url from the config class
			  logger.info("Home page Displayed");
			  driver.manage().window().maximize();
			  
			  HomePage hp = new HomePage(driver);
			  hp.clickMyAccount();
			  logger.info("Clicked on My Account ");
			 
			  hp.clickLogin();
			  logger.info("Clicked on Login ");
			   
			   
			  LoginPage lp = new LoginPage(driver);
			   
			  lp.login_email(email);
			  logger.info("Provided Email ");
			   
			  lp.login_password(pwd);
			  logger.info("Provided Password ");
			   
			  lp.loginAccount();
			  logger.info("Clicked on Login ");
			   
			   
			  boolean targetpage =lp.isMyAccountPageExist() ; // this will return true or false 
			  
			  if(exp.equals("Valid")) { //passing valid data 
				  if(targetpage==true) {  //passing valid data and page displayed 
					  
					  logger.info("login Success ");
					  
					  MyAccountPage myaccpage = new MyAccountPage(driver);
					  myaccpage.clickLogOut();
					  Assert.assertTrue(true);
				 
				  }else { //passing valid data and page not display
					
					  logger.info("Login Failed");
					  Assert.assertTrue(false);
					  
				  }
				  

				  if(exp.equals("Invalid")) { //passing Invalid data 
					  if(targetpage==true) {  //passing Invalid data and page displayed 
						  
						  MyAccountPage myaccpage = new MyAccountPage(driver);
						  myaccpage.clickLogOut();				
						  Assert.assertTrue(false);
					  }else{ //passing valid data and page not display
						  logger.info("Login Failed");
						  Assert.assertTrue(true);
						  
					  }
				  }	
			  }
		  }catch(Exception e) {
		     logger.fatal("Login Failed ");
		     Assert.fail();
			  
		  }
	         logger.info(" Finished TC_003_LoginDDT");
	  
	}  

        @DataProvider(name="LoginData")	
	    public String[][] getData() throws IOException{
		
		
		String path = "./testData/Opencart_LoginData.xlsx";
		
		XLUtility xlutil = new XLUtility(path);
		
		int totalRow =  xlutil.getRowCount("Sheet1");
		int totalCol =  xlutil.getCellCount("Sheet1", totalRow);
		
		String logindata[][]  = new String [totalRow][totalCol];//initilizing the size of the array 
		
		for(int i = 1; i<totalRow; i++) {
			for(int j=0; j<totalCol;j++) {
				
				logindata[i-1][j] = xlutil.getCellData("Sheet1", totalRow, totalCol);//excel hearder starts with 0, but we want to put them into array start from 0 
				
			}
		}
		
		return logindata;

	}
        

}
