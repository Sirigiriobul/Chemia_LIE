package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AllocatingNewBatch extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AllocatingNewBatch(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}
	
	public void clickBatchRequest() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Batch request']"), 10);
		js.doJsClick(element);
		
		}
	
	public void clickActionButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//table/tbody/tr[1]//mat-icon[@mattooltip='Action']"), 10);
		js.doJsClick(element);
		}
	public void clickAllocate() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//span[text()='Allocate']"), 10);
		js.doJsClick(element);
	}
		
	public void selectDepartment() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//p-dropdown[@optionlabel='deptCode']"), 10);
		js.doJsClick(element);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//li[@aria-label='ARD']"), 10);
		js.doJsClick(element1);
	}
	
	public void selectUser(String user) throws InterruptedException {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//p-select[@optionlabel='userName']"), 10);
		js.doJsClick(element);
		Thread.sleep(1000);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@role='searchbox']"), 10);
		eUtil.doSendKeys(element1,user);
		Thread.sleep(2000);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[@aria-label='"+user+"']"), 10);
		js.doJsClick(element2);
	}
	
	public void setQuantity(String quantity) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@placeholder='Enter quantity']"), 10);
		eUtil.doSendKeys(element, quantity);
	}

	public void setRemarks(String remarks) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//textarea[@placeholder='Enter remarks']"), 10);
		eUtil.doSendKeys(element, remarks);
	}
	public void clickSaveButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//button[@id='save']"), 10);
		js.doJsClick(element);
	}
	
	}
