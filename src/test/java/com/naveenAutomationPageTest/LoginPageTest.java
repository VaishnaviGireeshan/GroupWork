package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ForgottenPasswordPage forgottenPasswordPage;
	EditAccountPage editAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		// Initialize the test by navigating to the login page
		loginPage = (LoginPage) new LoginPage(wd, false).get();
	}

	@Test

	public void validateUserCanLoginWithValidCredentials() {
		// Perform the login action
		accountPage =  (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");

		// Verify that the user is logged in successfully
		Assert.assertEquals(accountPage.getMyAccouuntText(), "My Account", "User is not logedin");
	}

	

	@Test
	public void getDtaFromExcelSheet() throws Exception {
		String fileName = "C:\\Users\\Vishnu\\Desktop\\Login Credentials.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		System.out.println("Row count is " + rowCount);
	}

	@Test
	public void validateUserCanNotLoginWithInValidCredentials() {
		loginPage = (LoginPage) loginPage.submitLogin("TonyStark@gmail.com", "Dany123@");

		// Verify that the user can not login
		Assert.assertEquals(loginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User is logedin");
	}

	@Test
	public void validateUserIsAbleToNavigateToForgottenPasswordPage() {
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();

		// Verify if the page banner text matches
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageBannerText(), "Forgot Your Password?",
				"User is not able to Navigate to Forgotten Password Page!!!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}

}
