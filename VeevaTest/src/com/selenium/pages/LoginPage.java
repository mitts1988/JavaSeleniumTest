package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	Properties selector;

	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	/**
	 * inputs user name into textbox
	 * 
	 * @param strUserName
	 */
	public void inputUserName(String strUserName) {
		driver.findElement(By.id(selector.getProperty("username_textbox"))).sendKeys(strUserName);
	}

	// inputs password into textbox
	public void inputPassword(String strPassword) {
		driver.findElement(By.id(selector.getProperty("password_textbox"))).sendKeys(strPassword);
	}

	// clicks the login button
	public void clickLogin() {
		driver.findElement(By.id(selector.getProperty("login_button"))).click();
	}

	public void loginToSalesforce(String strUserName, String strPassword) {
		this.inputUserName(strUserName);
		this.inputPassword(strPassword);
		this.clickLogin();
	}
}