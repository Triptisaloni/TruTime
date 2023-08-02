package baseClass;

import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.excelreadwrite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.DriverSetup;
import utilities.PropertiesFileReader;

//BaseClass to read the info from properties file, to start the driver and open base url
//and to close the driver
public class BaseClass extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static InputStream configFile;
	public static PropertiesFileReader reader;
	public static String browser;
	public static String baseUrl;
	public static WebDriverWait eWait;
	public static String check;
	public static ArrayList<String> window_list;
	
	
	@BeforeSuite
	public void configuration() throws Exception
	{
		//Getting input from the properties file
		configFile = this.getClass().getResourceAsStream("/config.properties");
		reader = new PropertiesFileReader(configFile);
		browser = reader.getValue("browser");
		baseUrl = reader.getValue("baseUrl");
		excelreadwrite.readexcel();
		
		
		//Starting the browser
		driver = DriverSetup.setupDriver(browser);
		
		
		
		
		//Specifying the different waits to be used in the test automation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		eWait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		
		
		//Opens the Base URL before test suite starts
		driver.get(baseUrl);
	}
	
	

	//Closes the driver after test suite ends
	@AfterSuite
	public void closeDriver()
	{
		
		driver.quit();
	}
	
}
