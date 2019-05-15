package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Attachements {
	static WebDriver driver;
	final static Logger logger = Logger.getLogger(Attachements.class);
	By attachements = By.cssSelector("li[id='react-tabs-8']");

	public Attachements(WebDriver driver) {
		this.driver = driver;
	}
	public void attachements_access() throws InterruptedException {
		logger.info("open tab attchement");
		Thread.sleep(10000);
		driver.findElement(attachements).click();
	}	
	
	
	
	By attachements_processapproval = By.cssSelector("li[id='react-tabs-12']");
	public void attachements_processapproval() throws InterruptedException {
		logger.info("open tab attchement");
		Thread.sleep(10000);
		driver.findElement(attachements_processapproval).click();
	}
	
	By upload = By.cssSelector("button[class='mrc-btn mrc-secondary-button']");
	public void click_upload() throws InterruptedException {
		logger.info("push upload button");
		Thread.sleep(10000);
		driver.findElement(upload).click();
	}
	By submitrequest = By.cssSelector("button[class='mrc-primary-button submitrequest']");

	public void sent_request() throws InterruptedException {
		logger.info("click to send the reguest to the next level");
		Thread.sleep(10000);
		driver.findElement(submitrequest).click();
	}
	
	By sendbak = By.cssSelector("button[class='sendback']");
	public void send_back() throws InterruptedException {
		logger.info("click to send the reguest back to CC");
		Thread.sleep(10000);
		driver.findElement(sendbak).click();
	}
    By provideinfo = By.cssSelector("button[id='mrc-prove-info-button']");
    public void provide_info() throws InterruptedException {
		logger.info("click to send the reguest back to CC");
		Thread.sleep(10000);
		driver.findElement(provideinfo).click();
	}
}
