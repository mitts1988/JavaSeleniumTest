package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By userNameTextbox = By.id("username");
	By passwordTextbox = By.id("password");
	By loginButton = By.id("Login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// inputs user name into textbox
	public void inputUserName(String strUserName) {
		driver.findElement(userNameTextbox).sendKeys(strUserName);
	}

	// inputs password into textbox
	public void inputPassword(String strPassword) {
		driver.findElement(passwordTextbox).sendKeys(strPassword);
	}

	// clicks the login button
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void loginToSalesforce(String strUserName, String strPassword) {
		this.inputUserName(strUserName);
		this.inputPassword(strPassword);
		this.clickLogin();
	}
}