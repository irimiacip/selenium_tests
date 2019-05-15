package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.metrosystems.seleniumtests.Highlighlit;

public class LoginPage {
	final static Logger logger = Logger.getLogger(LoginPage.class);
	static WebDriver driver;
	 By username = By.id("user_id");
	 By password = By.id("password");
	 By loginButton = By.id("submit");

	
	 public boolean check_objects() {
		 boolean init = false;
		 WebDriverWait wait = new WebDriverWait(driver,90);
		 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_id")));
		 WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		 WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));		 
		 boolean status1 = element1.isDisplayed();		 
		 boolean status2 = element2.isDisplayed();		 
		 boolean status3 = element3.isDisplayed();		 
		 
		 if (status1||status2||status3) {
			 init = true;
		 }
		return init;
	 } 
	 
	 	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver = driver;
	 }	 
	 public void typeUserName(String username_value) {	
		 logger.info("insert user");
		 WebElement user = driver.findElement(By.id("user_id"));
		 Highlighlit.highLighterMethod(driver,user);
		 driver.findElement(username).sendKeys(username_value);
	 }	 
 public void typePassword(String password_value) {
	 logger.info("insert passs");
	 WebElement pass = driver.findElement(By.id("password"));
	 Highlighlit.highLighterMethod(driver,pass);
	 driver.findElement(password).sendKeys(password_value);
	 }	 
 public void clickOnLoginButton() {
	 logger.info("insert click login");
	 WebElement login = driver.findElement(By.id("submit"));
	 Highlighlit.highLighterMethod(driver,login);
	 driver.findElement(loginButton).click();
 } 
 

}
