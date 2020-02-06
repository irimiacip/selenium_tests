package net.metrosystems.seleniumtests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.base.Function;

import net.metrosystems.seleniumtests.CredentialJson;
import net.metrosystems.seleniumtests.LoadDrivers;
import pages.LimitCheck;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.postgresql.Driver;
import org.testng.Assert;



public class TestFlowDE {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
final static Logger logger = Logger.getLogger(TestFlowDE.class);

String browser = System.getProperty("propertyName");
		
	@BeforeClass
	public void  before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata=CredentialJson.returnCredential(0);
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
	    }
			
	@Test (priority = 1)
   public void test1App() throws InterruptedException  {

    	Thread.sleep(5000);   	
    	String title = driver.getTitle();
    	Assert.assertEquals(title, "Metro Risk Check");	  
    	 logger.info("login succesfully");
	MainPage mainpage = new MainPage(driver);
	boolean objectscheck_mainpage = mainpage.object_check();
	Assert.assertTrue(objectscheck_mainpage);
	mainpage.limitcheck();
	mainpage.history();
	mainpage.inbox();
	}   

	@Test (priority = 2)
		
	public void test2App() throws InterruptedException {
		logger.info("Insert Customer for credit amount = 5000");
		Thread.sleep(5000);   	
	String title = driver.getTitle();
	Thread.sleep(5000);
	System.out.println("afisare titlul: = " + title);
	    	Assert.assertEquals(title, "Metro Risk Check");	  	    		
			LimitCheck limit = new LimitCheck(driver);			
     		limit.LimitCheckclick();
			limit.InsertCustomer(jsondata.get(10));
			limit.SearchCustomer();
			for (int i = 0; i<jsondata.size(); i++) {
				System.out.println(jsondata.get(i));
			}
			
			dbvalue=DBconnect.getPostrgresSqlConnection(jsondata.get(5), jsondata.get(3), jsondata.get(4));
			
			for (int i = 0 ; i<dbvalue.size(); i++) {
				System.out.println("value from db : " + dbvalue.get(i));
			}
			
		} 

	@AfterClass
	public void after() {
		driver.close();
	}
	//mvn clean test -Dvar1="firefox"
	
}