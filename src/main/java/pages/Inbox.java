package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Inbox {


static WebDriver driver;
By history_img = By.cssSelector("a[href*='inbox']");

public Inbox(WebDriver driver) {
	 this.driver = driver;
}

public void inboxclick() throws InterruptedException {
	Thread.sleep(20000);
	 driver.findElement(history_img).click(); 
}
                            
By customer = By.cssSelector("div[class='mrc-detail clickable'] mrc-date");
//??  indentifcator
public void selectcustomer() throws InterruptedException {
	Thread.sleep(20000);
	 driver.findElement(customer).click();
	 Thread.sleep(10000);
}


By amount = By.cssSelector(".mrc-customers-accordion > div:nth-child(1) > span:nth-child(1) > span:nth-child(1) > h1:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > mrc-number");
// read value from screen
public String amount() {
	return driver.findElement(amount).getText();
}
// 	click cancel
	
	By cancelButton = By.id("mrc-cancel-button");
	
public void click_cancel() throws InterruptedException {
	Thread.sleep(10000);
	driver.findElement(cancelButton).click();
}
   By bloclButton = By.id("mrc-block-button");
public void click_block() throws InterruptedException {
	Thread.sleep(10000);
	driver.findElement(bloclButton).click();
}	
// CHECK IN THE DATA BASE IF THE APPROVAL IS CANCEL

}
