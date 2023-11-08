package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class HomePage extends Page {
	private static final String PAGE_URL = "/opencart/index.php?route=common/home";
	public HomePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By homePageSlideShow = By.cssSelector("#slideshow0 > div");

	public boolean isSlideShowDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(homePageSlideShow);

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
