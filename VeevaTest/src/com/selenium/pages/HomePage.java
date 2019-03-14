package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	Properties selectors;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public HomePage(WebDriver driver, Properties selectors) {
		this.driver = driver;
		this.selectors = selectors;
	}

	/**
	 * Clicks the "My Accounts" button
	 */
	public void clickMyAccounts() {
		driver.findElement(By.linkText(selectors.getProperty("my_account"))).click();
	}

	/**
	 * clicks the user menu in the top right
	 */
	public void clickUserMenu() {
		driver.findElement(By.id(selectors.getProperty("user_menu"))).click();
	}

	/**
	 * clicks the "Home" button
	 */
	public void clickHome() {
		driver.findElement(By.xpath(selectors.getProperty("home_button"))).click();
	}

	/**
	 * uses the user menu and logs out
	 */
	public void logout() {
		this.clickUserMenu();
		driver.findElement(By.cssSelector(selectors.getProperty("logout_button"))).click();
	}
}
