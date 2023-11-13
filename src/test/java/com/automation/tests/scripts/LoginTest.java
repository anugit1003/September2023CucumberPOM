package com.automation.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.home.HomePage;
import com.automation.pages.login.CheckYourEmailPage;
import com.automation.pages.login.ForgotPasswordPage;
import com.automation.pages.login.LoginPage;
import com.automation.tests.base.BaseTest;
import com.automation.tests.utilities.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends BaseTest {
	static Logger logger = LogManager.getLogger(LoginTest.class.getName());

	private LoginPage loginPage = null;
	private HomePage homePage = null;
	private ForgotPasswordPage forgotPasswordPage = null;
	private CheckYourEmailPage checkYourEmailPage = null;

	@Given("the user wants to operate the salesforce application")
	public void openSalesforceApp() {
		goToUrl(getProps().getProperty(Constants.SALESFORCE_URL));
		maximizeBrowser();
	}

	@When("user is on the {string}")
	public void createPage(String string) {
		logger.info("create page "+ string);
		if (string.equalsIgnoreCase("LoginPage")) {
			loginPage = new LoginPage(getDriver());
		} else if (string.equalsIgnoreCase("HomePage")) {
			homePage = new HomePage(getDriver());
		} else if (string.equalsIgnoreCase("ForgotPasswordPage")) {
			forgotPasswordPage = new ForgotPasswordPage(getDriver());
		} else if (string.equalsIgnoreCase("CheckYourEmailPage")) {
			checkYourEmailPage = new CheckYourEmailPage(getDriver());
		}
	}

	@When("user inputs the username as {string}")
	public void inputUserName(String string) throws Exception {
		loginPage.enterUserName(string);
		logger.info("Input username " + string);
	}

	@When("user inputs the password as {string}")
	public void inputPassword(String string) {
		logger.info("Input username " + string);
		loginPage.enterPassword(string);

	}

	@When("user clicks the login button")
	public void clickLoginButton() {
		logger.info("Click Login ");
		loginPage.clickLogin("login");
	}

	@Then("verify that we can see {string}")
	public void verifyTextOnHomePage(String string) {

		String actualUserNameLabel = homePage.getUserNameLabelText();
		Assert.assertEquals(actualUserNameLabel, "Anuradha Jackson");
		logger.info("Login successful");

	}

	@Then("verify error message {string}")
	public void verify_error_message(String string) {
		String errorMessage = loginPage.getErrorMessageLabelText1();
		Assert.assertEquals(errorMessage, string);
		logger.info("Login Unsuccessful");
	}

	@Then("verify error message for blank password {string}")
	public void verify_error_message_for_blank_password(String string) {
		String errorMessage = loginPage.getErrorMessageLabelText1();
		Assert.assertEquals(errorMessage, string);
		logger.info("Login Unsuccessful");
	}

	@When("user clicks the forgot password link")
	public void user_clicks_the_forgot_password_link() {
		loginPage.clickForgotPassword();
	}

	@Then("user verifies the text {string}")
	public void user_verifies_the_text(String string) {
		String text = forgotPasswordPage.getForgotPasswordText();
		Assert.assertEquals(text, string);
		logger.info("Verified forgot password text");
	}
	@When("user inputs the username on Forgot Password Page as {string}")
	public void user_inputs_the_username_on_forgot_password_page_as(String string) {
		forgotPasswordPage.enterUserName(string);
	}
	
	@When("user clicks the continue button")
	public void user_clicks_the_continue_button() {
		forgotPasswordPage.clickContinueButton();
	}
	
	@Then("user verifies the email page text {string}")
	public void user_verifies_the_emailpage_text(String string) {
		String text = checkYourEmailPage.getCheckYourEmailText();
		Assert.assertEquals(text, string);
		logger.info("Verified check your email text");
	}

	@When("user clicks the return to login button")
	public void user_clicks_the_return_to_login_button() {
		checkYourEmailPage.clickReturnToLoginButton();
	}

	@Before
	public void beforeScenario() {
		logger.info("initialize and launch browser");
		initializeProperties();
		launchBrowser(getProps().getProperty(Constants.BROWSER));
	}

	@After
	public void afterScenario() throws Exception {
		quitBrowser();
	}

}
