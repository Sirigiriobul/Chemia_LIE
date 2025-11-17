package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddCalibration  extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddCalibration(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}
	
	public void setInstrumentCode(String equipmentCode) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[contains(@placeholder,'Search')]"), 10);
		eUtil.doSendKeys(element,equipmentCode);	
		Thread.sleep(2000);
		}
	
	public void clickInstrumentCode() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//tbody//tr//td//a[@id='navigateEditId']"), 10);
		js.doJsClick(element);		
		}

	public void clickCalibrationTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='calibTab']"), 10);
		js.doJsClick(element);		
	}
	
	public void clickAddButton() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='addSchemeId']"), 10);
		js.doJsClick(element);	
		Thread.sleep(2000);
		
		}
		
	public void selectCalibrationCategory() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='equipmentMaintenanceType']"), 10);
		js.doJsClick(element);	
		
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@aria-label='SCHEDULED']"), 10);
		js.doJsClick(element1);
		Thread.sleep(2000);
	}
	
	public void clickStartButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='save']"), 10);
		js.doJsClick(element);	
}
	public void clickEndButton() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@mattooltip='end']"), 10);
		js.doJsClick(element);	
		Thread.sleep(2000);
		
		
}
	public void selectEndTime(String text) throws InterruptedException {
		WebElement element =eUtil.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='endTime']//button"),5 );
		js.doJsClick(element);
		
		WebElement element1=eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+text+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"), 10);
		js.doJsClick(element1);
		Thread.sleep(1000);
	}
	
	public void selectNextDueDate(String text,String TodaysDate) throws InterruptedException {
		
		WebElement element =eUtil.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='nextDueDate']//button"),5 );
		js.doJsClick(element);
		Thread.sleep(2000);
		js.doJsClick(element);
		Thread.sleep(2000);
		js.doJsClick(element);
		
		int date = Integer.parseInt(TodaysDate);
		if(date>=29) {
			WebElement element3=eUtil.waitForElementClickable(By.xpath("//button[@aria-label='Next Month']"), 10);
			js.doJsClick(element3);
		}
		WebElement element4=eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='"+text+"' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"), 10);
		Thread.sleep(1000);
		js.doJsClick(element4);
		Thread.sleep(1000);
	}
	
	public void setRemarks(String remarks) throws InterruptedException {
		
		WebElement element1 =eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='nextDueDate']//input"),10 );
		eUtil.doSendKeys(element1, remarks+Keys.TAB);
		Thread.sleep(2000);
		
		WebElement element3= eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='remarks']"), 10);
		eUtil.doClick(element3);
		Thread.sleep(2000);
		eUtil.doSendKeys(element3, remarks);	
		
}


}
