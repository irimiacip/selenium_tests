package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Attachements {
	static WebDriver driver;
	By attachements = By.cssSelector("li[id='react-tabs-8']");

	public Attachements(WebDriver driver) {
		this.driver = driver;
	}

	public void attachements_access() {
		driver.findElement(attachements).click();
	}

	
	
	
	By submitrequest = By.cssSelector("button[class='mrc-primary-button submitrequest']");

	public void sent_request() {
		driver.findElement(submitrequest).click();
	}
	
	
	By upload = By.cssSelector("button[class='mrc-btn mrc-secondary-button']");
	public void click_upload() {
		driver.findElement(upload).click();
	}
}
