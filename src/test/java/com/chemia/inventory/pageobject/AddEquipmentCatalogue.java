package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddEquipmentCatalogue extends BasePage {
	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddEquipmentCatalogue(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);

	}

	public void clickMainMenu() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//a[@id='menuId' and normalize-space()='Equipment Catalogue']"), 10);
		eUtil.doClick(element);
	}

	public void clickEquipmentSubMenu() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//span[text()=' Equipment Catalogue '])[1]"), 10);
		eUtil.doClick(element);
	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//mat-icon[@id='add'])[1]"), 10);
		js.doJsClick(element);
	}

	public void selectEquipType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='equipType']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void setEquipmentCode(String EquipmentCode) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='equipCode']"), 10);
		eUtil.doSendKeys(element, EquipmentCode);
	}

	public void setEquipmentName(String equipmentName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='equipName']"), 10);
		eUtil.doSendKeys(element, equipmentName);
	}

	public void setManufacturer(String manufacturer) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='manufacturer']"), 10);
		eUtil.doSendKeys(element, manufacturer);
	}

	public void setModel(String model) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='model']"), 10);
		eUtil.doSendKeys(element, model);
	}

	public void setSerialNumber(String serialNumber) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='serialNo']"), 10);
		eUtil.doSendKeys(element, serialNumber);
	}

	public void setLocation(String location) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='location']"), 10);
		eUtil.doSendKeys(element, location);
	}

	public void setGrossCapacity(String grossCapacity) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='grossCapacity']"), 10);
		eUtil.doSendKeys(element, grossCapacity);
	}

	public void selectCapacityUnit(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='grossCapacity']/following::span[1]"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void selectMaintenanceType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='grossCapacity']/following::span[2]"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.doJsClick(element1);
	}

	public void setMainFrequency(String mainFrequency) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='mainFrequency'and @type='text']"), 10);
		eUtil.doSendKeys(element, mainFrequency);

	}
	
	public void setCriticalityLevel(String criticalityLevel) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='criticalityLevel']") , 10);
		js.doJsClick(element);
		
		WebElement element1=eUtil.waitForElementClickable(By.xpath("//li[@role='option' and @aria-label='HIGH' ]") , 10);
		js.doJsClick(element1);
	}
	public void clickLastMainDate(String LastMainDate) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='lastMainDate']//button") , 10);
		js.doJsClick(element);
		
		WebElement element2 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+LastMainDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),5 );
		js.doJsClick(element2);
	}
	
	public void clickMainDueDate(String MainDueDate) throws InterruptedException {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='mainDueDate']//button") , 10);
		js.doJsClick(element);
		Thread.sleep(2000);
		
		if(MainDueDate==("30") || MainDueDate==("31")) {
			WebElement element1 =eUtil.waitForElementPresence(By.xpath("//button[@aria-label='Next Month']"),10 );
			js.doJsClick(element1);
		}
		Thread.sleep(2000);
		
		WebElement element1 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+MainDueDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),10 );
		js.doJsClick(element1);
	}
	
	public void setDescription(String description) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//textarea[@formcontrolname='desc']") , 10);
		eUtil.doSendKeys(element,description);
	}
	
	public void clickSaveButton() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Save']") , 10);
		js.doJsClick(element);
	}
	
	public void clickSubmitButton() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Submit']") , 10);
		js.doJsClick(element);
	}
	
	public void clickSummaryTab() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//div[@id='summaryTab']") , 10);
		js.doJsClick(element);
	}
	
	
	
	
	public void clickLogtab() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//div[@id='equipLog']") , 10);
		js.doJsClick(element);
	}
	
	
	public void clickEquipmentLogGoButton() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//mat-icon[normalize-space()='east']") , 10);
		js.doJsClick(element);
	}
	
	public void clickFinalEquipmentSubmit() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("(//mat-icon[@id='addSchemeId'])[1]") , 10);
		js.doJsClick(element);
	}
	
	public void setAuthenticationDetails(String text) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//input[@name='password']") , 10);
		eUtil.doSendKeys(element, text);
	}
	
	public void clickFinalEquipmentConfirm() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//button[@id='verifyEquip']") , 10);
		js.doJsClick(element);
	}
	

	
}