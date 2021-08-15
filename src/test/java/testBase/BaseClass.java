package testBase;
// this class is created by me
import java.io.File;
import java.io.IOException;

import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;  // read config.properties 
	 
	@BeforeClass(groups= {"testng","sanity","regression"})
	@Parameters({"browser"})
	public void setUP(String br) {
		
		
		//Load config.properties 
		
		rb= ResourceBundle.getBundle("config");
		//logging 
		//logger = LogManager.getLogger(this.getClass());
		logger = LogManager.getLogger(this.getClass());
		
		//Driver
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launched Chrome Browser");
			//driver.get("https://demo.opencart.com/");
		}else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launched edge Browser");
		}else if(br.equals("firefox")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launched Firefox Browser");
		}
	}	
		
	
	@AfterClass
	public void tearDown() {
	
		driver.close();
    }
		

	public String randomstring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomnumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+ tname+".png");
		FileUtils.copyFile(source, target);
		
	}
}
