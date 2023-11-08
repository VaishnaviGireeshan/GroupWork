package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class ChangePasswordPage extends Page {
	private static final String PAGE_URL = "/opencart/index.php?route=account/password";

	public ChangePasswordPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	// Locate and map web elements in the HTML page to corresponding WebElement
	// fields in the class.

	private static By passwordInput = By.id("input-password");
	private static By confirmPasswordInput = By.id("input-confirm");
	private static By changePwSubmitBtn = By.cssSelector("input[type='submit']");

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		((ProxyDriver) wd).sendKeys(confirmPasswordInput, confirmPassword);
	}

	public AccountPage clickPwContinueBtn() {
		((ProxyDriver) wd).click(changePwSubmitBtn);
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
