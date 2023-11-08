package com.naveenAutomationPageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorExample {
	WebDriver wd;
	JavascriptExecutor jse;
	/*
	 * Indicates that a driver can execute JavaScript, providing access to the
	 * mechanism to do so.
	 */
	RemoteWebDriver rmd;//RemoteWebDriver implements WebDriver, JavascriptExecutor

	@BeforeMethod
	public void setUp() {
		wd = WebDriverManager.chromedriver().create();

		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		wd.manage().window().maximize();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Instantiate the java script object
		jse = (JavascriptExecutor) wd;
	}

	@Test
	public void sendKeysUsingJavaScriptExecutor() {
		jse.executeScript("arguments[0].value='zenduo@email.com';", wd.findElement(By.id("input-email")));
	}

	@Test
	public void clickUsingJavaScriptExecutor() {
		jse.executeScript("arguments[0].value='TonyStark@gmail.com';", wd.findElement(By.id("input-email")));
		jse.executeScript("arguments[0].value='Tony12345';", wd.findElement(By.id("input-password")));
		jse.executeScript("arguments[0].click();", wd.findElement(By.cssSelector("input[type='submit']")));
	}

	@Test
	public void scrollUsingJavaScriptExecutor() {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

}
