package com.qa.ispeakbetterpackages.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetterpackages.base.BasePage;
import com.qa.ispeakbetterpackages.pages.SelectingRandomPlans;
import com.qa.ispeakbetterpackages.util.Constants;
import com.qa.ispeakbetterpackages.util.ElementUtil;

public class SelectingRandomPlansTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	ElementUtil elementUtil;
	SelectingRandomPlans sRandomPlans;
	

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		sRandomPlans = new SelectingRandomPlans(driver);
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = sRandomPlans.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "verify section header", enabled = true)
	public void verifyPackageSectionHeader() {
		String header = sRandomPlans.getPageHeader();
		System.out.println("Section header is : " + header);
		Assert.assertEquals(header, Constants.Section_Header);
	}

	@Test(priority = 3, description = "selecting a classes and duration", enabled = true)
	public void selectAPackage() {
		String price = sRandomPlans.selecPackage();
		Assert.assertEquals(price, "$960");
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
