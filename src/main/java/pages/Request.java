package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.metrosystems.seleniumtests.Highlighlit;

public class Request {
	static WebDriver driver;
	final static Logger logger = Logger.getLogger(Request.class);
	  By Request_Credit = By.cssSelector(".mrc-primary-button");
	 
	 public Request(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void RequestPerform() throws InterruptedException {
		 logger.info("Request credit");
		 Thread.sleep(5000);
		 WebElement push_request = driver.findElement(By.cssSelector(".mrc-primary-button"));
		 Highlighlit.highLighterMethod(driver,push_request);
		 driver.findElement(Request_Credit).click();
		 logger.info("Click on button succesfully");
	 }
	 
}
