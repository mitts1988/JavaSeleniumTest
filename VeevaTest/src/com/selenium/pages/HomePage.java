package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	Properties selector;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	/**
	 * Clicks the "My Accounts" button
	 */
	public void clickMyAccounts() {
		driver.findElement(By.linkText(selector.getProperty("my_account"))).click();
	}

	/**
	 * clicks the user menu in the top right
	 */
	public void clickUserMenu() {
		driver.findElement(By.id(selector.getProperty("user_menu"))).click();
	}

	/**
	 * clicks the "Home" button
	 */
	public void clickHome() {
		driver.findElement(By.xpath(selector.getProperty("home_button"))).click();
	}

	/**
	 * uses the user menu and logs out
	 */
	public void logout() {
		this.clickUserMenu();
		driver.findElement(By.cssSelector(selector.getProperty("logout_button"))).click();
	}
}
