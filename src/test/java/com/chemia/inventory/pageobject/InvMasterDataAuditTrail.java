package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class InvMasterDataAuditTrail extends BasePage{
	ElementUtilities eUtil;
	JavaScriptUtilities js;
	
	
	public InvMasterDataAuditTrail(WebDriver driver) {
		super(driver);
		eUtil=new ElementUtilities(driver);
		js=new JavaScriptUtilities(driver);
		
	}
	
	public void clickMainMenu() {
		WebElement element = eUtil.waitForElementPresence(By.id("sidebar-toggle"), 10);
		eUtil.doClick(element);
	}
	

	public void clickInvMasterData() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space(text()) = 'Inv Master Data']"), 10);
		eUtil.doClick(element);
	}
	
	public void clickAuditTrail() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Audit Trail']"), 5);
		eUtil.doClick(element);		
	}
	
	public void clickGoButton() {
		WebElement element=eUtil.waitForElementPresence(By.xpath("//mat-icon[normalize-space()='east']"),5);
		js.doJsClick(element);
		
	}
	

}
