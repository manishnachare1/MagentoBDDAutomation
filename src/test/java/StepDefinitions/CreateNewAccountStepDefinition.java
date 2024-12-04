package StepDefinitions;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import Pages.CreateNewAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.Hooks;
import io.cucumber.datatable.DataTable;

public class CreateNewAccountStepDefinition {

	WebDriver driver = Hooks.driver;

	CreateNewAccountPage CreateNewAccountPage = new CreateNewAccountPage(driver);

	@Given("the user is on the {string} page")
	public void theUserIsOnThePage(String pageName) {
		if (pageName.equalsIgnoreCase("Create Account")) {
			if (driver == null) {
				throw new IllegalStateException("Driver is not initialized!");
			}
			driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		} else if (pageName.equalsIgnoreCase("Login")) {
			if (driver == null) {
				throw new IllegalStateException("Driver is not initialized!");
			}
			driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
		}
	}

	@When("the user enters the following details to create an account:")
	public void theUserEntersTheFollowingDetailsToCreateAnAccount(DataTable dataTable) {
		Map<String, String> details = dataTable.asMap(String.class, String.class);

		CreateNewAccountPage.enterFirstName(details.get("First Name"));
		CreateNewAccountPage.enterLastName(details.get("Last Name"));
		CreateNewAccountPage.enterEmail(details.get("Email"));
		CreateNewAccountPage.enterPassword(details.get("Password"));
		CreateNewAccountPage.enterConfirmPassword(details.get("Confirm Password"));
	}

	@When("the user clicks on the {string} button")
	public void theUserClicksOnTheButton(String buttonName) {
		try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
		if (buttonName.equalsIgnoreCase("Create Account")) {
			CreateNewAccountPage.clickCreateAccountButton();
		}
	}

	@Then("the user should see a welcome message {string}")
	public void theUserShouldSeeAWelcomeMessage(String expectedMessage) {
		try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
		String actualMessage = CreateNewAccountPage.getSuccessMessage();
		assert actualMessage.equals(expectedMessage) : "Expected: " + expectedMessage + ", but got: " + actualMessage;
	}

	@When("the user enters {string} as the Email")
	public void theUserEntersAsTheEmail(String email) {
		try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
		CreateNewAccountPage.enterLoginEmail(email);
	}

	@When("the user enters {string} as the Password")
	public void theUserEntersAsThePassword(String password) {

		try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
		CreateNewAccountPage.enterLoginPassword(password);
		CreateNewAccountPage.clickLoginButton();
	}

	@Then("the user should see their account dashboard with the welcome message {string}")
	public void theUserShouldSeeTheirAccountDashboardWithTheWelcomeMessage(String expectedMessage) {
		String actualMessage = CreateNewAccountPage.getWelcomeMessage();		
		assert actualMessage.contains(expectedMessage) : "Expected: " + expectedMessage + ", but got: " + actualMessage;
	}

	@Then("the user should see an error message {string}")
	public void theUserShouldSeeAnErrorMessage(String expectedMessage) {
		String actualMessage = CreateNewAccountPage.getErrorMessage();
		assert actualMessage.equals(expectedMessage) : "Expected: " + expectedMessage + ", but got: " + actualMessage;
	}
}
