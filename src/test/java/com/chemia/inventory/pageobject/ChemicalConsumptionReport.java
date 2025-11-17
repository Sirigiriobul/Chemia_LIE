package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class ChemicalConsumptionReport extends BasePage{
		
		ElementUtilities eUtil;
		JavaScriptUtilities js;
		
		public ChemicalConsumptionReport(WebDriver driver) {
			super(driver);
			eUtil=new ElementUtilities(driver);
			js=new JavaScriptUtilities(driver);
		}
		
		
		public void clickGoButton() {
			WebElement element=eUtil.waitForElementPresence(By.xpath("//mat-icon[normalize-space()='east']"),10);
			js.doJsClick(element);
			
		}
		

}


