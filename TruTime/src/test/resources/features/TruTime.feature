Feature: TruTime


	Scenario: Login using correct Email ID and Password

		Given User is on the Login page
		Then User is redirected to Home page
  
	Scenario: Opening OneCognizant Page

		Given User is on Home Page
		When User scrolls down
		And Clicks on OneCognizant
		Then User is redirected to OneCognizant webpage
		
  Scenario: Searching and Opening TruTime Page
  
    Given User is on OneCognizant Page
    When User Enters Trutime in search bar
    And Clicks on Trutime result
    Then User is redirected to TruTime Page

	Scenario: Verification of displayed dates

		Given User is on TruTime Page
		Then The dates for the current week are correctly displayed
		And Today's date is selected
		And Verify Month and Year
		And Find Topup Logic