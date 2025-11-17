package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class RequestStock extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public RequestStock(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void clickStockRequestButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='stock-request']"), 10);
		js.doJsClick(element);
}
	public void selectMaterialType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='materialType']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}
	public void setCode(String allocateCode) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='invCode']"), 2);
		eUtil.doSendKeys(element,allocateCode);
	}
	public String getCode() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='invCode']"), 2);
		return js.doGetText(element);
	}
	
	public void setMaterialName(String materialName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='materialName']"), 2);
		eUtil.doSendKeys(element, materialName);
	}
	public void setTechGrade(String techGrade) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='techGrade']"), 5);
		eUtil.doSendKeys(element, techGrade);
	}
	
	public void selectRequiredQuantity(String requiredQuantity) throws InterruptedException {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='qtyRequired']"),10 );
		eUtil.doSendKeys(element, requiredQuantity);
		
		WebElement element1=eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='qtyUom']"), 10);
		js.doJsClick(element1);
		
		Thread.sleep(1000);
		WebElement element2=eUtil.waitForElementClickable(By.xpath("//li[@aria-label='Kg']"), 10);
		js.doJsClick(element2);
	}
	
	public void setLab(String lab) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='lab']"), 10);
		eUtil.doSendKeys(element, lab);
	}
	
	public void selectCriticality() throws InterruptedException {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='criticality']"),10 );
		js.doJsClick(element);
		Thread.sleep(1000);
		WebElement element1=eUtil.waitForElementClickable(By.xpath("//li[@aria-label='CRITICAL']"), 10);
		js.doJsClick(element1);
	}
	
	public void setBatchRemarks(String batchRemarks) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='remarks']"), 10);
		eUtil.doSendKeys(element, batchRemarks);
	}

	public void clickSubmit() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Submit']"), 10);
		js.doJsClick(element);
	}
}
