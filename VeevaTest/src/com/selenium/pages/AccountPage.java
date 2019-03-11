package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;
	By recordACallButton = By.cssSelector("td[id=\"topButtonRow\"] input.btn[value=\"Record a Call\"]");
	By formTitle = By.cssSelector("div.bPageTitle.content h1");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRecordACall() {
		driver.findElement(recordACallButton).click();
	}

	public String getPageTitle() {
		return driver.findElement(formTitle).getText();
	}
}
