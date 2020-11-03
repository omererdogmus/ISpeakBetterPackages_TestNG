package com.qa.ispeakbetterpackages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetterpackages.util.ElementUtil;
import com.qa.ispeakbetterpackages.util.JavaScriptUtil;

public class HandlingErrorMessagesPage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	// Constructor
	public HandlingErrorMessagesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// Locators
	By duration = By.id("class_duration");
	By durationErrorMsg = By.xpath("//i[contains(text(), 'Class Duration is required!')]");
	By packageLength = By.id("package_length");
	By packageErrorMsg = By.xpath("//i[contains(text(), 'Package Length is required!')]");
	By classes = By.id("per_week_class_number");
	By classesErrorMsg = By.xpath("//i[contains(text(), 'Class per Week is required!')]");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public String selectDuration() {
		elementUtil.doSelectByVisibleText(duration, "Select Duration");
		elementUtil.doWaitTextToBePresent(durationErrorMsg, "Class Duration is required!");
		String durationError = elementUtil.doGetText(durationErrorMsg);
		System.out.println(durationError);
		
		return durationError;
	}

	public String selectClasseLength() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "Select Package Length");
		elementUtil.doWaitTextToBePresent(packageErrorMsg, "Package Length is required!");
		String packageError = elementUtil.doGetText(packageErrorMsg);
		System.out.println(packageError);
		return packageError;
	}

	public String selectClassNumber() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "12 weeks");
		elementUtil.doSelectByVisibleText(classes, "Select Class");
		elementUtil.doWaitTextToBePresent(classesErrorMsg, "Class per Week is required!");
		String classError = elementUtil.doGetText(classesErrorMsg);
		System.out.println(classError);
		return classError;
	}

}
