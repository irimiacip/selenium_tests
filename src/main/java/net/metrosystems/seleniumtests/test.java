package net.metrosystems.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
		String baseURL = "https://mrc-dev.metrosystems.net/creditlimit#/";
	    WebDriver driver = new FirefoxDriver();
		driver.get(baseURL);
		
		By username = By.id("user_id");
		 By password = By.id("password");
		 By loginButton = By.id("submit");
		 
		 
		 driver.findElement(username).sendKeys("ciprian.irimia@metrosystems.net");
		 driver.findElement(password).sendKeys("Metro_2019#03");
		 driver.findElement(loginButton).click();

		 
		 
		 
		 
		By limitcheck = By.partialLinkText("Limit Check");
		driver.findElement(limitcheck).click();
		 
		 By search = By.cssSelector(".mrc-search > input:nth-child(1)");
		 driver.findElement(search).sendKeys("BARCLOS");
		 
		 
		 By customer = By.xpath("//*[@id=\"react\"]/div/main/div/section/ul/li[2]");
		 driver.findElement(customer).click();
		 
		 
		
		 By Request_Credit = By.cssSelector(".mrc-primary-button");
		 driver.findElement(Request_Credit).click();
		
		 By Credit_Detail = By.cssSelector("#react-tabs-2");
		 driver.findElement(Credit_Detail).click();
		 
		 By Creditlimit = By.cssSelector("input.mrc-input");  
		 driver.findElement(Creditlimit).sendKeys("1000");
		 
		 
		 By credit_product = By.cssSelector("select[name='creditProduct']");
    	 Select creditproduct_value = new Select(driver.findElement(credit_product));
    	 creditproduct_value.selectByVisibleText("mrc.payment.Direct_(End_of_Month)");
    	 
    	/* Select drpCountry = new Select(driver.findElement(By.name("country")));
 		drpCountry.selectByVisibleText("ANTARCTICA");*/
		 
	
	}
}


