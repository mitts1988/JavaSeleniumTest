package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;
	Properties selector;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public AccountPage(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	/**
	 * clicks the "Record a Call" button
	 */
	public void clickRecordACall() {
		driver.findElement(By.cssSelector(selector.getProperty("record_a_call_button"))).click();
	}

	/**
	 * returns the title of the current screen
	 * 
	 * @return String of the title of the current screen
	 */
	public String getPageTitle() {
		return driver.findElement(By.cssSelector(selector.getProperty("form_title"))).getText();
	}
}
