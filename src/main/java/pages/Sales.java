package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sales {

	
	static WebDriver driver;
	
	  By Sales = By.cssSelector("#react-tabs-4");
	 
	 public Sales(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public  void sales() {
		 driver.findElement(Sales).click();
	 }
	 
	 static By Request_Credit = By.cssSelector(".submitrequest");

	 public static boolean check_RequestCredit() {
		 
		 return driver.findElement(Request_Credit).isDisplayed();
	 }
}
