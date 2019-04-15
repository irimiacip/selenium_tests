package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class History {

	
	static WebDriver driver;
	By history_img = By.cssSelector("a[href*='history']");
	 
	 public History(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void historyclick() throws InterruptedException {
		 driver.findElement(history_img).click();
		 Thread.sleep(10000);
	 }
	 
	 By search = By.cssSelector(".mrc-search > input");
	 
	 public void search(String customer) throws InterruptedException {
		 driver.findElement(search).sendKeys(customer);
		 Thread.sleep(10000);
	 }
	 	
	// searchcustomer
	 
	 By customer = By.cssSelector(".mrc-search-result > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > div:nth-child(1) > h1:nth-child(1)");
	 
	 By customer_details = By.cssSelector(".mrc-request-details-title > mrc-date:nth-child(1)");
	
	 //driver.findElement(search).click();
	
	 public void searchCustomer() throws InterruptedException {
		    Thread.sleep(10000);
			driver.findElement(customer).click();
			Thread.sleep(10000);
			driver.findElement(customer_details).click();
	 }	
	// check name  in the screen
		    By level_approved  = By.cssSelector("span.mrc-position:nth-child(3)");
		    
		   public  String  check_nextlevel() {
			return driver.findElement(level_approved).getText();			   
		   }
		    

	 
}
