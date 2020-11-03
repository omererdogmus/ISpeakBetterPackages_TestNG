package com.qa.ispeakbetterpackages.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetterpackages.base.BasePage;
import com.qa.ispeakbetterpackages.pages.HandlingErrorMessagesPage;
import com.qa.ispeakbetterpackages.util.Constants;
import com.qa.ispeakbetterpackages.util.ElementUtil;

public class HandlingErrorMessagesPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	ElementUtil elementUtil;
	HandlingErrorMessagesPage hErrorMessagesPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		hErrorMessagesPage = new HandlingErrorMessagesPage(driver);
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = hErrorMessagesPage.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "verifying duration error message", enabled = true)
	public void selectDuration() {
		String text = hErrorMessagesPage.selectDuration();
		Assert.assertEquals(text, Constants.Class_Duration_Error_Text);
	}
	
	@Test(priority = 3, description = "verifying classes error message", enabled = true)
	public void selectClasses() {
		String text = hErrorMessagesPage.selectClasseLength();
		Assert.assertEquals(text, Constants.Package_Length_Error_Text);
	}
	
	@Test(priority = 4, description = "verifying week error message", enabled = true)
	public void selectWeek() {
		String text = hErrorMessagesPage.selectClassNumber();
		Assert.assertEquals(text, Constants.Class_Week_Error_Text);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
