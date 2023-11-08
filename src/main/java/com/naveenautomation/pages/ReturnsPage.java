package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class ReturnsPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/return";

	public ReturnsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By viewProductReturnsPageText = By.cssSelector("#content>h1");
	private static By productReturnsContinueBtn = By.xpath("//a[text()='Continue']");

	public String getViewProductReturnsPageText() {
		return ((ProxyDriver) wd).getText(viewProductReturnsPageText);

	}

	public AccountPage clickProductReturnsContinueBtn() {
		((ProxyDriver) wd).click(productReturnsContinueBtn);
		return new AccountPage(wd, false);
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
