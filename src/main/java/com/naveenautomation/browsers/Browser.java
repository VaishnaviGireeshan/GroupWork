package com.naveenautomation.browsers;

public enum Browser {
	CHROME("Chrome"), 
	EDGE("Edge"), 
	FIREFOX("FireFox"), 
	SAFARI("Safari");

	public String browser;

	private Browser(String browser) {
		this.browser = browser;

	}
}
