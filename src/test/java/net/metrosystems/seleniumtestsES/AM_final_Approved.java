package net.metrosystems.seleniumtestsES;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.metrosystems.seleniumtests.CredentialJson;
import net.metrosystems.seleniumtests.File;
import net.metrosystems.seleniumtests.LoadDrivers;
import net.metrosystems.seleniumtests.QuitDrivers;
import pages.Attachements;
import pages.Comments;
import pages.Inbox;
import pages.LoginPage;

public class AM_final_Approved {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
final static Logger logger = Logger.getLogger(AM_final_Approved.class);

String browser = System.getProperty("propertyName");
	
	
	@BeforeClass
	public void  before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata=CredentialJson.returnCredential(2); // return second block from json (country DE)
		driver = LoadDrivers.driver(browser,jsondata.get(9));
		logger.info("end start load data ");	
		LoginPage login = new LoginPage(driver);
       boolean objectscheck_login = login.check_objects();       
       Assert.assertTrue(objectscheck_login);
        login.typeUserName(jsondata.get(7));
		login.typePassword(jsondata.get(8));
		login.clickOnLoginButton();  
		Thread.sleep(5000);   	
		String title = driver.getTitle();
		System.out.println("afisare titlul 1: = " + title);
		Assert.assertEquals(title, "Metro Risk Check");	  
		logger.info("login succesfully");
		
	    }
	@Test(priority = 1)
	public void test1App() throws InterruptedException {
		Inbox inbox = new Inbox(driver);		
		inbox.inboxclick(); // open inbox		
		inbox.selectcustomer(); // select customer		
		assertEquals(inbox.amount(),"1,000");       
		inbox.final_approve();//approve request flow
	}
	
	//@Test(priority = 2) 
	public void test7App() throws InterruptedException {		
		Comments comment = new Comments(driver);
		comment.comment_processapproval();		
		comment.add_comment("AM approve the flow");
		comment.sent_comment();

	}

	@Test(priority = 3) 
	public void test8App() throws IOException, InterruptedException {   
		
/*		Attachements atachement = new Attachements(driver);
		atachement.attachements_processapproval();
		// upload functionality in applicaiton is wrong implemented		
		   File upload = new File(driver);
		   upload.uploadfile("activex.vch");		
		   atachement.click_upload();
		   logger.info("upload succesfully");*/	   
		logger.info("sent request");
		Inbox inbox = new Inbox(driver);
		inbox.final_approve();//approve request flow 
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
}
