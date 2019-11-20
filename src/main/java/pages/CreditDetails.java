package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import net.metrosystems.seleniumtests.Highlighlit;


public class CreditDetails {
	static WebDriver driver;
	final static Logger logger = Logger.getLogger(CreditDetails.class);

	  By Credit_Detail = By.cssSelector("#react-tabs-2");
	 
	 public CreditDetails(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public  void Credit_Detail() {
		 logger.info("open credit detail tab");
		 WebElement credit_tab = driver.findElement(By.cssSelector("#react-tabs-2"));
		 Highlighlit.highLighterMethod(driver,credit_tab);
		 driver.findElement(Credit_Detail).click();
	 }
	 
	  By Creditlimit = By.cssSelector("input[class='m-input-element']");  
	 
     public  void Amount(String x) {
    	 logger.info("insert amount value");
    	 WebElement amount = driver.findElement(By.cssSelector("input[class='m-input-element']"));
		 Highlighlit.highLighterMethod(driver,amount);
    	 driver.findElement(Creditlimit).sendKeys(x);
    	 
     }
	      
     public void creditproduct () {
    	 logger.info("select first value from drop down list");
    	 
    	 WebElement credit_product = driver.findElement(By.cssSelector("select[name='creditProduct']"));
		 Highlighlit.highLighterMethod(driver,credit_product);
		 
    	 Select creditproduct_value = new Select(driver.findElement(By.cssSelector("select[name='creditProduct']")));
    	 creditproduct_value.selectByVisibleText("mrc.payment.Direct_(End_of_Month)");
     }
      
   
     public void creditperiod () {
    	 logger.info("select second value from drop down list");
    	 
    	 WebElement credit_period = driver.findElement(By.cssSelector("select[name='creditPeriod']"));
		 Highlighlit.highLighterMethod(driver,credit_period);
		 
    	 Select creditperiod_value = new Select(driver.findElement(By.cssSelector("select[name='creditPeriod']")));
    	 creditperiod_value.selectByVisibleText("mrc.payment.30");
     }    	 
}
