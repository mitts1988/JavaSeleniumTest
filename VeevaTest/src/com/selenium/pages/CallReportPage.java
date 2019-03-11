package com.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CallReportPage {
	WebDriver driver;
	By recordTypeMenu = By.id("RecordTypeId");
	By saveCallButton = By.cssSelector("td#bottomButtonRow input.btn[name='Save']");
	By formTitle = By.cssSelector("div.bPageTitle.content h1");

	public CallReportPage(WebDriver driver) {
		this.driver = driver;
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

	public List<String> getCallDiscussionProducts() {
		List<WebElement> eles = driver.findElements(By.xpath("//select[@ng-change='updateProduct(discussion)']"));
		List<String> products = new ArrayList<String>();
		for (WebElement e : eles) {
			Select sel = new Select(e);
			String product = sel.getFirstSelectedOption().getText();
			products.add(product);
		}
		return products;
	}

	public void selectSamplesAndPromotionalItems(String item, String quantity) {
		driver.findElement(By.xpath("//label[normalize-space(text())='" + item + "']")).click();
		WebElement e = driver.findElement(By.xpath("//span[normalize-space(text())='" + item
				+ "']/../../..//input[@ng-model='row.data.Quantity_vod__c']"));
		e.clear();
		e.sendKeys(quantity);
	}

	public void saveCall() {
		driver.findElement(saveCallButton).click();
	}

	public String getPageTitle() {
		return driver.findElement(formTitle).getText();
	}
}
