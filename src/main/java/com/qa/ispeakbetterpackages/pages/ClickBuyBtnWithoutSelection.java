package com.qa.ispeakbetterpackages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetterpackages.util.ElementUtil;
import com.qa.ispeakbetterpackages.util.JavaScriptUtil;

public class ClickBuyBtnWithoutSelection {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	// Constructor
	public ClickBuyBtnWithoutSelection(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// Locators
	By duration = By.id("class_duration");
	By durationWarningText = By.xpath("//p[contains(text(),'Duration field is required')]");
	By packageLength = By.id("package_length");
	By packageLengthWarningtext = By.xpath("//p[contains(text(),'Subscribed classes field is required')]");
	By classes = By.id("per_week_class_number");
	By classesWarningText = By.xpath("//p[contains(text(), 'Classes/week field is required')]");
	By program = By.id("course_program");
	By buyBtn = By.id("cmdPurchase");
	By warningTxt = By.xpath("//h2[contains(text(), 'Warning!')]");
	By okBtn = By.xpath("//button[contains(text(),'OK')]");
	

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public String buyWithoutDuration() {
		elementUtil.doSelectByVisibleText(duration, "Select Duration");
		elementUtil.doWaitElementToBeClickable(buyBtn);
		elementUtil.doClick(buyBtn);
		String warning = elementUtil.doGetText(warningTxt);
		String text = elementUtil.doGetText(durationWarningText);
		System.out.println(warning + text);
		elementUtil.doWaitElementToBeClickable(okBtn);
		elementUtil.doClick(okBtn);
		return warning + text;
	}
	
	public String buyWithoutClassLength() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "Select Package Length");
		elementUtil.doWaitElementToBeClickable(buyBtn);
		elementUtil.doClick(buyBtn);
		String warning = elementUtil.doGetText(warningTxt);
		String text = elementUtil.doGetText(packageLengthWarningtext);
		System.out.println(warning + text);
		elementUtil.doWaitElementToBeClickable(okBtn);
		elementUtil.doClick(okBtn);
		return warning + text;
	}
	
	public String buyWithoutNumberOfClass() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "12 weeks");
		elementUtil.doSelectByVisibleText(classes, "Select Class");
		elementUtil.doWaitElementToBeClickable(buyBtn);
		elementUtil.doClick(buyBtn);
		String warning = elementUtil.doGetText(warningTxt);
		String text = elementUtil.doGetText(classesWarningText);
		System.out.println(warning + text);
		elementUtil.doWaitElementToBeClickable(okBtn);
		elementUtil.doClick(okBtn);
		return warning + text;
	}
	
	
	
	
	
	
	
	
}
