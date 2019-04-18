package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LimitCheck {
	
	static WebDriver driver;
	 By limitcheck = By.cssSelector("a[href*='limitCheck'] img"); 
	 By search = By.cssSelector("input[class='m-input-element extra-class-on-input-tag']");
	 By customer = By.cssSelector(".mrc-search-result > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > div:nth-child(1) > h1:nth-child(1)");
	         
	 public LimitCheck(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void LimitCheckclick() throws InterruptedException {
		 driver.findElement(limitcheck).click();
		 Thread.sleep(10000);
	 }
	
	 public void InsertCustomer(String value) throws InterruptedException {
		 driver.findElement(search).sendKeys(value);
		 Thread.sleep(10000);
	 }
	 
	//driver.findElement(search).click();
	
	 public void SearchCustomer() throws InterruptedException {
		 Thread.sleep(10000);
			driver.findElement(customer).click();
			Thread.sleep(10000);  
	 }
	 
}
