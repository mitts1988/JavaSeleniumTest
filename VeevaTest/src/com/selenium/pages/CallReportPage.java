package com.selenium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CallReportPage {
	WebDriver driver;
	Properties selector;

	/**
	 * Class constructor specifying the WebDriver
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public CallReportPage(WebDriver driver) throws IOException {
		this.driver = driver;
		// load properties
		selector = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\selector.properties");
		selector.load(objfile);
	}

	/**
	 * Chooses an option in the "Record Type" drop down menu
	 * 
	 * @param strRecordType the name of the record type to be chosen from the menu
	 */
	public void selectRecordType(String strRecordType) {
		WebElement recordType = driver.findElement(By.id(selector.getProperty("record_type_id")));
		recordType.click();
		Select dropDownMenu = new Select(recordType);
		dropDownMenu.selectByVisibleText(strRecordType);
	}

	/**
	 * Selects options from the "Detailing Priority" section
	 * 
	 * @param strOption the name of the detailing priority to be chosen
	 */
	public void selectDetailingPriorityOptions(String strOption) {
		String xpath = selector.getProperty("detailing_priority_options");
		xpath = new StringBuilder(xpath).insert(xpath.indexOf("'") + 1, strOption).toString();
		System.out.println(xpath);
		driver.findElement(By.cssSelector(xpath)).click();
	}

	/**
	 * Returns a list of product names that are in the Call Discussion section
	 * 
	 * @return list of product names that are in the Call Discussion section
	 */
	public List<String> getCallDiscussionProducts() {
		List<WebElement> eles = driver.findElements(By.xpath(selector.getProperty("call_discussion_products")));
		List<String> products = new ArrayList<String>();
		for (WebElement e : eles) {
			Select sel = new Select(e);
			String product = sel.getFirstSelectedOption().getText();
			products.add(product);
		}
		return products;
	}

	/**
	 * Selects items from the Samples and Promotional section and then updates the
	 * quantity
	 * 
	 * @param item     name of item to be selected from list
	 * @param quantity number of the selected item you want
	 */
	public void selectSamplesAndPromotionalItems(String item, String quantity) {
		// clicks the checkbox next to the item
		String xpath = selector.getProperty("samples_and_promotional_items");
		xpath = new StringBuilder(xpath).insert(xpath.indexOf("'") + 1, item).toString();
		driver.findElement(By.xpath(xpath)).click();
		// updates the quantity of the item in the new section below
		xpath = selector.getProperty("samples_and_promotional_items_quantity");
		xpath = new StringBuilder(xpath).insert(xpath.indexOf("'") + 1, item).toString();
		WebElement e = driver.findElement(By.xpath(xpath));
		e.clear();
		e.sendKeys(quantity);
	}

	/**
	 * clicks on the Save button from the bottom of the page
	 */
	public void saveCall() {
		driver.findElement(By.cssSelector(selector.getProperty("save_button"))).click();
	}
}
