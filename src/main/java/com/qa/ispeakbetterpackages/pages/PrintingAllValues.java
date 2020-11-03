package com.qa.ispeakbetterpackages.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.ispeakbetterpackages.util.ElementUtil;
import com.qa.ispeakbetterpackages.util.JavaScriptUtil;

public class PrintingAllValues {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	WebElement element;
	Select select;

	// Constructor
	public PrintingAllValues(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// Locators
	By duration = By.id("class_duration");
	By packageLength = By.id("package_length");
	By classes = By.id("per_week_class_number");
	By program = By.id("course_program");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public int printValuesDuration() {
		element = driver.findElement(duration);
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println("List size : " + list.size());
		System.out.println("");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		return list.size();
	}
	
	public int printValuesWeek() {
		element = driver.findElement(packageLength);
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println("List size : " + list.size());
		System.out.println("");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		return list.size();
	}
	
	public int printValuesClass() {
		element = driver.findElement(classes);
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println("List size : " + list.size());
		System.out.println("");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		return list.size();
	}
	
	public int printValuesProgram() {
		element = driver.findElement(program);
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println("List size : " + list.size());
		System.out.println("");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		return list.size();
	}

}
