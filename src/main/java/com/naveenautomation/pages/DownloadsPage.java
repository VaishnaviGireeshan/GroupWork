package com.naveenautomation.pages;

import org.openqa.selenium.WebDriver;

public class DownloadsPage extends Page{
	private static final String PAGE_URL = "/opencart/index.php?route=account/download";
	public DownloadsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
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
