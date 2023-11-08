package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class NewsLetterSubscriptionPage extends Page {
	private static final String PAGE_URL = "/opencart/index.php?route=account/newsletter";

	public NewsLetterSubscriptionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By newsLetterSubsriptionPageText = By.cssSelector("#content>h1");
	private static By newsLetterSubsriptionYesOption = By.cssSelector("label.radio-inline:first-of-type>input");
	private static By newsLetterSubscriptionSubmitBtn = By.cssSelector("input[value='Continue']");

	public String getNewsLetterSubsriptionPageText() {
		return ((ProxyDriver) wd).getText(newsLetterSubsriptionPageText);

	}

	public void clickYesOption() {
		((ProxyDriver) wd).click(newsLetterSubsriptionYesOption);

	}

	public AccountPage clickNewsLetterSubscriptionSubmitBtn() {
		((ProxyDriver) wd).click(newsLetterSubscriptionSubmitBtn);
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
