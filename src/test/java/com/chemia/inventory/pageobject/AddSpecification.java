package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddSpecification extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddSpecification(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void clickSpecificationTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='specsTab']"), 10);
		js.doJsClick(element);
	}

	public void clickAddButton() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//mat-icon[@id='addSchemeId']"), 5);
		js.doJsClick(element);
	}
	
	public void setSpecificationName(String specificationName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='specName']"), 5);
eUtil.doSendKeys(element, specificationName);


	}
	public void setSpecificationValue(String specificationName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='specVal']"), 5);
eUtil.doSendKeys(element, specificationName);
	}
	
	public void clickSpecificationUnit() throws InterruptedException {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//div[@aria-label='dropdown trigger']"), 5);
		js.doJsClick(element);
		Thread.sleep(2000);
		
		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//li[@aria-label='gm']"), 5);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
		
	}
	
	public void clickSaveButton() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//button[@id='save']"), 5);
		js.doJsClick(element);
	}
	

}
