package allTest;

import baseClass.BaseClass;
import io.cucumber.testng.CucumberOptions;


//Cucumber runner class to run the cucumber tests using TestNG
@CucumberOptions(features = {"src/test/resources/features"},
				glue = {"allTest"},
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"html:reports/cucumber-report.html"})
public class CucumberRunner extends BaseClass
{
	
}
