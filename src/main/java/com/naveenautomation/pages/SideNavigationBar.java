package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.proxydriver.ProxyDriver;

public class SideNavigationBar extends Page {

	public SideNavigationBar(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	@Override
	protected void isLoaded() {
	}

	public Page OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar item) {//passing enum as input argument
		List<WebElement> sideBarItems = wd.findElements(By.cssSelector("div.list-group a"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getItem())) {
				//trim() removing starting and trailing empty spaces
				((ProxyDriver) wd).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}

}
