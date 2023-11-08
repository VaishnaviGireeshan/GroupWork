package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ConsumerSideNavigationBar;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ReturnsPage;
import com.naveenautomation.pages.SideNavigationBar;

public class ViewProductReturnsPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ReturnsPage viewProductReturnsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage(wd, false).get();

	}

	@Test
	public void validateUserIsInViewProductReturnsPage() {
		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");
		viewProductReturnsPage =(ReturnsPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.RETURNS);
		Assert.assertEquals(viewProductReturnsPage.getViewProductReturnsPageText(), "Product Returns",
				"User is not in Product Returns Page");
		accountPage = viewProductReturnsPage.clickProductReturnsContinueBtn();
		Assert.assertEquals(accountPage.getMyAccouuntText(), "My Account", "User is not navigating to My Account page");
	}
}
