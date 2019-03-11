package com.selenium.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.selenium.pages.LoginPage;
import com.selenium.pages.MyAccountsTab;

//1. Log-in to application from a web browser (e.g. Internet Explorer, Firefox, Chrome, etc.).
//2. Navigate to "My Accounts" using tab near top of home page.
//3. Select "Adams, Bob" from the My Accounts list.
//4. Near the top of the Account page is a "Record A Call" button. Select this button.
//5. Validate the Call Report page is displayed.
//6. On Call Report page, select "Mass Add Promo Call" from the Record Type drop down list.
//7. On Call Report page, the script should select Cholecap and Labrinone in Detail Priority section.
//8. Under Call Discussions section, make sure a subsection appeared for both Cholecap and Labrinone. Also make sure the "Product" fields are set to the respective product (one should be set to Cholecap, the other should be set to Labrinone).
//9. On the same Call Discussion section, make sure each section appears in order the product was selected. If Labrinone was selected first, then Labrinone should show up first (from top down) under Call Discussion section.
//10. In Samples and Promotional Items section, select "QNASL Co-Pay Card", and change quantity to 2.
//11. Call report should be saved by clicking "Save" button with a check for successful submission. 
//12. As final step, the script should logout (found on drop down menu in upper right

public class TestCallReport {
	WebDriver driver;
	LoginPage objLogin;
	MyAccountsTab objAccountsTab;
	private static final String USER_ID = "bb67@bb2.com", PASSWORD = "bugb1234", URL = "https://login.salesforce.com/",
			NAME_FROM_LIST = "Adams, Bob", RECORD_TYPE = "Mass Add Promo Call";
	private static final String[] CALL_DISCUSSION_PRODUCTS = { "Cholecap", "Labrinone" };

	@BeforeTest
	public void setup() {
		// 1. Log-in to application from a web browser (e.g. Internet Explorer, Firefox,
		// Chrome, etc.).
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		objLogin = new LoginPage(driver);
		objLogin.loginToSalesforce(USER_ID, PASSWORD);
	}

	@Test
	public void recordACall() {
		// 2. Navigate to "My Accounts" using tab near top of home page.
		objAccountsTab = new MyAccountsTab(driver);
		objAccountsTab.clickMyAccounts();
		// 3. Select "Adams, Bob" from the My Accounts list.
		objAccountsTab.clickName(NAME_FROM_LIST);
		// 4. Near the top of the Account page is a "Record A Call" button. Select this
		// button.
		objAccountsTab.clickRecordACall();
		// 5. Validate the Call Report page is displayed.
		String actual = objAccountsTab.getFormTitle();
		Assert.assertEquals(actual, "Call Report");
		// 6. On Call Report page, select "Mass Add Promo Call" from the Record Type
		// drop down list.
		objAccountsTab.selectRecordType(RECORD_TYPE);
		// 7. On Call Report page, the script should select Cholecap and Labrinone in
		// Detail Priority section.
		for (String product : CALL_DISCUSSION_PRODUCTS) {
			objAccountsTab.selectDetailingPriorityOptions(product);
		}
		// 8. Under Call Discussions section, make sure a subsection appeared for both
		// Cholecap and Labrinone. Also make sure the "Product" fields are set to the
		// respective product (one should be set to Cholecap, the other should be set to
		// Labrinone).
		// 9. On the same Call Discussion section, make sure each section appears in
		// order the product was selected. If Labrinone was selected first, then
		// Labrinone should show up first (from top down) under Call Discussion section.
		List<String> products = objAccountsTab.getCallDiscussionProducts();
		for (int i = 0; i < products.size(); i++) {
			Assert.assertTrue(products.get(i).contains(CALL_DISCUSSION_PRODUCTS[i]));
		}
		// 10. In Samples and Promotional Items section, select "QNASL Co-Pay Card", and
		// change quantity to 2.
		
		// 11. Call report should be saved by clicking "Save" button with a check for
		// successful submission.
		// 12. As final step, the script should logout (found on drop down menu in upper
		// right
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
