package com.qa.ispeakbetterpackages.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetterpackages.base.BasePage;
import com.qa.ispeakbetterpackages.pages.PrintingAllValues;
import com.qa.ispeakbetterpackages.util.Constants;
import com.qa.ispeakbetterpackages.util.ElementUtil;

public class PrintingAllValuesTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	ElementUtil elementUtil;
	PrintingAllValues pAllValues;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		pAllValues = new PrintingAllValues(driver);
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = pAllValues.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "verifying duration selection numbers and values", enabled = true)
	public void verifyDurationSelection() {
		int numberOfSelection = pAllValues.printValuesDuration();
		Assert.assertEquals(numberOfSelection, 3);
	}
	
	@Test(priority = 3, description = "verifying week selection numbers and values", enabled = true)
	public void verifyWeekSelection() {
		int numberOfSelection = pAllValues.printValuesWeek();
		Assert.assertEquals(numberOfSelection, 5);
	}
	
	@Test(priority = 4, description = "verifying classes selection numbers and values", enabled = true)
	public void verifyClassesSelection() {
		int numberOfSelection = pAllValues.printValuesClass();
		Assert.assertEquals(numberOfSelection, 6);
	}
	
	@Test(priority = 5, description = "verifying program selection numbers and values", enabled = true)
	public void verifyProgramSelection() {
		int numberOfSelection = pAllValues.printValuesProgram();
		Assert.assertEquals(numberOfSelection, 10);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
