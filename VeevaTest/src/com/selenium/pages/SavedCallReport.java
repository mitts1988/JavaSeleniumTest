package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavedCallReport {
	WebDriver driver;
	Properties selectors;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public SavedCallReport(WebDriver driver, Properties selectors) {
		this.driver = driver;
		this.selectors = selectors;
	}

	public String getAccountName() {
		return driver.findElement(By.cssSelector(selectors.getProperty("account_name"))).getText();
	}

	/**
	 * Returns the title of the current section
	 * 
	 * @return the title of the current section
	 */
	public String getPageTitle() {
		return driver.findElement(By.cssSelector(selectors.getProperty("form_title"))).getText();
	}

	/**
	 * Returns the status of the call report
	 * 
	 * @return the status of the call report
	 */
	public String getStatus() {
		return driver.findElement(By.name(selectors.getProperty("report_status"))).getText();
	}
}
