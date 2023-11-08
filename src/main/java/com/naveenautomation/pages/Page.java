package com.naveenautomation.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page extends GeneralPage {
	private static final String URL = "https://naveenautomationlabs.com";

	public Page(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);//GP class
		if (waitForPageToLoad) {
			this.waitForPageToLoad();
		}
	}

	protected String getDomain() {
		return URL;
	}

	@Override
	protected String getPageURL() {
		return getDomain();
	}

	private void waitForPageToLoad() {
		this.isLoaded();// implemented in individual page classes
	}
}
