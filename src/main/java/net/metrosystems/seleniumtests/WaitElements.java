package net.metrosystems.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElements {

	WebDriver driver ;
	
	public WebDriverWait wait = new WebDriverWait(driver,30);
}
