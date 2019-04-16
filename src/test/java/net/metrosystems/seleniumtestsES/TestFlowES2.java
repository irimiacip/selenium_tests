package net.metrosystems.seleniumtestsES;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.metrosystems.seleniumtests.CredentialJson;
import net.metrosystems.seleniumtests.DBconnect;
import net.metrosystems.seleniumtests.LoadDrivers;
import net.metrosystems.seleniumtests.QuitDrivers;
import pages.Inbox;
import pages.LimitCheck;
import pages.LoginPage;
import pages.MainPage;



public class TestFlowES2 {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
final static Logger logger = Logger.getLogger(TestFlowES1.class);

String browser = System.getProperty("propertyName");
	
	
	@BeforeClass
	public void  before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata=CredentialJson.returnCredential(1); // return second block from json (country DE)
		driver = LoadDrivers.driver(browser,jsondata.get(9));
		logger.info("end start load data ");	
		logger.info("check login page ");
		LoginPage login = new LoginPage(driver);
       boolean objectscheck_login = login.check_objects();       
       Assert.assertTrue(objectscheck_login);
       logger.info("login page loadded correctly");      
       logger.info("perform login");
        login.typeUserName(jsondata.get(7));
		login.typePassword(jsondata.get(8));
		login.clickOnLoginButton();  
		logger.info("check login");
		Thread.sleep(9000);   	
		String title = driver.getTitle();
		System.out.println("afisare titlul 1: = " + title);
		Assert.assertEquals(title, "Metro Risk Check");	  
		logger.info("login succesfully");
		
	    }
			
	@Test(priority = 1)
   // go to inbox
	public void test1App() throws InterruptedException {

		Inbox inbox = new Inbox(driver);
		
		inbox.inboxclick(); // open inbox
		
		inbox.selectcustomer(); // select customer
		
		assertEquals(inbox.amount(),"1,000");
        
		inbox.click_cancel();//cancel request flow
	}
	
	@AfterClass
	public void after() throws IOException {
		
		String name =  driver.getClass().getName();
  		if (name.contains("InternetExplorerDriver")) {
  			driver.quit();
  		QuitDrivers.quitDriver();	
  		}else {
  			driver.quit();

  		}
	}
	//mvn clean test -Dvar1="firefox" -DtestngFile=testngDE.xml
	
}