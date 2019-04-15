package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Request {
	static WebDriver driver;
	
	  By Request_Credit = By.cssSelector(".mrc-primary-button");
	 
	 public Request(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void RequestPerform() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.findElement(Request_Credit).click();
	 }
	 
}
