package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class AddBatch extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public AddBatch(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void clickMainMenu() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("sidebar-toggle"), 10);
		js.doJsClick(element);
	}

	public void clickInventoryBatchMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='menuId' and normalize-space()='Inventory Batches']"), 5);
		js.doJsClick(element);
	}

	public void clickAvailableStock() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Available Stock']"), 5);
		js.doJsClick(element);
	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//mat-icon[@id='add']"), 5);
		js.doJsClick(element);
	}

	public void setMaterialCode(String materialCode) {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//p-autocomplete[@formcontrolname='invCode']//input"), 5);
		eUtil.doSendKeys(element, materialCode);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//span[text()='" + materialCode + "']"), 10);
		js.doJsClick(element1);
	}

	public void settechnicalGrade(String technicalGrade) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='techGrade']"), 5);
		eUtil.doSendKeys(element, technicalGrade);
	}

	public void selectVendorName(String vendorName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='vendorName']"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@aria-label='" + vendorName + "']"), 5);
		js.doJsClick(element1);
	}

	public void setBatchNumber(String batchNumber) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='batchNo']"), 5);
		eUtil.doSendKeys(element, batchNumber);
	}

	public void setMaterialName(String materialName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-autocomplete[@formcontrolname='materialName']"),
				5);
		eUtil.doSendKeys(element, materialName);
	}

	public void selectReceivedQuantity(String receivedQuantity) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='receivedQty']"), 10);
		eUtil.doSendKeys(element, receivedQuantity);

		WebElement element1 = eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='qtyUom']"), 10);
		js.doJsClick(element1);

		Thread.sleep(2000);
		WebElement element2 = eUtil.waitForElementClickable(By.xpath("//li[@aria-label='Kg']"), 10);
		js.doJsClick(element2);

	}

	public void selectManufacturerDate(String text) {
		WebElement element1 = eUtil
				.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='mfgDate']//button"), 5);
		js.doJsClick(element1);

		WebElement element2 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text
								+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						5);
		js.doJsClick(element2);

	}

	public void selectExpiryDate(String text) throws InterruptedException {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='expDate']//button"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementClickable(By.xpath("//button[@aria-label='Next Month']"), 5);
		js.doJsClick(element1);
		WebElement element2 = eUtil.waitForElementClickable(By.xpath("//button[@aria-label='Next Month']"), 5);
		js.doJsClick(element2);

		Thread.sleep(1000);
		WebElement element3 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text
								+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						5);
		js.doJsClick(element3);
	}

	public void selectRetestDate(String text) throws InterruptedException {

		WebElement element = eUtil
				.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='resetDate']//button"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text
								+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						10);
		js.doJsClick(element1);

	}

	public void selectReceivedDate(String text) {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("//p-datepicker[@formcontrolname='receivedDate']//button"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil
				.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text
								+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						10);
		js.doJsClick(element1);
	}

	// span[normalize-space()="obul_cpl_ard_Analyst"]
	// span[normalize-space()='obul_cpl_ard_analyst']

	public void setPrice(String price) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='price']"), 5);
		eUtil.doSendKeys(element, price);

		WebElement element1 = eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='priceUom']"), 5);
		js.doJsClick(element1);

		WebElement element2 = eUtil.waitForElementClickable(By.xpath("//li[@aria-label='Rs']"), 5);
		js.doJsClick(element2);
	}

	public void selectReceivedBy(String text) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//p-select[@formcontrolname='receivedBy']"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);

	}

	public void setLocation(String location) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='location']"), 10);
		eUtil.doSendKeys(element, location);
	}

	public void setPurityAsIsBasis(String purity1) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='purityasisBasic']"), 10);
		eUtil.doSendKeys(element, purity1);
	}

	public void setPurityOnAnhydrous(String purity2) {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//input[@formcontrolname='purityOnanhydrousBasis']"), 10);
		eUtil.doSendKeys(element, purity2);
	}

	public void setBatchRemarks(String batchRemarks) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='batchRemark']"), 10);
		eUtil.doSendKeys(element, batchRemarks);
	}

	public void setManufacturer(String manufacturer) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='manufacturer']"), 10);
		eUtil.doSendKeys(element, manufacturer);
	}

	public void uploadFile(String file) throws InterruptedException {
	    WebElement element = eUtil.waitForElementPresence(By.xpath("//span[text()='Attach Files']"), 10);
	    js.doJsClick(element);
	    Thread.sleep(3000);

	    WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@type='file']"), 10);
	    eUtil.doSendFilePath(element1, file);
	    Thread.sleep(3000);
	    
	    WebElement element2 = eUtil.waitForElementPresence(By.xpath("//button[@id='upload']"), 10);
	    js.doJsClick(element2);
	    Thread.sleep(3000);
	  	}

		
//		eUtil.doSendKeys(element1,file);
//		Thread.sleep(3000);	
	

	public void clickSaveButton() {
		WebElement element = eUtil.waitForElementPresence(By.id("save"), 10);
		js.doJsClick(element);
	}

	
	
	// (//span[@class='mdc-button__label'])[3]
	public void clickSubmitButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//span[@class='mdc-button__label'])[3]"), 10);
		js.doJsClick(element);
	}

	public void clickSearchbar(String searchData) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//input[contains(@placeholder,'Search')]"), 10);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, searchData);
	}

	public void clickResultantActionsIcon(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//table/tbody/tr[1]/td[normalize-space()='" + text+ "']/following::mat-icon[@mattooltip='Action'][1]"), 10);
		js.doJsClick(element);
	}
	
	public void clickDisableYesButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='enaDisableSaveId']"), 10);
		js.doJsClick(element);
	}

	public void clickEnableButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//a[normalize-space()='Enable']"), 10);
		js.doJsClick(element);
	}
	
	
	public void clickActionsOptn(String text) {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[normalize-space()='" + text + "' and @role='menuitem']"), 10);
		js.doJsClick(element);
	}

	public void setComments(String comments) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='recComments']"), 10);
		eUtil.doSendKeys(element, comments);
	}
	
	public void clickViewAttachment() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//span[@class='mdc-button__label'])[2]"), 10);
		js.doJsClick(element);
		Thread.sleep(2000);
	}
	
	public void closeViewAttachmentPopup() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='close']"), 10);
		js.doJsClick(element);
		Thread.sleep(2000);
	}

	public void clickEditSubmitButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//div[@class='row']//button)[1]"), 10);
		js.doJsClick(element);
	}

	public void setAuthentication(String passWord) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@name='password']"), 10);
		eUtil.doSendKeys(element, passWord);
	}

	public void clickFinalSubmit() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//span[normalize-space()='Confirm']"), 10);
		js.doJsClick(element);
	}

}