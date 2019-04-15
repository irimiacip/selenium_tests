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
	  	public static final String ACCESS_KEY = "32f0fc00-750c-44a2-8def-61b30b9b4f09";
	  	public static final String URL = "https://" + "METRO_FINS_MRC" + ":" + "32f0fc00-750c-44a2-8def-61b30b9b4f09" + "@ondemand.saucelabs.com:443/wd/hub";
		
    public  static  WebDriver driver(String browser , String url) throws IOException {
    	
    	if (OperatingSystem.results().contains("Windows")){   		
    		OperatingSystem.proxymetro();	 
    		System.out.println("windowssss");
    	}
    	
    	  if (browser.equals("firefox")) {
    		  System.out.println("Afiseaza input value :"+ browser);
    	  		//System.setProperty("webdriver.gecko.driver","/home/ciprian/Downloads/drivers/geckodriver");
    	  		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
    	  		
           	  	DesiredCapabilities caps = DesiredCapabilities.firefox();
           	    //caps.setCapability("platform", "Windows 10");
           	    caps.setCapability("platform", "Linux");
           	    caps.setCapability("version", "latest");
           	    caps.setCapability("screenResolution", "1024x768");
           	 
           	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    	  		
/*    	  		FirefoxOptions  options = new FirefoxOptions();
                options.addArguments("disable-infobars");
    	  		String hubURL = "http://10.97.178.217:4444/wd/hub";
    	  		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);*/
    	  		
    	  		 //WebDriver driver = new FirefoxDriver();
    			driver.manage().window().maximize();
    			driver.get(url);

    			return driver;	
    	  	  }else if (browser.equals("chrome")){
    	  		//System.setProperty("webdriver.chrome.driver","/home/ciprian/Downloads/drivers/chromedriver");
    	  		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
    	  		
  
       	  	DesiredCapabilities caps = DesiredCapabilities.chrome();
       	    //caps.setCapability("platform", "Windows 10");
       	    caps.setCapability("platform", "Linux");
       	    caps.setCapability("version", "latest");
       	    caps.setCapability("screenResolution", "1024x768");

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
    	  	  } else if (browser.equals("Iexplorer")){
      	  		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/IEDriverServer.exe");
      	  	  
             	  	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
             	    caps.setCapability("platform", "Windows 10");
             	    caps.setCapability("version", "latest");
               	    caps.setCapability("screenResolution", "1920x1200");

             	   
             	   
             	 //  caps.setCapability("app","sauce-storage:test.exe");
         //    	  caps.setCapability("prerun", WindowsExecutable.callExe());
             	    
             	  // test.loadInternetExplorerDesiredCaps();
             	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
              	//   caps.setCapability("executable","sauce-storage:test.exe");

          	  		driver.manage().window().maximize() ;
              	//   caps.setCapability("app","sauce-storage:test.exe");

          	  		driver.get(url);
          	  	 	   
          	  		return driver;     	  		
      	  	  } else if (browser.equals("ChromeW")) {
      	  		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
        	  	  
         	  	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
         	    caps.setCapability("platform", "Windows 10");
         	    caps.setCapability("version", "latest");
           	    caps.setCapability("screenResolution", "1280x1024");
         	 //  caps.setCapability("app","sauce-storage:test.exe");
     //    	  caps.setCapability("prerun", WindowsExecutable.callExe());
         	    
         	  // test.loadInternetExplorerDesiredCaps();
         	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
          	//   caps.setCapability("executable","sauce-storage:test.exe");

      	  		driver.manage().window().maximize() ;
          	//   caps.setCapability("app","sauce-storage:test.exe");

      	  		driver.get(url);
      	  	 	   
      	  		return driver;   
      	  	  } else {
      	  		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
      	  	  
         	  	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
         	    caps.setCapability("platform", "Windows 10");
         	    caps.setCapability("version", "latest");
           	    caps.setCapability("screenResolution", "1280x1024");
         	 //  caps.setCapability("app","sauce-storage:test.exe");
     //    	  caps.setCapability("prerun", WindowsExecutable.callExe());
         	    
         	  // test.loadInternetExplorerDesiredCaps();
         	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
          	//   caps.setCapability("executable","sauce-storage:test.exe");

      	  		driver.manage().window().maximize() ;
          	//   caps.setCapability("app","sauce-storage:test.exe");

      	  		driver.get(url);
      	  	 	   
      	  		return driver; 
      	  	  }
    	  
    }
    
    	
    	
    
    
   
    


   

    	
}