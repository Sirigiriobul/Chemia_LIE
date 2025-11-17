package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class VendorMapping extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public VendorMapping(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);

	}

	public void clickMainMenu() {
		WebElement element = eUtil.waitForElementPresence(By.id("sidebar-toggle"), 30);
		js.doJsClick(element);
	}

	public void clickInvMasterData() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//span[normalize-space(text()) = 'Inv Master Data']"), 10);
		js.doJsClick(element);
	}

	public void clickVendorMapping() {
		WebElement element =eUtil.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Vendor Mapping']"), 5);
		js.doJsClick(element);	
		}
	
	public void clickAddButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='add' and @mattooltip='Add' ]"), 5);
		js.doJsClick(element);
	}
	
	public void setMaterialCode(String materialCode) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//p-autocomplete[@formcontrolname='matCode']//input"), 5);
		eUtil.doSendKeys(element, materialCode);
		
		WebElement element1=eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='"+materialCode+"']"), 5);
		js.doJsClick(element1);	
	}
	
	
	public void setVendorNameSearch(String setVendorName) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("(//input[@type='text'])[4]"), 5);
		eUtil.doSendKeys(element,setVendorName);
	}
	public void clickSearchButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//button[@id='search']"), 5);
		js.doJsClick(element);
	}
	
	public void clickReqVendorCheckbox(String text) {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//div[contains(@class,'vendor-list')]//label[normalize-space()='"+text+"']/preceding::input[1]"), 5);
		js.doJsClick(element);
	}
	
	public void clickSaveButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//button[@id='save' and normalize-space()='Save']"), 5);
		js.doJsClick(element);
	}
	
	public void clickCancelButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//button[@id='cancel' and normalize-space()='Cancel']"), 5);
		js.doJsClick(element);
	}
	
}
