package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class LogoutPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/logout";

	public LogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	private static By logoutMsg = By.cssSelector("#content>p");
	private static By logoutSubmitBtn = By.cssSelector("#content > div > div > a");

	public String getLogoutSafelyMsg() {
		return ((ProxyDriver) wd).getText(logoutMsg);
	}

	public HomePage clickContinueBtn() {
		((ProxyDriver) wd).click(logoutSubmitBtn);

		return new HomePage(wd, true);
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
