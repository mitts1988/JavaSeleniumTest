package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountsTab {
	WebDriver driver;
	By userName = By.cssSelector("#userNavLabel");
	By formTitle = By.cssSelector("div.bPageTitle.content h1");

	public MyAccountsTab(WebDriver driver) {
		this.driver = driver;
	}

	public void clickName(String strName) {
		driver.switchTo().frame("itarget");
		driver.findElement(By.xpath("//a[text()=\"" + strName + "\"]")).click();
	}

	public String getFormTitle() {
		return driver.findElement(formTitle).getText();
	}
}