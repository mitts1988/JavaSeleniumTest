package com.veeva.selenium.jason;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchbrowser {

	public static WebDriver driver = null;
	private static final String USER_ID = "bb67@bb2.com", 
			PASSWORD = "bugb1234",
			URL = "https://login.salesforce.com/";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
		
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		driver.close();
	}

}
