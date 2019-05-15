package net.metrosystems.seleniumtests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighlit {
	static WebDriver driver;
	
	public static void highLighterMethod(WebDriver driver, WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: powderblue; border: 10px solid red;');", element);
		 }
			
	}




	
			


