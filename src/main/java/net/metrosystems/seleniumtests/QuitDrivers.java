package net.metrosystems.seleniumtests;

import java.io.IOException;

public class QuitDrivers {

	public static void quitDriver() throws IOException {
		 Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
	     Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
	}
	


}
