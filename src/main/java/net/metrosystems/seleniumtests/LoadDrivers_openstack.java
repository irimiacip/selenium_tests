package net.metrosystems.seleniumtests;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class LoadDrivers_openstack {
	
		
    public  static  WebDriver Driver(String browser , String url) throws IOException {
    	

    	  if (browser.equals("firefox")) {
    		  System.out.println("Afiseaza input value :"+ browser);
    	  		//System.setProperty("webdriver.gecko.driver","/home/ciprian/Downloads/drivers/geckodriver");
    	  		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
    	  		
    	  		FirefoxOptions  options = new FirefoxOptions();
                options.addArguments("disable-infobars");
    	  		String hubURL = "http://10.97.178.217:4444/wd/hub";
    	  		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);
    	  		
    	  		 //WebDriver driver = new FirefoxDriver();
    			driver.manage().window().maximize() ;
    			driver.get(url);

    			return driver;	
    	  	  }else {
    	  		//System.setProperty("webdriver.chrome.driver","/home/ciprian/Downloads/drivers/chromedriver");
    	  		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
    	  		
    	  		ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("disable-infobars");
                String hubURL = "http://10.97.178.217:4444/wd/hub";
   	  		    WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);
   	  		 
   	  		 
    	  		//WebDriver driver = new ChromeDriver();
    	  		driver.manage().window().maximize() ;
    	  		driver.get(url);

    	  	 	   
    	  		return driver; 
    	  		
    	  	  }

    }
    
    	
    	
    
    
   
    


   

    	
}