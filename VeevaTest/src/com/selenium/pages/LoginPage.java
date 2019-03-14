package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	Properties selectors;

	public LoginPage(WebDriver driver, Properties selectors) {
		this.driver = driver;
		this.selectors = selectors;
	}

	/**
	 * inputs user name into textbox
	 * 
	 * @param strUserName
	 */
	public void inputUserName(String strUserName) {
		driver.findElement(By.id(selectors.getProperty("username_textbox"))).sendKeys(strUserName);
	}

	/**
	 * inputs password into textbox
	 * 
	 * @param strPassword password to be entered into the textbox
	 */
	public void inputPassword(String strPassword) {
		driver.findElement(By.id(selectors.getProperty("password_textbox"))).sendKeys(strPassword);
	}

	/**
	 * clicks the login button
	 */
	public void clickLogin() {
		driver.findElement(By.id(selectors.getProperty("login_button"))).click();
	}

	public void loginToSalesforce(String strUserName, String strPassword) {
		this.inputUserName(strUserName);
		this.inputPassword(strPassword);
		this.clickLogin();
	}
}