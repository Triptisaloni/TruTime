package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.BaseClass;
import utilities.excelreadwrite;

public class OneCognizantPage extends BaseClass {
	
	//Search Box on OneC Page
	@FindBy(id = "oneC_searchAutoComplete")
	WebElement searchBox;
	
	//Select Tru Time 
	@FindBy(xpath = "//*[@aria-label=\"TruTime \"]")
	WebElement truTime;
	
	//Constructor to instantiate the Page Object
	public OneCognizantPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Search for Tru Time in search Box
	public void searchTrutime() {
		searchBox.sendKeys(excelreadwrite.search_input);
	}
	
	//Click on TruTime in Sugestions
	public void clickTrutime() throws InterruptedException {
		Thread.sleep(2000);
		truTime.click();
	}
    //Verify the Page title
	public void verifyPage() {
		eWait.until(ExpectedConditions.visibilityOf(searchBox));
		check = driver.getTitle();
		assertEquals(check, "OneCognizant");
	}

}
