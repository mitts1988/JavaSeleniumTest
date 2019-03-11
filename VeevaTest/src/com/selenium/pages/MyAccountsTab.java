package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountsTab {
	WebDriver driver;
	Properties selector;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public MyAccountsTab(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	/**
	 * clicks a name from the my accounts list
	 * 
	 * @param strName name of person on the list you wish to click
	 */
	public void clickName(String strName) {
		driver.switchTo().frame(selector.getProperty("my_accounts_iframe"));
		driver.findElement(By.xpath(selector.getProperty("my_accounts_name") + strName + "']")).click();
	}

	/**
	 * returns the title of current screen
	 * 
	 * @return the string of title of current screen
	 */
	public String getFormTitle() {
		return driver.findElement(By.cssSelector(selector.getProperty("form_title"))).getText();
	}
}