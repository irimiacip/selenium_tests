package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {

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
		 driver.findElement(username).sendKeys(username_value);
	 }	 
 public void typePassword(String password_value) {
	 driver.findElement(password).sendKeys(password_value);
	 }	 
 public void clickOnLoginButton() {
	 driver.findElement(loginButton).click();
 } 
}
