package com.naveenautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.WebdriverEvents;
import com.naveenautomation.browsers.Browser;
import com.naveenautomation.environment.Environment;
import com.naveenautomation.proxydriver.ProxyDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd; // should remain same for the whole project
	private final Browser BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;
	private static final boolean RUN_ON_GRID = true;

	/**
	 * A wrapper around an arbitrary {@link WebDriver} instance which supports
	 * registering of a link WebDriverEventListener for logging purposes.
	 */


	
	@BeforeClass
	public void loggerSetup() {// one time setup
		logger = Logger.getLogger(TestBase.class);// initializing the logger
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);

	}

	public void initialise() {

		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://192.168.137.1:5555"), getOptions());
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		} else {

			switch (BROWSER) {
			case CHROME:
				// creates instance of webdriver
				wd = new ProxyDriver(WebDriverManager.chromedriver().create());

				break;
			case EDGE:
				wd = new ProxyDriver(WebDriverManager.edgedriver().create());
				break;
			case FIREFOX:
				wd = new ProxyDriver(WebDriverManager.firefoxdriver().create());
				break;

			default:
				throw new IllegalArgumentException();

			}
		}
		// Wrap the instance
		//e_driver = new EventFiringWebDriver(wd);

		// Events which need to be captured
		//events = new WebdriverEvents();
		//e_driver.register(events);

		// Assigning back the value to Web driver
		//wd = e_driver;

		// Loading the Page
		wd.get(URL.getUrl());
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.manage().deleteAllCookies();

	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(BROWSER);
	}

	@AfterMethod
	public void tearDown() {
		try {
			wd.quit();
		} finally {
			wd.quit();
		}
		
	}

}
