package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class LoginPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

//Locate and map web elements in the HTML page to corresponding WebElement fields in the class. 
	private static By emailInput = By.id("input-email");
	private static By passwordInput = By.id("input-password");
	private static By loginBtn = By.cssSelector("input[type='Submit']");
	private static By alertBanner = By.cssSelector(".alert-danger");
	private static By forgottenPwLink = By.cssSelector("#column-right>div>a:nth-of-type(3)");

// methods to interact with these elements
	public void enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);

	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
	}

	public GeneralPage submitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		((ProxyDriver) wd).click(loginBtn);
		return this.waitForPageToLoad(AccountPage.class,LoginPage.class);
	}

	public String getAlertText() {
		return ((ProxyDriver) wd).getText(alertBanner);
	}

	public ForgottenPasswordPage clickForgottenPasswordPageLink() {
		((ProxyDriver) wd).click(forgottenPwLink);
		return new ForgottenPasswordPage(wd, true);
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


	@Override
	public LoginPage get() {
		return (LoginPage) super.get();
	}
}
