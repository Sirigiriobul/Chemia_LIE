package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class VerifyInstrument extends BasePage{
	
	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public VerifyInstrument(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}
	
	public void setSearchBar(String batchNumber) {
	WebElement element = eUtil.waitForElementPresence(By.xpath("//input[contains(@placeholder,'Search')]"), 10);
	eUtil.doSendKeys(element,batchNumber);
	}
	
	public void clickVerifyButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//table/tbody/tr[1]//mat-icon[normalize-space()='done']"), 10);
		js.doJsClick(element);
		}
	
	public void setRemarks(String remarks) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[contains(@class,'ql-editor')]"), 10);
		eUtil.doSendKeys(element,remarks);
		}
	
	public void setPassword(String passWord) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@type='password']"), 10);
		eUtil.doSendKeys(element,passWord);
		}
	
	public void clickConfirmButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Confirm']"), 10);
		js.doJsClick(element);
		}
	
}




 


