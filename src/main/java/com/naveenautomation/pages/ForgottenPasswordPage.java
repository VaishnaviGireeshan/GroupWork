package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class ForgottenPasswordPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/forgotten";

	public ForgottenPasswordPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By forgottenPwBannerText = By.cssSelector("#content>h1");
	private static By emailInput = By.id("input-email");
	private static By continueBtn = By.cssSelector("input[value='Continue']");
	private static By warningMsg = By.cssSelector("div.alert-danger");
	private static By SuccessMsg = By.cssSelector("div.alert-success");

	public void enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);
	}

	public String getForgottenPasswordPageBannerText() {

		return ((ProxyDriver) wd).getText(forgottenPwBannerText);

	}

	public LoginPage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new LoginPage(wd, false);
	}

	public String getForgottenPasswordPageWarningMessage() {
		return ((ProxyDriver) wd).getText(warningMsg);

	}

	public String getForgottenPasswordPageSuccessMessage() {
		return ((ProxyDriver) wd).getText(SuccessMsg);

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
