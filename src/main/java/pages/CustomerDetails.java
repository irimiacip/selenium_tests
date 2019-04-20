package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDetails {
	static WebDriver driver;
	
	// customer name
	// submit request
							
	String cusomer_name = "div[class='mrc-customer-trigger']";
	By CustomerName = By.cssSelector(cusomer_name);

	public CustomerDetails(WebDriver driver) {
		this.driver = driver;
	}

	public String findName() throws InterruptedException {
		Thread.sleep(5000);
		String name;
		name = driver.findElement(CustomerName).getText();
		return name;
	}

	static By Request_Credit = By.cssSelector(".submitrequest");

	public boolean check_RequestCredit() {

		return driver.findElement(Request_Credit).isDisplayed();
	}
}
