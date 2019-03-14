package com.selenium.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountsTab {
	WebDriver driver;
	Properties selectors;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public MyAccountsTab(WebDriver driver, Properties selectors) throws IOException {
		this.driver = driver;
		this.selectors = selectors;
	}

	/**
	 * clicks a name from the my accounts list
	 * 
	 * @param strName name of person on the list you wish to click
	 */
	public void clickName(String strName) {
		driver.switchTo().frame(selectors.getProperty("my_accounts_iframe"));
		String xpath = selectors.getProperty("my_accounts_name");
		xpath = new StringBuilder(xpath).insert(xpath.indexOf("'") + 1, strName).toString();
		driver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * returns the title of current screen
	 * 
	 * @return the string of title of current screen
	 */
	public String getFormTitle() {
		return driver.findElement(By.cssSelector(selectors.getProperty("form_title"))).getText();
	}
}