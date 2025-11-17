package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class ApproveBatch extends BasePage{
	
	 ElementUtilities eUtil;
	JavaScriptUtilities js;

	public ApproveBatch(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}
	public void setSearch(String searchData) {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//input[contains(@placeholder,'Search')]"),10);
		eUtil.doSendKeys(element, searchData);
	}
	
	//table/tbody/tr[1]//mat-icon[@mattooltip='Action']//table/tbody/tr[1]//mat-icon[@mattooltip='Action']

	public void clickAction() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//table/tbody/tr[1]//mat-icon[@mattooltip='Action']"),10);
		js.doJsClick(element);
	}
	
	//a[@id='reviewReq']
	public void clickReview() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//a[@id='reviewReq']"),10);
		js.doJsClick(element);
	}
	public void clickApprove() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//a[@id='approveInvStock']"),10);
		js.doJsClick(element);
	}
}
