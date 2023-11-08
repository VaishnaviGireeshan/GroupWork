package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class EditAccountPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/edit";

	public EditAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By firstNameInput = By.id("input-firstname");
	private static By lastNameInput = By.id("input-lastNameInput");
	private static By emailInput = By.id("input-email");
	private static By telephoneInput = By.id("input-telephone");
	private static By continueBtn = By.cssSelector("input[value='Continue']");

	public void enterFirstName(String firstName) {
		((ProxyDriver) wd).sendKeys(firstNameInput, firstName);
	}

	public void enterLastName(String lasttName) {
		((ProxyDriver) wd).sendKeys(lastNameInput, lasttName);
	}

	public void enterNewEmail(String newEmail) {
		((ProxyDriver) wd).sendKeys(emailInput, newEmail);
	}

	public void enterTelephone(String phoneNumber) {
		((ProxyDriver) wd).sendKeys(telephoneInput, phoneNumber);
	}

	public AccountPage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		// return null;

		return new AccountPage(wd, true);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageURL() {
		return getDomain() + PAGE_URL;
	}

}
