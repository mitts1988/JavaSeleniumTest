package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccountsTab {
	WebDriver driver;
	By userName = By.cssSelector("#userNavLabel");
	By myAccountsTab = By.linkText("My Accounts");
	By recordACallButton = By.cssSelector("td[id=\"topButtonRow\"] input.btn[value=\"Record a Call\"]");
	By formTitle = By.cssSelector("div.bPageTitle.content h1");
	By recordTypeMenu = By.id("RecordTypeId");

	public MyAccountsTab(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyAccounts() {
		driver.findElement(myAccountsTab).click();
	}

	public String myAccountsTabSelected() {
		WebElement myAccountsTab = driver.findElement(By.xpath("//a[text() = 'My Accounts']"));
		return myAccountsTab.getAttribute("title");
	}

	public void clickName(String strName) {
		driver.switchTo().frame("itarget");
		driver.findElement(By.xpath("//a[text()=\"" + strName + "\"]")).click();
	}

	public void clickRecordACall() {
		driver.findElement(recordACallButton).click();
	}

	public String getFormTitle() {
		return driver.findElement(formTitle).getText();
	}

	public void selectRecordType(String strRecordType) {
		WebElement recordType = driver.findElement(recordTypeMenu);
		recordType.click();
		Select dropDownMenu = new Select(recordType);
		dropDownMenu.selectByVisibleText(strRecordType);
	}

	public void selectDetailingPriorityOptions(String strOption) {
		driver.findElement(By.cssSelector("#vod_detailing input[name=\"" + strOption + "\"]")).click();
	}
}