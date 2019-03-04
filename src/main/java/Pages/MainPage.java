package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	static WebDriver driver;

	 By limitcheck = By.partialLinkText("Limit Check");
	 By history = By.partialLinkText("History");
	 By inbox = By.partialLinkText("Inbox");	 
	 By limitcheck_img = By.xpath("//img[starts-with(@alt,'Limit Check')]");
	 By history_img = By.xpath("//img[starts-with(@alt,'History')]");
	 By inbox_img = By.xpath("//img[starts-with(@alt,'Inbox')]");

	
	
	public boolean object_check() {
		boolean init = false;
		
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(limitcheck));
		 WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(limitcheck_img));
		 WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(history));		 
		 WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(history_img));		 
		 WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(inbox));		 
		 WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(inbox_img));	 
		 		 
		 boolean status1 = element1.isDisplayed();		 
		 boolean status2 = element2.isDisplayed();		 
		 boolean status3 = element3.isDisplayed();	
		 boolean status4 = element4.isDisplayed();
		 boolean status5 = element5.isDisplayed();
		 boolean status6 = element6.isDisplayed();

		 if (status1||status2||status3||status4||status5||status6) {
			 init = true;
		 }
		return init;
	}
		public MainPage(WebDriver driver) {
			 this.driver = driver;
		}
		 public void limitcheck() throws InterruptedException {
			 driver.findElement(limitcheck).click();
			 Thread.sleep(1000);
			 driver.navigate().back();
			 driver.findElement(limitcheck_img).click();
			 Thread.sleep(1000);
			 driver.navigate().back();
		 }	 
	 public void history() throws InterruptedException {
		 driver.findElement(history).click();
		 Thread.sleep(1000);
		 driver.navigate().back();
		 driver.findElement(history_img).click();
		 Thread.sleep(1000);
		 driver.navigate().back();
		 }	 
	 public void inbox() throws InterruptedException {
		 Thread.sleep(1000);
		 driver.findElement(inbox_img).click(); 
		 Thread.sleep(1000);
		 driver.navigate().back();
		 driver.findElement(inbox).click();
		 Thread.sleep(1000);
		 driver.navigate().back();
	 } 
		
	
}
