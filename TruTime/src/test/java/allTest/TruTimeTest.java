package allTest;

import java.text.ParseException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import baseClass.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.OneCognizantPage;
import pages.LoginPage;
import pages.TruTimePage;

//Step definitions class of the TruTime feature
public class TruTimeTest extends BaseClass {
	// Defining the variables of all Page Object Class required by the current test
	public static LoginPage loginPage = new LoginPage();
	public static HomePage homePage = new HomePage();
	public static TruTimePage trutimePage = new TruTimePage();
	public static OneCognizantPage onecPage = new OneCognizantPage();

	// Scenario 1: Step 1
	@Given("User is on the Login page")
	public void validateLoginPage() {
		loginPage.verifyPage();
	}

	// Scenario 2: Step 1
	@Then("User is redirected to Home page")
	@Given("User is on Home Page")
	public void verify() {
		homePage.verifyPage();
	}

	// Scenario 2: Step 2
	@When("User scrolls down")
	public void searchBar() {
		homePage.getUserdetails();
		homePage.scrollDown();
	}

	// Scenario 2: Step 3
	@And("Clicks on OneCognizant")
	public void enterTruTime() {
		homePage.clickOneCognizant();
	}

	// Scenario 3: Step 1
	@Then("User is redirected to OneCognizant webpage")
	@Given("User is on OneCognizant Page")
	public void verifyOneCognizant() {
		onecPage.verifyPage();
	}

	// Scenario 3: Step 2
	@When("User Enters Trutime in search bar")
	public void enterInSearch() {
		onecPage.searchTrutime();
	}

	// Scenario 3: Step 3
	@And("Clicks on Trutime result")
	public void clickTrutime() throws InterruptedException {
		onecPage.clickTrutime();
	}

	// Scenario 3: Step 4
	@Then("User is redirected to TruTime Page")
	// Scenario 4: Step 1
	@Given("User is on TruTime Page")
	public void Verify() {
		trutimePage.verifyPage();
	}

	// Scenario 4: Step 2
	@Then("The dates for the current week are correctly displayed")
	public void verifyAndDisplayCurentWeekDates() {
		trutimePage.displayedDates();
		trutimePage.verifyDisplayedDates();
	}

	// Scenario 4: Step 3
	@And("Today's date is selected")
	public void currentDate() {
		trutimePage.verifyPageCurrentDate();
	}

	// Scenario 4: Step 4
	@And("Verify Month and Year")
	public void verifyMonth() {
		trutimePage.verifyMonth();
	}

	// Scenario 4: Step 5
	@And("Find Topup Logic")
	public void topup() throws ParseException {
		trutimePage.topUpLogic();
	}

    //  Takes the Screenshot after every step
	@AfterStep
	public void tearDown(Scenario scenario) {

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		if (scenario.isFailed())

			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "");

		scenario.attach(screenshot, "image/png", "Screenshot");

	}

}
