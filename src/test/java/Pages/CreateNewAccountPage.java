package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewAccountPage {

	WebDriver driver;

	// Locators for "Create Account" page
	private By firstNameField = By.id("firstname");
	private By lastNameField = By.id("lastname");
	private By emailField = By.id("email_address");
	private By passwordField = By.id("password");
	private By confirmPasswordField = By.id("password-confirmation");
	private By createAccountButton = By.cssSelector("button[title='Create an Account']");
	private By successMessage= By.xpath("//div[@class='message-success success message']");

	// Locators for "Login" page
	private By loginEmailField = By.id("email");
	private By loginPasswordField = By.id("pass");
	private By signInButton = By.linkText("Sign In");
	private By loginButton = By.id("send2");
	private By welcomeMessage = By.xpath("//div[@class='panel header']//li[@class='greet welcome']");
	private By errorMessage = By.cssSelector("div.message-error div");

	// Constructor
	public CreateNewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions for "Create Account" page
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}

	public void clickCreateAccountButton() {
		driver.findElement(createAccountButton).click();
	}

	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}

	// Actions for "Login" page
	public void enterLoginEmail(String email) {
		driver.findElement(loginEmailField).sendKeys(email);
	}

	public void enterLoginPassword(String password) {
		driver.findElement(loginPasswordField).sendKeys(password);
	}

	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	public String getWelcomeMessage() {
		return driver.findElement(welcomeMessage).getText();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

}
