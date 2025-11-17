package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class ReviewMaintenance extends BasePage {
	ElementUtilities eUtil;
	JavaScriptUtilities js;

	
	public ReviewMaintenance(WebDriver driver)
	{
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
			}
	
	public void waitForLoaderRemoval() {
		eUtil.waitForElementInVisible(By.xpath("//div[contains(@class,'cssload-speeding-wheel')]"));
	}
}
