package net.metrosystems.seleniumtestsES;
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
import pages.LimitCheck;
import pages.LoginPage;
import pages.MainPage;



public class TestFlowES3 {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
final static Logger logger = Logger.getLogger(TestFlowES1.class);

String browser = System.getProperty("propertyName");
	
	
	@BeforeClass
	public void  before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata=CredentialJson.returnCredential(0); // return first block from json (country DE)
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
			
	@Test (priority = 1)
   public void test1App() throws InterruptedException  {

    
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
	Thread.sleep(9000);
	System.out.println("afisare titlul 2: = " + title);
	    	Assert.assertEquals(title, "Metro Risk Check");	  	    		
			LimitCheck limit = new LimitCheck(driver);			
     		limit.LimitCheckclick();
			limit.InsertCustomer(jsondata.get(11)); // insert first value from test_data (customer number)
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