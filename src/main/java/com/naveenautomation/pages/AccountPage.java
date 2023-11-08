package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class AccountPage extends Page {
	private static final String PAGE_URL = "/opencart/index.php?route=account/account";

	public AccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By myAccountText = By.cssSelector("#content>h2:first-of-type");
	private static By editAccountInfoSuccessMsg = By.cssSelector("div.alert-success");
	private static By changePasswordSuccessMsg = By.cssSelector("div.alert-success");
	private static By newsLetterSubscriptionSuccessMsg = By.cssSelector("div.alert-success");

	// Locate and map web elements in the HTML page to corresponding WebElement
	// fields in the class.
	// methods to interact with these elements

	public String getMyAccouuntText() {
		return ((ProxyDriver) wd).getText(myAccountText);
	}

	public String getEditAccountInfoSuccessMsg() {
		return ((ProxyDriver) wd).getText(editAccountInfoSuccessMsg);

	}

	public String getchangePasswordSuccessMsg() {
		return ((ProxyDriver) wd).getText(changePasswordSuccessMsg);
	}

	public String getnewsLetterSubscriptionSuccessMsg() {
		return ((ProxyDriver) wd).getText(newsLetterSubscriptionSuccessMsg);
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
