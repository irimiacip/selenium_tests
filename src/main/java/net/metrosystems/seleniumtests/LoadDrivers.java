package net.metrosystems.seleniumtests;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class LoadDrivers {
	
	
  	    public static final String USERNAME = "METRO_FINS_MRC";
	//public static final String USERNAME = "catalinmorariu";
	  	public static final String ACCESS_KEY = "32f0fc00-750c-44a2-8def-61b30b9b4f09";
  	  //public static final String ACCESS_KEY = "3ad60678-70fd-4cf3-ab18-df365d8ca47f";
	  	public static final String URL = "https://" + "METRO_FINS_MRC" + ":" + "32f0fc00-750c-44a2-8def-61b30b9b4f09" + "@ondemand.saucelabs.com:443/wd/hub";
		
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
    	  		
  
       	  	DesiredCapabilities caps = DesiredCapabilities.chrome();
       	    caps.setCapability("platform", "Windows 10");
       	    caps.setCapability("version", "latest");
       	 
       	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
       	 
    	 /* 		ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("disable-infobars");
                String hubURL = "http://10.97.178.217:4444/wd/hub";
   	  		    WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);*/
   	  		 
   	  		 
    	  		//WebDriver driver = new ChromeDriver();
    	  		driver.manage().window().maximize() ;
    	  		driver.get(url);

    	  	 	   
    	  		return driver;     	  		
    	  	  }
    }
    
    	
    	
    
    
   
    


   

    	
}