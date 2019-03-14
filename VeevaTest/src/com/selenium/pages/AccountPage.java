package com.selenium.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;
	Properties selectors;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public AccountPage(WebDriver driver, Properties selectors) throws IOException {
		this.driver = driver;
		this.selectors = selectors;
	}

	/**
	 * clicks the "Record a Call" button
	 */
	public void clickRecordACall() {
		driver.findElement(By.cssSelector(selectors.getProperty("record_a_call_button"))).click();
	}

	/**
	 * returns the title of the current screen
	 * 
	 * @return String of the title of the current screen
	 */
	public String getPageTitle() {
		return driver.findElement(By.cssSelector(selectors.getProperty("form_title"))).getText();
	}
}
