package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddColumnCatalogue extends BasePage {
	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddColumnCatalogue(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//mat-icon[@id='add']"), 10);
		js.doJsClick(element);
	}

	public void selectColumnName(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//span[@role='combobox'])[4]"), 10);
		js.scrollIntoView(element);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//span[@class='ng-star-inserted' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);

	}

	public void selectCategory(String text) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//span[@role='combobox'])[5]"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.doJsClick(element1);
	}

	public void selectColumnNumber() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[@class='material-symbols-sharp']"), 10);
		js.doJsClick(element);
	}
	
	public void selectColumnNumber(String columnNumber) {
		if (eUtil.isElementDisplayed(By.xpath("//span[@class='material-symbols-sharp']"))) {
			WebElement element = eUtil.waitForElementPresence(By.xpath("//span[@class='material-symbols-sharp']"), 2);
			js.doJsClick(element);
		} else {
			WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='colNum']"), 2);
			eUtil.doSendKeys(element1, columnNumber);

		}

	}

	public String getColumnNumber() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='colNum']"), 10);
		return js.doGetText(element);
	}

	public void selectColumnDimension(String columnName) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='colDim']"), 10);
		eUtil.doSendKeys(element, columnName);
	}

	public void setManufacturer(String manufacturer) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='mfg']"), 10);
		eUtil.doSendKeys(element, manufacturer);
	}

	public void setSerialNumber(String serialNumber) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='slNo']"), 10);
		eUtil.doSendKeys(element, serialNumber);
	}

	public void setPartNo(String PartNo) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='partNo']"), 10);
		eUtil.doSendKeys(element, PartNo);
	}

	public void setColumnPoNumber(String columnPoNumber) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='colPO']"), 10);
		eUtil.doSendKeys(element, columnPoNumber);
	}

	public void selectType(String text) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("(//span[@role='combobox'])[6]"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//li[@role='option' and normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void setColumnDescription(String columnDescription) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='colDesc']"), 10);
		eUtil.doSendKeys(element, columnDescription);
	}

	public void selectQualificationStatus() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='qualStatus']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@aria-label='Qualified']"), 10);
		js.doJsClick(element1);
	}

	public void selectReceivedBy(String ReceivedBy) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='rcvBy']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='" + ReceivedBy + "']"),
				10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void selectReceivedOn(String ReceivedOn) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='rcvOn']//button"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + ReceivedOn
								+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						5);
		js.doJsClick(element1);

	}

	public void selectActivatedBy(String ActivatedBy) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@formcontrolname='activateBy']"), 10);
		js.scrollIntoView(element);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='" + ActivatedBy + "']"),
				5);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void selectActivatedOn(String ActivatedOn) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//*[@formcontrolname='activateOn']//button"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + ActivatedOn
								+ "'and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						5);
		js.doJsClick(element1);
	}

	public void setMaxInjections(String maxInjections) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='maxInjection']"), 10);
		eUtil.doSendKeys(element, maxInjections);
	}

	public void setCumulativeInjections(String cumulativeInjections) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[@formcontrolname='cumInjection']"), 10);
		eUtil.doSendKeys(element, cumulativeInjections);
	}

	public void setRemarks(String remarks) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//textarea[@formcontrolname='remarks']"), 10);
		eUtil.doSendKeys(element, remarks);
	}

	public void clickSubmitButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Submit']"), 10);
		js.doJsClick(element);
	}

	public void clickCancelButton() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//button[@id='cancel']"), 10);
		js.doJsClick(element);
	}
	
	public void setAuthenticationRemarks(String authenticationRemarks) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[contains(@class,'ql-editor')]"), 10);
		eUtil.doSendKeys(element,authenticationRemarks);
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
