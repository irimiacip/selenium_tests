package net.metrosystems.seleniumtestsDE;

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

public class TestFlowDE1 {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
	final static Logger logger = Logger.getLogger(TestFlowDE1.class);

	String browser = System.getProperty("propertyName");

	@BeforeClass
	public void before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata = CredentialJson.returnCredential(0); // return first block from json (country DE)
		driver = LoadDrivers.driver(browser, jsondata.get(9));
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

//	@Test(priority = 1)

	public void test1App() throws InterruptedException {

		MainPage mainpage = new MainPage(driver);
		boolean objectscheck_mainpage = mainpage.object_check();
		Assert.assertTrue(objectscheck_mainpage);
		mainpage.limitcheck();
		mainpage.history();
		mainpage.inbox();

	}

//	@Test(priority = 2)

	public void test2App() throws InterruptedException {
		logger.info("Insert Customer for credit amount = 5000");
		Thread.sleep(5000);
		String title = driver.getTitle();
		Thread.sleep(5000);
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

//	@Test(priority = 3)

	public void test3App() throws InterruptedException {

		// Request Credit ( click button)
		logger.info("Perform Request");
		// Request.RequestPerform();
		Request request = new Request(driver);
		request.RequestPerform();

		logger.info("Perform Request DONE");
	}

//	@Test(priority = 4)

	public void test4App() {
		// Customer detail TAB open default
		CustomerDetails customer_detail = new CustomerDetails(driver);
		// check the name
		String name_from_Screen = customer_detail.findName();
		System.out.println("nume din ecran" + name_from_Screen);
		logger.info("check name of the customer displayed in the screen");
		assertEquals(customer_detail.findName(), "BARLOS SC");
		logger.info("check name of the cusotmer okay");

		// check the button submit request exist

		System.out.println("butonul exista " + customer_detail.check_RequestCredit());
		logger.info("check button");
		assertEquals(customer_detail.check_RequestCredit(), true);
		logger.info("button check susccefully");
	}

//	@Test(priority = 5)

	public void test5App() throws InterruptedException {

		// Credit detail TAB
		CreditDetails credit_details = new CreditDetails(driver);
		// clik on the TAB
		credit_details.Credit_Detail();
		// insert value
		credit_details.Amount("1000");
		// select values from dropdown
		credit_details.creditproduct();
		Thread.sleep(5000);
		credit_details.creditperiod();
		// The third value is autopopulated
	}

	//@Test(priority = 6)

	public void test6App() {
		// sales tab
		System.out.println("click sales");
		logger.info("click sales");
		// Sales.sales();
		Sales sales = new Sales(driver);
		sales.sales();
		logger.info("open page");

		logger.info("check request limit buton");
		assertEquals(Sales.check_RequestCredit(), true);
		logger.info("check succefully limit buton");

	}

//	@Test(priority = 7)
	public void test7App() {
		logger.info("click atachement");
		Comments comment = new Comments(driver);

		comment.comments_access();
		logger.info("open atachement page");

		logger.info("add comments");
		comment.add_comment("TEST QA1");
		comment.sent_comment();
		logger.info("done");
		logger.info("check sent comment");
		assertEquals(comment.getcomment_value(), "TEST QA1");
		logger.info("sent succesfully");
	}

//	@Test(priority = 8)
	public void test8App() {
		logger.info("atachement run");

		Attachements atachement = new Attachements(driver);
		logger.info("atachement access");
		atachement.attachements_access();
		logger.info("sent request");
		atachement.sent_request();

		logger.info("atachement done");
	}

	 @Test (priority = 9)
	public void test9App() throws InterruptedException {
		// go to history page
		History history = new History(driver);
		
		history.historyclick();

		history.search(jsondata.get(10));
		
		history.searchCustomer();
		
		assertEquals(history.check_nextlevel(), "SM");
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
	// mvn clean test -Dvar1="firefox" -DtestngFile=testngDE.xml

}