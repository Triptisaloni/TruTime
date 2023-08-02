package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.BaseClass;

//Page class for the Home page of the website
public class HomePage extends BaseClass {

	// Webpage elements of the current page used for running the test
	// User name Button
	@FindBy(id = "O365_HeaderRightRegion")
	WebElement userNameButton;
	
	//Current Account User Name
	@FindBy(id = "mectrl_currentAccount_primary")
	WebElement userNameandTitle;
	
	//One Cognizant Button
	@FindBy(xpath = "//*[@aria-label='OneCognizant. Image: OneCognizant. ']")
	WebElement onec_button;

	// Constructor to instantiate the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to fetch the Username and Job title of the user
	public void getUserdetails() {
		userNameButton.click();
		
		eWait.until(ExpectedConditions.visibilityOf(userNameandTitle));
		System.out.println(
				"_______________________________________________________________________________________________________");
		System.out.println(userNameandTitle.getText());
		System.out.println(
				"_______________________________________________________________________________________________________");
	}
	
	//Scroll Down the Page by executing JavaScript Executor
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.getElementsByClassName(\"a_a_beed2cf1 c_a_beed2cf1 e_a_beed2cf1\")[0].scrollBy(0, 500)");
	}
	//Click on OneCognizant Button
	public void clickOneCognizant() {
		onec_button.click();
		window_list = new ArrayList<String>(driver.getWindowHandles()); // Using Window handle to switch windows
		driver.switchTo().window(window_list.get(1));
	}

	// Method to verify the current page Title
	public void verifyPage() {
		eWait.until(ExpectedConditions.visibilityOf(userNameButton));
		check = driver.getTitle();
		assertEquals(check, "Be.Cognizant - Home");
	}
}
