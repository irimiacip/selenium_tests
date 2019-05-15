package net.metrosystems.seleniumtestsES;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.metrosystems.seleniumtests.CredentialJson;
import net.metrosystems.seleniumtests.DBconnect;
import net.metrosystems.seleniumtests.File;
import net.metrosystems.seleniumtests.Highlighlit;
import net.metrosystems.seleniumtests.LoadDrivers;
import net.metrosystems.seleniumtests.QuitDrivers;
import pages.Attachements;
import pages.Comments;
import pages.CreditDetails;
import pages.CustomerDetails;
import pages.History;

import pages.LimitCheck;
import pages.LoginPage;
import pages.MainPage;
import pages.Request;
import pages.Sales;

public class TestFlowES1 {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
	final static Logger logger = Logger.getLogger(TestFlowES1.class);

	String browser = System.getProperty("propertyName");

	@BeforeClass
	public void before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata = CredentialJson.returnCredential(0); // return first block from json (country DE)
		driver = LoadDrivers.driver(browser, jsondata.get(9));
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
		MainPage mainpage = new MainPage(driver);
		boolean objectscheck_mainpage = mainpage.object_check();
		Assert.assertTrue(objectscheck_mainpage);
		mainpage.limitcheck();
		mainpage.history();
		mainpage.inbox();
	}

	@Test(priority = 2)

	public void test2App() throws InterruptedException {
		logger.info("Insert Customer for credit amount = 1000");
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("afisare titlul 2: = " + title);
		Assert.assertEquals(title, "Metro Risk Check");
		LimitCheck limit = new LimitCheck(driver);
		limit.LimitCheckclick();
		limit.InsertCustomer(jsondata.get(10)); // insert first value from test_data (customer number)
		limit.SearchCustomer();
		for (int i = 0; i < jsondata.size(); i++) {
			System.out.println(jsondata.get(i));
		}
		dbvalue = DBconnect.getPostrgresSqlConnection(jsondata.get(5), jsondata.get(3), jsondata.get(4));
		for (int i = 0; i < dbvalue.size(); i++) {
			System.out.println("value from db : " + dbvalue.get(i));
		}
	}

	@Test(priority = 3)

	public void test3App() throws InterruptedException {
		Request request = new Request(driver);
		request.RequestPerform();
	}

	@Test(priority = 4) 

	public void test4App() throws InterruptedException {
		CustomerDetails customer_detail = new CustomerDetails(driver);
		String name_from_Screen = customer_detail.findName();
		assertEquals(customer_detail.findName(), "* 15/32901 BARLOS SC");
		assertEquals(customer_detail.check_RequestCredit(), true);
	}

	@Test(priority = 5) 

	public void test5App() throws InterruptedException {

		CreditDetails credit_details = new CreditDetails(driver);
		credit_details.Credit_Detail();
		credit_details.Amount("1000");
		credit_details.creditproduct();
		credit_details.creditperiod();
	}

	@Test(priority = 6) 

	public void test6App() {
		Sales sales = new Sales(driver);
		sales.sales();
		assertEquals(Sales.check_RequestCredit(), true);
	}

	@Test(priority = 7) 
	public void test7App() {		
		Comments comment = new Comments(driver);
		comment.comments_access();		
		comment.add_comment("Comment sent by CC");
		comment.sent_comment();
		assertEquals(comment.getcomment_value(), "Comment sent by CC ");
	}

	@Test(priority = 8) 
	public void test8App() throws IOException, InterruptedException {   
		
		Attachements atachement = new Attachements(driver);
		atachement.attachements_access();
		// upload functionality in applicaiton is wrong implemented		
		   File upload = new File(driver);
		   upload.uploadfile("activex.vch");		
		   atachement.click_upload();
		   logger.info("upload succesfully");		   
		logger.info("sent request");
		atachement.sent_request();
	}


	
	@AfterClass
	public void after() throws IOException {
		String name = driver.getClass().getName();
		if (name.contains("InternetExplorerDriver")) {
			driver.quit();
			QuitDrivers.quitDriver();
		} else {
			driver.quit();
		}
	}
	// mvn clean test -Dvar1="firefox" -DtestngFile=testngES_CancelRequest.xml

}