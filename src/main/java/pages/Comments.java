package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;


public class Comments {
	static WebDriver driver;
	  By comment = By.cssSelector("#react-tabs-6");
	
	 public Comments(WebDriver driver) {
		 this.driver = driver;
	 }
	 public  void comments_access() {
		 driver.findElement(comment).click();
	 }
	  By comment_insert = By.cssSelector("textarea.m-input-element");

	 public  void add_comment(String comment) {
		 driver.findElement(comment_insert).click();
		 driver.findElement(comment_insert).sendKeys(comment);
	 }
	  By comment_push = By.cssSelector(".mrc-secondary-button");
    
	 public  void sent_comment() {
		 driver.findElement(comment_push).click();
	 }
	  By comment_value = By.cssSelector(".content");
	
	 public  String getcomment_value() {
		 return driver.findElement(comment_value).getText();
	 }
	 	 
}
