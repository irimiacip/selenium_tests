package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.metrosystems.seleniumtests.Highlighlit;

public class CustomerDetails {
	static WebDriver driver;
	final static Logger logger = Logger.getLogger(CustomerDetails.class);
	// customer name
	// submit request
							
	String cusomer_name = "div[class='mrc-customer-trigger']";
	By CustomerName = By.cssSelector(cusomer_name);

	public CustomerDetails(WebDriver driver) {
		this.driver = driver;
	}

	public String findName() throws InterruptedException {
		Thread.sleep(8000);
		logger.info("return the name of the customer from tab CustomerDetailed");
		String name;
		WebElement customer_name = driver.findElement(By.cssSelector("div[class='mrc-customer-trigger']"));
		Highlighlit.highLighterMethod(driver,customer_name);
		name = driver.findElement(CustomerName).getText();
		return name;
	}

	static By Request_Credit = By.cssSelector(".submitrequest");

	public boolean check_RequestCredit() {
		logger.info("Check the button request credit is Enable");
		WebElement customer_name = driver.findElement(By.cssSelector(".submitrequest"));
		Highlighlit.highLighterMethod(driver,customer_name);
		return driver.findElement(Request_Credit).isDisplayed();
	}
}
