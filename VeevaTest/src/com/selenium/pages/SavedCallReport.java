package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavedCallReport {
	WebDriver driver;
	Properties selector;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public SavedCallReport(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	public String getAccountName() {
		return driver.findElement(By.cssSelector(selector.getProperty("account_name"))).getText();
	}

	/**
	 * Returns the title of the current section
	 * 
	 * @return the title of the current section
	 */
	public String getPageTitle() {
		return driver.findElement(By.cssSelector(selector.getProperty("form_title"))).getText();
	}

	/**
	 * Returns the status of the call report
	 * 
	 * @return the status of the call report
	 */
	public String getStatus() {
		return driver.findElement(By.name(selector.getProperty("report_status"))).getText();
	}
}
