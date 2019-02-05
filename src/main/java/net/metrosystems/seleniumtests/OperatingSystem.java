package net.metrosystems.seleniumtests;

public class OperatingSystem {
	public static String results(){
		String results = System.getProperty("os.name");			
	return results;
}

public static void proxymetro() {
	  System.setProperty("http.proxyHost", "proxy.metro.ro");
	  System.setProperty("https.proxyHost", "proxy.metro.ro");
	  System.setProperty("http.proxyPort", "3128");
	  System.setProperty("https.proxyPort", "3128");
}
}
