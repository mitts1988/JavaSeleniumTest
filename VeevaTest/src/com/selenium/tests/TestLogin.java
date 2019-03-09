package com.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.pages.LoginPage;

import junit.framework.Test;

public class TestLogin {
	WebDriver driver;
	LoginPage objLogin;
	private static final String USER_ID = "bb67@bb2.com", 
			PASSWORD = "bugb1234",
			URL = "https://login.salesforce.com/";
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
		
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}
	
	
	public void testLoginPage() {
		
	}
}
