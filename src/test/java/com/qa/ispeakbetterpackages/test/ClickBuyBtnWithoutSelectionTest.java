package com.qa.ispeakbetterpackages.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetterpackages.base.BasePage;
import com.qa.ispeakbetterpackages.pages.ClickBuyBtnWithoutSelection;
import com.qa.ispeakbetterpackages.util.Constants;

public class ClickBuyBtnWithoutSelectionTest {
	
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	ClickBuyBtnWithoutSelection cSelection;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		cSelection = new ClickBuyBtnWithoutSelection(driver);
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = cSelection.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "verify duration warning text", enabled = true)
	public void clickBuyWithoutDuration() {
		String text = cSelection.buyWithoutDuration();
		Assert.assertEquals(text, Constants.Duration_Warning);
	}
	
	@Test(priority = 3, description = "verify class length warning text", enabled = true)
	public void clickBuyWithoutClassLength() {
		String text = cSelection.buyWithoutClassLength();
		Assert.assertEquals(text, Constants.Class_Length_Warning);
	}
	
	@Test(priority = 4, description = "verify class number warning text", enabled = true)
	public void clickBuyWithoutNumberOfClasses() {
		String text = cSelection.buyWithoutNumberOfClass();
		Assert.assertEquals(text, Constants.Class_Number_Warning);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
