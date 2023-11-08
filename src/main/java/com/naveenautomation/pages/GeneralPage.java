package com.naveenautomation.pages;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GeneralPage extends LoadableComponent<GeneralPage> {
	/* Represents any abstraction of something that can be loaded. */

	protected WebDriver wd;
	private static final int DEFAULT_TIME_FOR_PAGE_LOAD = 60;

	public GeneralPage(WebDriver wd, boolean waitForPageToLoad) {
		this.wd = wd;// initializing GeneralPage class WebDriver
		if (waitForPageToLoad) {
			this.waitForDocumentCompleteState();
		}
	}

	@Override
	protected void load() {
		String pageURL = getPageURL();
		wd.get(pageURL);
	}

	protected abstract String getPageURL();// used to retrieve the path URL of the page we are visiting

	@Override
	protected abstract void isLoaded();

//To ensure the page has completely loaded or not 
	public boolean waitForDocumentCompleteState() {
		return new WebDriverWait(wd, Duration.ofSeconds(DEFAULT_TIME_FOR_PAGE_LOAD))
				.until((ExpectedCondition<Boolean>) P -> {
					while (true) {
						String documentState = getDocumentReadyState();
						if (documentState.equals("complete")) {
							return true;
						}
					}
				});

	}

	public String getDocumentReadyState() {
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		return jse.executeScript("return document.readyState").toString();// document means web page
	}

	@Override
	public GeneralPage get() {
		return super.get();
	}

	protected boolean urlContains(String url) {
		try {
			String pageUrl = getPageURL();
			URL pageUrlObject = new URL(pageUrl);
			URL urlObject = new URL(url);
			String pageUrlHost = pageUrlObject.getHost();
			String urlHost = urlObject.getHost();
			if (pageUrlHost.equalsIgnoreCase(urlHost)) {
				String pageUrlExclHost = pageUrl.substring(pageUrl.indexOf(pageUrlHost) + pageUrlHost.length());
				String urlExclHost = url.substring(url.indexOf(urlHost) + urlHost.length());
				return urlExclHost.toLowerCase().contains(pageUrlExclHost.toLowerCase());
			}
		} catch (MalformedURLException e) {

		}
		return false;
	}

	@SafeVarargs
	public final GeneralPage waitForPageToLoad(final Class<? extends GeneralPage>... pagestoWaitFor) {

		return waitForPageToLoad(30, pagestoWaitFor);
	}

	@SafeVarargs // used when the method we are creating is of type final
	protected final GeneralPage waitForPageToLoad(int timeForLoad,
			final Class<? extends GeneralPage>... pagestoWaitFor) {

		return new WebDriverWait(wd, Duration.ofSeconds(timeForLoad)).until(new ExpectedCondition<GeneralPage>() {
			// ExpectedCondition is a functional interface in Selenium, we are expecting
			// pages
			@Override
			public GeneralPage apply(WebDriver input) {

				for (Class<? extends GeneralPage> page : pagestoWaitFor) {

					try {
						// creates a new object
						GeneralPage pg = page.getConstructor(WebDriver.class, Boolean.TYPE).newInstance(wd, true);
						return pg;// return the newly created object
					} catch (InstantiationException e) {

					} catch (IllegalAccessException e) {

					} catch (IllegalArgumentException e) {

					} catch (InvocationTargetException e) {

					} catch (NoSuchMethodException e) {

					} catch (SecurityException e) {

					}

				}
				return null;

			}
		});

	}

}
