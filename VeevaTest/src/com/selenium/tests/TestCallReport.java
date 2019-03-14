package com.selenium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.selenium.pages.AccountPage;
import com.selenium.pages.CallReportPage;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.MyAccountsTab;
import com.selenium.pages.SavedCallReport;

public class TestCallReport {
	WebDriver driver;
	LoginPage objLogin;
	HomePage objHome;
	MyAccountsTab objAccountsTab;
	AccountPage objAccount;
	CallReportPage objCallReport;
	SavedCallReport objSavedCallReport;
	Properties props;
	Properties selectors;

	@BeforeTest
	public void setup() throws IOException {
		// load properties
		props = new Properties();
		FileInputStream objTestFile = new FileInputStream(System.getProperty("user.dir") + "\\test.properties");
		props.load(objTestFile);
		selectors = new Properties();
		FileInputStream objSelectorsFile = new FileInputStream(
				System.getProperty("user.dir") + "\\selectors.properties");
		selectors.load(objSelectorsFile);

		// initialize webdriver
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(props.getProperty("url"));
		driver.manage().window().maximize();

		// initializes page objects
		objLogin = new LoginPage(driver, selectors);
		objHome = new HomePage(driver, selectors);
		objAccountsTab = new MyAccountsTab(driver, selectors);
		objAccount = new AccountPage(driver, selectors);
		objCallReport = new CallReportPage(driver, selectors);
		objSavedCallReport = new SavedCallReport(driver, selectors);

		// 1. Log-in to application from a web browser
		objLogin.loginToSalesforce(props.getProperty("user_id"), props.getProperty("password"));
	}

	@Test
	public void recordACall() {
		// 2. Navigate to "My Accounts" using tab near top of home page.
		objHome.clickMyAccounts();
		// 3. Select "Adams, Bob" from the My Accounts list.
		objAccountsTab.clickName(props.getProperty("name_from_account_list"));
		// 4. Near the top of the Account page is a "Record A Call" button. Select this
		// button.
		objAccount.clickRecordACall();
		// 5. Validate the Call Report page is displayed.
		{
			String actualTitle = objAccountsTab.getFormTitle();
			Assert.assertEquals(actualTitle, "Call Report",
					"Not on Call Report page after clicking on a name from My Accounts list");
		}
		// 6. On Call Report page, select "Mass Add Promo Call" from the Record Type
		// drop down list.
		objCallReport.selectRecordType(props.getProperty("record_type"));
		// 7. On Call Report page, the script should select Cholecap and Labrinone in
		// Detail Priority section.
		String[] callDiscussionProducts = { props.getProperty("call_discussion_product_1"),
				props.getProperty("call_discussion_product_2") };
		for (String product : callDiscussionProducts) {
			objCallReport.selectDetailingPriorityOptions(product);
		}
		// 8. Under Call Discussions section, make sure a subsection appeared for both
		// Cholecap and Labrinone. Also make sure the "Product" fields are set to the
		// respective product (one should be set to Cholecap, the other should be set to
		// Labrinone).
		// 9. On the same Call Discussion section, make sure each section appears in
		// order the product was selected. If Labrinone was selected first, then
		// Labrinone should show up first (from top down) under Call Discussion section.
		List<String> products = objCallReport.getCallDiscussionProducts();
		for (int i = 0; i < products.size(); i++) {
			Assert.assertTrue(products.get(i).contains(callDiscussionProducts[i]));
		}
		// 10. In Samples and Promotional Items section, select "QNASL Co-Pay Card", and
		// change quantity to 2.
		objCallReport.selectSamplesAndPromotionalItems(props.getProperty("samples_and_promotional_items"),
				props.getProperty("samples_and_promotional_items_quantity"));
		// 11. Call report should be saved by clicking "Save" button with a check for
		// successful submission.
		objCallReport.saveCall();
		{
			String actualTitle = objSavedCallReport.getPageTitle();
			String expectedTitle = props.getProperty("record_type");
			Assert.assertEquals(actualTitle, expectedTitle,
					"Expected to be on a " + expectedTitle + " page, but on a " + actualTitle + " instead.");
			String actualName = objSavedCallReport.getAccountName();
			String expectedName = props.getProperty("name_from_account_list");
			Assert.assertEquals(actualName, expectedName,
					"Expected " + expectedName + " to be the account holder, but " + actualName + " is.");
			String actualStatus = objSavedCallReport.getStatus();
			String expectedStatus = props.getProperty("expected_call_report_status");
			Assert.assertEquals(actualStatus, expectedStatus,
					"Expected " + expectedStatus + " to be the report status, but " + actualStatus + " is.");
		}
		// return to home screen for next test
		objHome.clickHome();
	}

	@AfterTest
	public void teardown() {
		// 12. As final step, the script should logout (found on drop down menu in upper
		// right
		objHome.logout();
		driver.close();
	}
}
