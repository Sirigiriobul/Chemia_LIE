package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddEquipmentType extends BasePage {
	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddEquipmentType(WebDriver driver) {
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
	public void clickEquipTypeMenu() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//a[@id=\"subMenuId\"]//span[@class=\"title\"][normalize-space()=\"Equipment Type\"]"), 5);
		js.doJsClick(element);
	}
	
	public void clickAddButton() {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='add']"), 10);
		js.doJsClick(element);
	}
	
	public void setEquipmentType(String equipType) {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='equipTye']"), 10);
		eUtil.doSendKeys(element, equipType);
	}
	
	public void selectMovable() {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='movable']"), 10);
		js.doJsClick(element);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Yes']"), 10);
	js.doJsClick(element1);
		}
	
	public void setDescription(String description) {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='equipdesc']"), 10);
		eUtil.doSendKeys(element, description);
	}
	public void clickSaveButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Save']"), 10);
		js.doJsClick(element);
	}
	
	public void clickCancelButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Cancel']"), 10);
		js.doJsClick(element);
	}
	
}
