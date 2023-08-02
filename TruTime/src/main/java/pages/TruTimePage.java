package pages;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.BaseClass;

//Page class for the TruTme page of the website
public class TruTimePage extends BaseClass {
	// Webpage elements of the current page used for running the test
	
	//Getting current Date
	@FindBy(xpath = "//*[contains(@class,'dayHeadr active')]")
	WebElement currentDate;
	//List Containg dates
	@FindBy(xpath = "//*[contains(@class,'dayHeadr')]")
	List<WebElement> listOfDates;
	@FindBy(id = "appFrame")
	WebElement iframe;
	@FindBy(linkText = "1C")
	WebElement menuOptions;
	@FindBy(xpath = "//*[@class='ui-datepicker-month']")
	WebElement month;
	@FindBy(xpath = "//*[@class='ui-datepicker-year']")
	WebElement year;
	@FindBy(xpath = "//*[contains(@class, 'topupavailablefromDate')]")
	WebElement topup;

	public TruTimePage() {
		PageFactory.initElements(driver, this);
	}

	// Variables defined to get the system time in the required format
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM");
	public static LocalDate now = LocalDate.now();

	// Variable declared to get the dates from the website
	List<String> dateList;

	// Constructor to instantiate the Page Object

	// Method to get the dispayed dates on the TruTime Page
	public void displayedDates() {

		eWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		eWait.until(ExpectedConditions.visibilityOfAllElements(listOfDates));
		dateList = listOfDates.stream().map(WebElement::getText).collect(toList());
		System.out.println(
				"_______________________________________________________________________________________________________");
		dateList.forEach(System.out::println);
		System.out.println(
				"_______________________________________________________________________________________________________");
	}

	// Method to check the displayed dates against the current system dates
	public void verifyDisplayedDates() {
		List<String> list = Arrays.asList(DayOfWeek.values()).stream().map(k -> dtf.format(now.with(k).minusDays(1)))
				.collect(toList());
		assertTrue(dateList.containsAll(list));

	}

	// Method to check the active date is of today
	public void verifyPageCurrentDate() {
		String presentPageDate = currentDate.getText();
		assertEquals(presentPageDate, dtf.format(now), "Current Date is different");

	}

	public void verifyMonth() {
		assertEquals(month.getText().toLowerCase(), LocalDate.now().getMonth().toString().toLowerCase());
		assertEquals(Integer.parseInt(year.getText()), LocalDate.now().getYear());	
	}
	
	public void topUpLogic() throws ParseException {
		
		SimpleDateFormat dateParser = new SimpleDateFormat("E, dd MMM");
	
		Date displayedDate =  dateParser.parse(topup.getText());
		
		Date systemDate = dateParser.parse(dtf.format(LocalDate.now()));
		System.out.println(
				"_______________________________________________________________________________________________________");
		
        System.out.println("Topup Logic :" + (systemDate.getTime()-displayedDate.getTime())/((1000*60*60*24))%365+ " Days");
        System.out.println(
				"_______________________________________________________________________________________________________");
		
        
	}

	// Method to verify the page title
	public void verifyPage() {
		eWait.until(ExpectedConditions.visibilityOf(menuOptions));
		check = driver.getTitle();
		assertEquals(check, "OneCognizant");
	}

}
