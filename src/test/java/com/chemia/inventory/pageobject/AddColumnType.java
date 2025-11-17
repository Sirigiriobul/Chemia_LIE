package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddColumnType extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddColumnType(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}
	
	public void clickMainMenu() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//li[@class='nav-item dropdown ng-star-inserted'][1]"), 30);
		js.doJsClick(element);
	}

	public void clickEquipMasterData() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space(text())='Equip Master Data']"), 10);
		js.doJsClick(element);

	}
	public void clickColumnTypeMenu() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//a[@id='subMenuId']//span[@class='title'][normalize-space()='Column Type']"), 5);
		js.doJsClick(element);
	}
	
	public void clickAddButton() {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='add']"), 10);
		js.doJsClick(element);
	}
	
	public void setColumnName(String columnName) {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='colName']"), 10);
		eUtil.doSendKeys(element,columnName);
	}
	
	public void setDescription(String description) {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='colDesc']"), 10);
		eUtil.doSendKeys(element, description);
		}
	
	public void selectLength(String length) {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='length']"), 10);
		eUtil.doSendKeys(element,length);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='length']/following::p-select[1]"), 10);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 10);
		js.doJsClick(element2);
		
		}
	public void selectParticleSize(String particleSize) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='partSize']"), 10);
		eUtil.doSendKeys(element, particleSize);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='partSize']/following::p-select[1]"), 10);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 15);
		js.doJsClick(element2);
	}
	
	public void selectPoreSize(String poreSize) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='poreSize']"), 10);
		eUtil.doSendKeys(element, poreSize);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='poreSize']/following::p-select[1]"), 10);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 15);
		js.doJsClick(element2);
	}
	
	public void selectfilmThickness(String filmThickness) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='thickness']"), 10);
		eUtil.doSendKeys(element, filmThickness);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='thickness']/following::p-select[1]"), 10);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 10);
		js.doJsClick(element2);
		
	}
	public void selectInnerDiameter(String innerDiameter) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='innerDia']"), 10);
		eUtil.doSendKeys(element, innerDiameter);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='innerDia']/following::p-select[1]"), 10);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 15);
		js.doJsClick(element2);
}

	public void selectOuterDiameter(String text) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='outerDia']"), 10);
		eUtil.doSendKeys(element, text);
		
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='outerDia']/following::p-select[1]"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
		
		WebElement element2=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='gm']"), 15);
		js.doJsClick(element2);
}
	public void seRemarks(String remarks) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='remarks']"),10);
		eUtil.doSendKeys(element, remarks);
	}
	
	public void clickSaveButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//button[@id='save']"), 10);
		js.doJsClick(element);
}
	public void clickCancelButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Cancel']"), 10);
		js.doJsClick(element);
}
}
