package com.naveenAutomationPageTest;

import org.testng.annotations.BeforeMethod;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;

public class RegisterAccountPage extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void launch() {
		initialise();
		loginPage = new LoginPage(wd, false).get();

	}

}
