package pages;

import static org.testng.Assert.assertEquals;

import baseClass.BaseClass;

//Page class for the Login page of the website
public class LoginPage extends BaseClass 
{	
	//Method to verify the page title
	public void verifyPage() 
	{
		check = driver.getTitle();
		assertEquals(check, "Sign in to your account");
	}
}
