package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class EquipmentAndInstrumentUsageReport extends BasePage{
	ElementUtilities eUtil;
	JavaScriptUtilities js;
	
	public EquipmentAndInstrumentUsageReport(WebDriver driver) {
		super(driver);
		eUtil=new ElementUtilities(driver);
		js=new JavaScriptUtilities(driver);
	}

	public void clickEquipmentTab() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//div[@id='equipTab']"),5);
		js.doJsClick(element);
		
	}
	
	public void clickEquipmentGoButton() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//mat-icon[normalize-space()='east']"),5);
		js.doJsClick(element);
		
	}
	public void clickInstrumentTab() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("(//span[normalize-space()='Instrument'])[1]"),5);
		js.doJsClick(element);
		
	}
	
	public void clickInstrumentGoButton() {
		WebElement element=eUtil.waitForElementClickable(By.xpath("//mat-icon[normalize-space()='east']"),5);
		js.doJsClick(element);
		
	}
	
	
	


}
