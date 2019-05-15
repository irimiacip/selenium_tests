package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.metrosystems.seleniumtests.Highlighlit;

public class Sales {

	final static Logger logger = Logger.getLogger(Sales.class);
	static WebDriver driver;
	
	  By Sales = By.cssSelector("#react-tabs-4");
	 
	 public Sales(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public  void sales() {
		 logger.info("open sales tab");
		 WebElement sales_tab = driver.findElement(By.cssSelector("#react-tabs-4"));
			Highlighlit.highLighterMethod(driver,sales_tab);
		 driver.findElement(Sales).click();
	 }
	 
	 static By Request_Credit = By.cssSelector(".submitrequest");

	 public static boolean check_RequestCredit() {
		 logger.info("check button request credit exist");
		 WebElement check_requestcredit = driver.findElement(By.cssSelector(".submitrequest"));
			Highlighlit.highLighterMethod(driver,check_requestcredit);
		 return driver.findElement(Request_Credit).isDisplayed();
	 }
}
