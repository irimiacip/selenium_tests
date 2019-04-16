package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptPopUP {
	static WebDriver driver;
	
	public void xxx(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('message')");
	}
	
}
