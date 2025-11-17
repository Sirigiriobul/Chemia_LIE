package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class VendorPage extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public VendorPage(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);

	}

	public void clickHamIcon() {
		js.doJsClick(eUtil.waitForElementPresence(By.xpath("//a[@id='sidebar-toggle']"), 10));
	}

	public void clickInvMasterData() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//span[normalize-space(text()) = 'Inv Master Data']"), 10);
		js.doJsClick(element);

	}

	public void clicKVendorsMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Vendors']"), 5);
		js.doJsClick(element);
	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementClickable(By.id("add"), 5);
		js.doJsClick(element);
	}

	public void clickVendorCodeAddButton(String vendorCode) {
		if(eUtil.isElementDisplayed(By.xpath("//span[@class='material-symbols-sharp']"))) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[@class='material-symbols-sharp']"), 5);
		js.doJsClick(element);
		}
		else {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='vendorCode']"), 5);
		eUtil.doSendKeys(element1,vendorCode);
	}
	}

	public void clickVendorCodeButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//button[@mattooltip='Vendor code']"), 5);
		js.doJsClick(element);

	}

	public void setVendorName(String vendorName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='vendorName']"), 5);
		eUtil.doSendKeys(element, vendorName);
	}

	public String getVendorName() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='vendorName']"), 5);
		return js.doGetText(element);
	}

	public void setDescripiton(String descripiton) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='vendorDesc']"), 5);
		eUtil.doSendKeys(element, descripiton);
	}

	public void clickSaveButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Save']"), 4);
		js.doJsClick(element);
	}

	public void clickCancelButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Cancel']"), 4);
		js.doJsClick(element);
	}
}
