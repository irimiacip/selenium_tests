package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
//access credit details
	//insert credit limit 
	// select credit product
	//select creditperiod
	// select debittype

public class CreditDetails {
	static WebDriver driver;
	
	  By Credit_Detail = By.cssSelector("#react-tabs-2");
	 
	 public CreditDetails(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public  void Credit_Detail() {
		 driver.findElement(Credit_Detail).click();
	 }
	 
	  By Creditlimit = By.cssSelector("input.mrc-input");  
	 
     public  void Amount(String x) {
    	 driver.findElement(Creditlimit).sendKeys(x);
    	 
     }
	
	// select value from dropdown = creditproduct

         
         
     public void creditproduct () {
    	 //By credit_product = By.cssSelector("select[name='creditProduct']");
    	 Select creditproduct_value = new Select(driver.findElement(By.cssSelector("select[name='creditProduct']")));
    	 creditproduct_value.selectByVisibleText("mrc.payment.Direct_(End_of_Month)");
    	
    	 
    	 
     }
      
    // select value from dropdown = creditperiod 
   
     public void creditperiod () {
    	// By creditperiod = By.cssSelector("select[name='creditPeriod']");
    	 Select creditperiod_value = new Select(driver.findElement(By.cssSelector("select[name='creditPeriod']")));
    	 creditperiod_value.selectByVisibleText("mrc.payment.30");
     }

   // select value from dropdown = debitType  == autocompleate
     


    	 
    	 
}
