package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddressBookPage;
import com.naveenautomation.pages.ConsumerSideNavigationBar;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.SideNavigationBar;

public class AddressBookEntriesPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	AddressBookPage addressBookEntriesPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage(wd, false).get();
	}

	@Test

	public void validateUserCanNavigateToAddressBook() {

		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");
		addressBookEntriesPage = (AddressBookPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.ADDRESS_BOOK);
		Assert.assertEquals(addressBookEntriesPage.getaddressBookEntriesPageText(), "Address Book Entries",

				"Navigation to address book page failed!!!");

	}

	@Test

	public void validateUserCanDeleteAddress() {

		// Log in and navigate to the Product Returns page

		accountPage = (AccountPage) loginPage.submitLogin("TonyStark@gmail.com", "Tony12345");

		addressBookEntriesPage = (AddressBookPage) new SideNavigationBar(wd, false)
				.OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar.ADDRESS_BOOK);

		addressBookEntriesPage.deleteDefaultAddress();

		Assert.assertEquals(addressBookEntriesPage.getDeleteDefaultAddressUnsuccessfullMessage(),
				"Warning: You can not delete your default address!",

				"User is able to Delete default address!!!");

	}

}
