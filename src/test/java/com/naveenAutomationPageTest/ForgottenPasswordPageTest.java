package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class ForgottenPasswordPageTest extends TestBase {

	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage(wd, false).get();
	}

	
	@Test
	public void validateUserWillGetConfirmationLinkUsingValidEmail() {
		// Click on the "Forgotten Password" link on the login page
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();

		// Verify if the page banner text matches
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageBannerText(), "Forgot Your Password?",
				"Forgotten Password PageBanner text doesn't match!!!");
		forgottenPasswordPage.enterEmail("TonyStark@gmail.com");

		forgottenPasswordPage.clickContinueBtn();

		// Verify if the warning message matches the expected message
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageSuccessMessage(),
				"An email with a confirmation link has been sent your email address.",
				"User will not get confirmation link with valid email address!!!");

	}

	@Test
	public void validateUserWillNotGetConfirmationLinkUsingInvalidEmail() {
		// Click on the "Forgotten Password" link on the login page
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();

		// Verify if the page banner text matches
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageBannerText(), "Forgot Your Password?",
				"Forgotten Password PageBanner text doesn't match!!!");

		// Verify if the page banner text matches "Forgot Your Password?"
		forgottenPasswordPage.enterEmail("Tonyds@gmail.com");

		forgottenPasswordPage.clickContinueBtn();

		// Verify if the warning message matches the expected message
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageWarningMessage(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"User is able to get confirmation link with invalid email address");

	}
}
