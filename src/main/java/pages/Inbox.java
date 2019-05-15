package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.metrosystems.seleniumtests.Highlighlit;




public class Inbox {

	final static Logger logger = Logger.getLogger(Inbox.class);
static WebDriver driver;
By history_img = By.cssSelector("a[href*='inbox'] img");

public Inbox(WebDriver driver) {
	 this.driver = driver;
}

public void inboxclick() throws InterruptedException {
	Thread.sleep(10000);
	logger.info("click inbox img");
	 driver.findElement(history_img).click(); 
}
                            
By customer = By.cssSelector("div[class='mrc-detail clickable'] mrc-date");
//??  indentifcator
public void selectcustomer() throws InterruptedException {
	Thread.sleep(10000);
	WebElement select_customer = driver.findElement(By.cssSelector("div[class='mrc-detail clickable'] mrc-date"));
	 Highlighlit.highLighterMethod(driver,select_customer);
	logger.info("select customer");
	 driver.findElement(customer).click();
	 Thread.sleep(10000);
}


By amount = By.cssSelector(".mrc-customers-accordion > div:nth-child(1) > span:nth-child(1) > span:nth-child(1) > h1:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > mrc-number");
// read value from screen   
public String amount() throws InterruptedException {
	logger.info("get amount value");
	Thread.sleep(10000);
	WebElement value_amount = driver.findElement(By.cssSelector(".mrc-customers-accordion > div:nth-child(1) > span:nth-child(1) > span:nth-child(1) > h1:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > mrc-number"));
	 Highlighlit.highLighterMethod(driver,value_amount);
	Thread.sleep(10000);
	return driver.findElement(amount).getText();
}
// 	click cancel
	
	By cancelButton = By.id("mrc-cancel-button");
	
public void click_cancel() throws InterruptedException {
	Thread.sleep(10000);
	logger.info("cancel request");
	WebElement cancel = driver.findElement(By.cssSelector("mrc-cancel-button"));
	 Highlighlit.highLighterMethod(driver,cancel);
	driver.findElement(cancelButton).click();
}
   By bloclButton = By.id("mrc-block-button");
public void click_block() throws InterruptedException {
	Thread.sleep(10000);
	logger.info("block request");
	WebElement block = driver.findElement(By.cssSelector("mrc-block-button"));
	 Highlighlit.highLighterMethod(driver,block);
	driver.findElement(bloclButton).click();
}	           
                  //   approval sent forward          = button[id='mrc-prove-info-button']
                  // request info 
                                
// CHECK IN THE DATA BASE IF THE APPROVAL IS CANCEL
By approveButton = By.cssSelector("button[id='mrc-approve-button']");
public void click_approve() throws InterruptedException {
	Thread.sleep(10000);
	logger.info("approve request");
	WebElement approve = driver.findElement(By.cssSelector("button[id='mrc-approve-button']"));
	 Highlighlit.highLighterMethod(driver,approve);
	driver.findElement(approveButton).click();
}

By final_approve = By.cssSelector("button[id='mrc-confirm-button']");

public void final_approve() throws InterruptedException {
	Thread.sleep(10000);
	logger.info("approve request");
	WebElement finalapprove = driver.findElement(By.cssSelector("button[id='mrc-confirm-button']"));
	 Highlighlit.highLighterMethod(driver,finalapprove);
	driver.findElement(final_approve).click();
}

By level_sendrequest = By.cssSelector(".mrc-send-back > select");

public void select_sendLevel(String select_level) {	
	logger.info("select level to send back for more data");
	WebElement level = driver.findElement(By.cssSelector(".mrc-send-back > select"));
	 Highlighlit.highLighterMethod(driver,level);
	Select drpCountry = new Select(driver.findElement(level_sendrequest));
	drpCountry.selectByVisibleText(select_level);
}

}
