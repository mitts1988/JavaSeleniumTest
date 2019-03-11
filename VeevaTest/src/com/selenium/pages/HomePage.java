package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	By myAccountsTab = By.linkText("My Accounts");
	By userMenu = By.id("userNavButton");
	By logout = By.cssSelector("a[title='Logout']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyAccounts() {
		driver.findElement(myAccountsTab).click();
	}

	public void clickUserMenu() {
		driver.findElement(userMenu).click();
	}

	public void logout() {
		this.clickUserMenu();
		driver.findElement(logout).click();
	}
}
