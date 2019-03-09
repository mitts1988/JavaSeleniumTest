package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By userNameField = By.id("username");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(userNameField).sendKeys(strUserName);
	}
}
