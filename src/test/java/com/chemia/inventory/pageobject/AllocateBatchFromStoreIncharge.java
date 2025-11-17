package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AllocateBatchFromStoreIncharge extends BasePage {
	ElementUtilities eUtil;
	JavaScriptUtilities js;
	  

	public AllocateBatchFromStoreIncharge(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void setSearch(String searchData) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[contains(@placeholder,'Search')]"), 10);
		eUtil.doSendKeys(element, searchData);
	}

	public void clickAction() {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("//table/tbody/tr[1]//mat-icon[@mattooltip='Action']"), 10);
		js.doJsClick(element);
	}

	public void clickAllocate() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//a[@id='editInv']"), 10);
		js.doJsClick(element);
	}

	public void clickCheckBox() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//input[@type='checkbox'])[3]"), 10);
		js.doJsClick(element);
	}

	public void clickAvailablePopupCheckBox() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//table/tbody/tr[1]//td//div[@class='mdc-checkbox'])[2]"), 10);
		js.DoMouseHoverclick(element);
		}
	
	
	public void setIndentQuantity(String indentQuantity) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//tbody//tr[1]//td[15]//input"), 10);
		eUtil.doSendKeys(element,indentQuantity);
	}
	
	public void clickAllocateButton(String password) throws Exception {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[text()='Allocate']"), 10);
		js.doJsClick(element);
		try {
			if (clickSubmitTick()) {
				setPassword(password);
				clickConfirmButton();
			}else {
				setPassword(password);
				clickConfirmButton();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	
	public  boolean setPassword(String password) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@type='password']"), 10);
		eUtil.doSendKeys(element,password);
		return false;
	}
	
	public void clickConfirmButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Confirm']"), 10);
		js.doJsClick(element);
	}
	
	public boolean clickSubmitTick() {
		try {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@mattooltip='submit']"), 5);
		js.doJsClick(element);
		return true;
		}catch(Exception e)
		{
			return false;
		}
	
		}
	
}
