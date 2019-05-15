package pages;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import net.metrosystems.seleniumtests.Highlighlit;


public class Comments {
	final static Logger logger = Logger.getLogger(Comments.class);
	static WebDriver driver;
	  By comment = By.cssSelector("#react-tabs-6");
	
	 public Comments(WebDriver driver) {
		 this.driver = driver;
	 }
	 public  void comments_access() {
		 logger.info("open tab comment");
		 WebElement comment_tab = driver.findElement(By.cssSelector("#react-tabs-6"));
		 Highlighlit.highLighterMethod(driver,comment_tab);
		 driver.findElement(comment).click();
	 }
	 
	 By comment_processapproval = By.cssSelector("li[id='react-tabs-10']");
	 public  void comment_processapproval() throws InterruptedException {
		 logger.info("open tab comment");
		 Thread.sleep(10000);
		 WebElement comment_processtab = driver.findElement(By.cssSelector("li[id='react-tabs-10']"));
		 Highlighlit.highLighterMethod(driver,comment_processtab);
		 driver.findElement(comment_processapproval).click();
	 }
	 
	  By comment_insert = By.cssSelector("textarea.m-input-element");

	 public  void add_comment(String comment) {
		 logger.info("click in text area");
		 driver.findElement(comment_insert).click();
		 logger.info("insert comment");
		 WebElement textarea = driver.findElement(By.cssSelector("textarea.m-input-element"));
		 Highlighlit.highLighterMethod(driver,textarea);
		 driver.findElement(comment_insert).sendKeys(comment);
	 }
	  By comment_push = By.cssSelector(".mrc-secondary-button");
    
	 public  void sent_comment() {
		 logger.info("click send comment");
		 WebElement push_comment = driver.findElement(By.cssSelector(".mrc-secondary-button"));
		 Highlighlit.highLighterMethod(driver,push_comment);
		 driver.findElement(comment_push).click();
	 }
	  By comment_value = By.cssSelector("div[class='content']");
	
	 public  String getcomment_value() {
		 logger.info("read value updated");
		 WebElement updated_comment = driver.findElement(By.cssSelector("div[class='content']"));
		 Highlighlit.highLighterMethod(driver,updated_comment);
		 return driver.findElement(comment_value).getText();
	 }
	 	 
}
