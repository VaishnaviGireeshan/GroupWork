package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ConsumerSideNavigationBar;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;
import com.naveenautomation.pages.SideNavigationBar;

public class LogoutPageTest extends TestBase {
	LogoutPage logoutPage;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		// Initialize the test by navigating to the login page
		loginPage = (LoginPage) new LoginPage(wd, false).get();
	}

	@Test
	public void validateUserCanLogoutsafely() {
		// login using valid credentials
		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");
		// Perform the logout action
		logoutPage = (LogoutPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.LOGOUT);
		// Verify that the user is logged out safely
		Assert.assertEquals(logoutPage.getLogoutSafelyMsg(),
				"You have been logged off your account. It is now safe to leave the computer.", "User can not logout");

		homePage = logoutPage.clickContinueBtn();

		// Verify that the user is navigated to homepage
		Assert.assertTrue(homePage.isSlideShowDisplayed(), "Logout Failed");
	}

}
