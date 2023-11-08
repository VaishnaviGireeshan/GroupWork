package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.proxydriver.ProxyDriver;

public class AddressBookPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/address";

	public AddressBookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By addressBookPageText = By.xpath("//h2[text()='Address Book Entries']");
	private static By newAddressBtn = By.xpath("//a[text()='New Address']");
	private static By inputFirstName = By.cssSelector("#input-firstname");
	private static By inputLastName = By.cssSelector("#input-lastname");
	private static By inputAddress = By.cssSelector("#input-address-1");
	private static By inputCity = By.cssSelector("#input-city");
	private static By inputPostcode = By.cssSelector("#input-postcode");
	private static By inputCountry = By.cssSelector("#input-country");
	private static By inputZone = By.cssSelector("#input-zone");
	private static By continueBtn = By.cssSelector("input[value='Continue']");
	private static By addressAddedSuccessMsg = By.xpath("//div[contains(@class, 'alert-success')]");
	private static By deleteDefaultAddressBtn = By.xpath("//a[text()='Delete']");
	private static By getDeleteAddessMessage = By.xpath("//a[text()='Delete']");
	private static By deleteDefaultAddressUnsuccessfullMessage = By
			.xpath("//div[text()=' Warning: You can not delete your default address!']");

	public String getaddressBookEntriesPageText() {
		return ((ProxyDriver) wd).getText(addressBookPageText);
	}

	public void clickAddNewAddress() {
		((ProxyDriver) wd).click(newAddressBtn);
	}

	public void enterFirstName(String firstName) {
		((ProxyDriver) wd).sendKeys(inputFirstName, firstName);
	}

	public void enterLastName(String lastName) {
		((ProxyDriver) wd).sendKeys(inputLastName, lastName);
	}

	public void enterAddress(String address) {
		((ProxyDriver) wd).sendKeys(inputAddress, address);

	}

	public void enterCity(String city) {
		((ProxyDriver) wd).sendKeys(inputCity, city);

	}

	public void enterPostcode(String postalCode) {
		((ProxyDriver) wd).sendKeys(inputPostcode, postalCode);
	}

	public void enterCountry(String visibleText) {
		WebElement countryDropdown = ((ProxyDriver) wd).waitForElementToBeVisible(inputCountry, 10);
		((ProxyDriver) wd).selectItemFromDropDown(countryDropdown, visibleText);
	}

	public void enterZone(String visibleText) {
		WebElement zoneDropdown = ((ProxyDriver) wd).waitForElementToBeVisible(inputZone, 10);
		((ProxyDriver) wd).selectItemFromDropDown(zoneDropdown, visibleText);
	}

	public void clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
	}

	public String getAddressAddedSuccessMsg() {
		return ((ProxyDriver) wd).getText(addressAddedSuccessMsg);
	}

	/*******************************************************/
	public void deleteDefaultAddress() {
		((ProxyDriver) wd).click(deleteDefaultAddressBtn);
		((ProxyDriver) wd).acceptAlert();

	}

	/*******************************************************/
	public String getDeleteAddressMessage() {
		return ((ProxyDriver) wd).getText(getDeleteAddessMessage);
	}

	public String getDeleteDefaultAddressUnsuccessfullMessage() {
		return ((ProxyDriver) wd).getText(deleteDefaultAddressUnsuccessfullMessage);

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