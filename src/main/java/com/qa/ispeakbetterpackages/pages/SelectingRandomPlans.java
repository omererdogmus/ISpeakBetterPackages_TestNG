package com.qa.ispeakbetterpackages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetterpackages.util.ElementUtil;
import com.qa.ispeakbetterpackages.util.JavaScriptUtil;

public class SelectingRandomPlans {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	// Constructor
	public SelectingRandomPlans(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// Locators
	By header = By.xpath("//span[contains(text(),'Flexible Packages')]");
	By duration = By.id("class_duration");
	By packageLength = By.id("package_length");
	By classes = By.id("per_week_class_number");
	By program = By.id("course_program");
	By promoCode = By.id("promo_code");
	By currencySign = By.id("currencyHolder");
	By price = By.id("result-price");
	By lastMsg = By.xpath("//i[contains(text(),'This package entitles you to ')]");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageHeader() {
		elementUtil.doWaitTextToBePresent(header, "Flexible Packages");
		String headerText = elementUtil.doGetText(header);
		return headerText;
	}

	public String selecPackage() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "12 weeks");
		elementUtil.doSelectByVisibleText(classes, "5 Classes");
		elementUtil.doSelectByVisibleText(program, "TOEFL");
		elementUtil.doSendKeys(promoCode, "test123test");
		elementUtil.doWaitTextToBePresent(currencySign, "$");
		elementUtil.doWaitTextToBePresent(price, "960");
		String dollarSign = elementUtil.doGetText(currencySign);
		String resultPrice = elementUtil.doGetText(price);
		String lastText = elementUtil.doGetText(lastMsg);
		String totalPrice = dollarSign + resultPrice;
		System.out.println(totalPrice + "" + lastText);
		return totalPrice;
	}

}
