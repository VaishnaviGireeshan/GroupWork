package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ChangePasswordPage;
import com.naveenautomation.pages.ConsumerSideNavigationBar;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsLetterSubscriptionPage;
import com.naveenautomation.pages.SideNavigationBar;

public class AccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ChangePasswordPage changePasswordPage;
	EditAccountPage editAccountPage;
	NewsLetterSubscriptionPage newLetterSubscriptionPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage(wd, false).get();
	}

	@Test
	public void validateUserCanEditPersonalInfo() {
		// Login to the account
		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");

		// Click on the "Edit your account information" link
		editAccountPage = (EditAccountPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		// Enter a sample data
		editAccountPage.enterFirstName("T");

		accountPage = editAccountPage.clickContinueBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getEditAccountInfoSuccessMsg(),
				"Success: Your account has been successfully updated.", "Personal Information is not updated");
	}

	@Test
	public void validateUserCanChangePassword() {
		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");

		// Click on the "Change Password" link

		changePasswordPage = (ChangePasswordPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.PASSWORD);

		// Enter a new password and confirm it
		changePasswordPage.enterPassword("Tony12345");
		changePasswordPage.enterConfirmPassword("Tony12345");

		// Click the "Continue" button
		accountPage = changePasswordPage.clickPwContinueBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getchangePasswordSuccessMsg(),
				"Success: Your password has been successfully updated.", "Password Not  Changed");

	}

	@Test
	public void validateUserCanUpdateNewsLetterSubscription() {
		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");

		// Click on the "Subscribe to newsletter" link
		newLetterSubscriptionPage = (NewsLetterSubscriptionPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.NEWSLETTER);

		// Select the "Yes" option for newsletter subscription
		newLetterSubscriptionPage.clickYesOption();

		// Click the "Submit" button
		accountPage = newLetterSubscriptionPage.clickNewsLetterSubscriptionSubmitBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getnewsLetterSubscriptionSuccessMsg(),
				"Success: Your newsletter subscription has been successfully updated!",
				"News letter Subscription update is not done!!!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}

}
