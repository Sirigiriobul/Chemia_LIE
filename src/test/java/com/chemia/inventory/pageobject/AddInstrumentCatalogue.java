package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddInstrumentCatalogue extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddInstrumentCatalogue(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);

	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//mat-icon[@id='add'])[2]"), 10);
		js.doJsClick(element);
	}

	public void selectInsType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='instrType']"), 10);
		js.scrollIntoView(element);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.doJsClick(element1);
	}

	public void setInstrumentCode(String instrumentCode) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='instrCode']"), 10);
		eUtil.doSendKeys(element, instrumentCode);
	}

	public void setInstrumentName(String instrumentName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='instrName']"), 10);
		eUtil.doSendKeys(element, instrumentName);
	}

	public void setManufacturer(String manufacturer) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='mfg']"), 10);
		eUtil.doSendKeys(element, manufacturer);
	}

	public void setModel(String model) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='model']"), 10);
		eUtil.doSendKeys(element, model);
	}

	public void setSerialNumber(String serialNumber) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='slNo']"), 10);
		eUtil.doSendKeys(element, serialNumber);
	}

	public void setLowerOperatingRange(String lowerRange, String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='lowerRange']"), 10);
		eUtil.doSendKeys(element, lowerRange);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("(//span[@role='combobox'])[3]"), 10);
		js.doJsClick(element1);

		WebElement element2 = eUtil
				.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element2);
		js.doJsClick(element2);
	}

	public void setUpperOperatingRange(String upperRange, String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='upperRange']"), 10);
		eUtil.doSendKeys(element, upperRange);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("(//span[@role='combobox'])[4]"), 10);
		js.doJsClick(element1);

		WebElement element2 = eUtil
				.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element2);
		js.doJsClick(element2);
	}

	public void setGrossCapacity(String grossCapacity, String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='grossCapacity']"), 10);
		eUtil.doSendKeys(element,grossCapacity);

		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//input[@formcontrolname='grossCapacity']/following::span[1]"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);

		WebElement element2 = eUtil
				.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element2);
		js.doJsClick(element2);
	}

	public void setCalibrationFrequency(String calibFrequency) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='calibFrequency']"), 10);
		eUtil.doSendKeys(element,calibFrequency);
	}

	public void checkHasColumn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//input[@type='checkbox'])[2]"), 10);
		js.doJsClick(element);
	}

	public void selectCalibrationType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='calibType']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.doJsClick(element1);
	}
	
	public void clickLastCalibrationDate(String LastCalibrationDate) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='lastCalibDate']//button") , 10);
		js.doJsClick(element);
		
		WebElement element2 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+LastCalibrationDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),5 );
		js.doJsClick(element2);
	}
	
	public void clickNextCalibrationDueDate(String nextCalibrationDueDate) throws InterruptedException {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='nextCalibDate']//button") , 10);
		js.doJsClick(element);
		Thread.sleep(2000);
		
		WebElement element1 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+nextCalibrationDueDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),5 );
		js.doJsClick(element1);
	}
	
	public void clickLastMainDate(String LastMainDate) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='lastMaintDate']//button") , 10);
		js.doJsClick(element);
		
		WebElement element2 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+LastMainDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),5 );
		js.doJsClick(element2);
	}
	
	public void clickMainDueDate(String MainDueDate) throws InterruptedException {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='nextMaintDate']//button") , 10);
		js.doJsClick(element);
		Thread.sleep(2000);
		
		WebElement element2 =eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+MainDueDate+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),5 );
		js.doJsClick(element2);
	}
	
	public void setDescription(String description) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='desc']"), 10);
		eUtil.doSendKeys(element, description);
	}
	
	public void clickCancelButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='cancel']"), 10);
		js.doJsClick(element);
	}
	
	public void clickSubmitButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Submit']"), 10);
		js.doJsClick(element);
	}
	
	public void clickEquipmentInstrumentTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='instrTab']"), 10);
		js.doJsClick(element);
	}
	
	public void clickEquipmentInstrumentAddButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[@class='mdc-button__label']"), 10);
		js.doJsClick(element);
	}
	
	public void clickConfirmButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='verifyEquip']"), 10);
		js.doJsClick(element);
	}
	
	
	public void clickEquipmentInstrumentSaveButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Save']"), 10);
		js.doJsClick(element);
	}
	
	
	public void clickInstrumentLogTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='instrLog']"), 10);
		js.doJsClick(element);
		
	}
	
	

}
