package net.metrosystems.seleniumtests;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.Attachements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
public class File {
	static WebDriver driver;
	final static Logger logger = Logger.getLogger(File.class);
	public static String path_file = System.getProperty("user.home")+"/Desktop/";
	
	public static void createfile(String filename, String content) throws IOException {
		//Get the file reference
        
        Path path = Paths.get(path_file + filename);

		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write(content);
		}
	}
	 public File(WebDriver driver) {
		 this.driver = driver;
	 }
	public static void uploadfile(String filename) {
		logger.info("select file for upload");
		WebElement uploadElement = driver.findElement(By.cssSelector("input[type='file']"));
        uploadElement.sendKeys("C:\\Windows\\SysWOW64\\Macromed\\Flash\\"+filename);
       
        
	}
}
