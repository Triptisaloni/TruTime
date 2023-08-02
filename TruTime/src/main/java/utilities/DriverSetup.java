package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


//Class to setup drivers for Edge, Chrome
public class DriverSetup {
	private static WebDriver driver;
	public static String exePath;

	// Method to setup driver as per given choice
	public static WebDriver setupDriver(String choice) {

		if (choice.equalsIgnoreCase("Chrome")) {

			ChromeOptions co = new ChromeOptions();

			
			co.addArguments("--remote-allow-origins=*");
			// To start the browser in maximized window
			co.addArguments("start-maximized");

			// To disable the notifications
			co.addArguments("--disable-notifications");
			
			

			// Creating WebDriver class for the Chrome browser

			driver = new ChromeDriver(co);
			driver.manage().deleteAllCookies();
		}
		else {

			EdgeOptions eo = new EdgeOptions();

			
			eo.addArguments("--remote-allow-origins=*");
			
			// To maximize the browser window
			eo.addArguments("start-maximized");

			// To disable the notifications
			eo.addArguments("--disable-notifications");

			// Creating WebDriver class for the Edge browser

			driver = new EdgeDriver(eo);
		}

		return driver;
	}

}
