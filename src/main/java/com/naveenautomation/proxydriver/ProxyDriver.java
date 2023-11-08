package com.naveenautomation.proxydriver;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProxyDriver implements WebDriver, JavascriptExecutor, TakesScreenshot {

	private WebDriver driver;

	public ProxyDriver(WebDriver driver) {
		super();
		this.driver = driver;
	}

	/*
	 * created a ProxyDriver and implemented WebDriver, JavascriptExecutor,
	 * TakesScreenshot and added unimplemented methods.In some places we just used
	 * the default behaviors
	 */
	/******************** WebDriver Methods ******************/
	@Override
	public void get(String url) {
		ProxyDriver.this.driver.get(url);
	}

	@Override
	public String getCurrentUrl() {

		return ProxyDriver.this.driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {

		return ProxyDriver.this.driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {

		return ProxyDriver.this.driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {

		return ProxyDriver.this.driver.findElement(by);
	}

	@Override
	public String getPageSource() {

		return ProxyDriver.this.driver.getPageSource();
	}

	@Override
	public void close() {
		ProxyDriver.this.driver.close();
	}

	@Override
	public void quit() {
		ProxyDriver.this.driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {

		return ProxyDriver.this.driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {

		return ProxyDriver.this.driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {

		return ProxyDriver.this.driver.switchTo();
	}

	@Override
	public Navigation navigate() {

		return new Navigation() {

			@Override
			public void to(URL url) {
				ProxyDriver.this.driver.navigate().to(url);
			}

			@Override
			public void to(String url) {
				ProxyDriver.this.driver.get(url);

			}

			@Override
			public void refresh() {
				ProxyDriver.this.driver.navigate().refresh();

			}

			@Override
			public void forward() {
				ProxyDriver.this.driver.navigate().forward();

			}

			@Override
			public void back() {
				ProxyDriver.this.driver.navigate().back();

			}
		};

	}

	@Override
	public Options manage() {

		return driver.manage();
	}

	/******************** JavascriptExecutor Methods ******************/
	@Override
	public Object executeScript(String script, Object... args) {

		return ((JavascriptExecutor) driver).executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {

		return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
	}

	/******************** TakesScreenshot Methods ******************/
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {

		return ((TakesScreenshot) driver).getScreenshotAs(target);
	}

	/******************** Explicit Methods ******************/

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBePresent(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementToBeSelectable(WebElement element, int timeOutInSeconds) {
		new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds))
				.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	/*************************************************/

	public void click(By by) {
		WebElement element = waitForElementToBeClickable(by, 10);
		element.click();
	}

	public void selectItemFromDropDown(WebElement element, String visibleText) {
		waitForElementToBeSelectable(element, 10);
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(visibleText);
		} catch (Exception e) {
			sc.selectByValue(visibleText);
		}
	}

	public void submit(By by) {
		WebElement element = waitForElementToBeClickable(by, 10);
		element.submit();
	}

	public void sendKeys(By by, String text) {
		WebElement element = waitForElementToBeVisible(by, 10);
		element.sendKeys(text);
	}

	public String getText(By by) {
		WebElement element = waitForElementToBeVisible(by, 10);
		return element.getText();
	}

	public boolean isDisplayed(By by) {
		WebElement element = waitForElementToBePresent(by, 10);
		return element.isDisplayed();
	}

	public boolean isEnabled(By by) {
		WebElement element = waitForElementToBeVisible(by, 10);
		return element.isEnabled();
	}

	public void acceptAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public void click(WebElement element) {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).click();

	}
}
