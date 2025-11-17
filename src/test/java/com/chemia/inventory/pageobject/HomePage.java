package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class HomePage extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public HomePage(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void waitForLoaderRemoval() {
		eUtil.waitForElementInVisible(By.xpath("//div[contains(@class,'cssload-speeding-wheel')]"));
	}

	public void clickLIE() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//h5[text()='Inventory and Equipment']"), 10);
		js.doJsClick(element);
	}
	
	public void clickARD() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//h5[text()='Analytical R&D']"), 10);
		js.doJsClick(element);
	}
	

	public void clickHamIcon() {
		js.doJsClick(eUtil.waitForElementPresence(By.xpath("//a[@id='sidebar-toggle']"), 100));
	}

	public void clickInvMasterData() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space(text())='Inv Master Data']"),
				10);
		js.doJsClick(element);

	}

	public void clickMaterialMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Materials']"), 5);
		js.doJsClick(element);
	}

	public void clicKVendorsMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Vendors']"), 5);
		js.doJsClick(element);
	}

	public void clickVendorMapping() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Vendor Mapping']"), 5);
		js.doJsClick(element);
	}

	public void clickInvMasterAuditTrail() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Audit Trail']"), 5);
		js.doJsClick(element);
	}

	public void clickEquipMasterDataMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//span[normalize-space(text())='Equip Master Data']"), 10);
		js.doJsClick(element);

	}

	public void clickEquipTypeSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[@class='title'][normalize-space()='Equipment Type']"), 5);
		js.doJsClick(element);
	}

	public void clickInstrumentTypeSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[@class='title'][normalize-space()='Instrument Type']"), 5);
		js.doJsClick(element);
	}

	public void clickColumnTypeSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[@class='title'][normalize-space()='Column Type']"), 5);
		js.doJsClick(element);
	}

	public void clickEquipMasterDataAuditTrailSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Audit Trail']"), 5);
		js.doJsClick(element);
	}

	public void clickInventoryBatchMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='menuId' and normalize-space()='Inventory Batches']"), 5);
		js.doJsClick(element);
	}

	public void clickAvailableStockSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Available Stock']"), 5);
		js.doJsClick(element);
	}

	public void clickNonAvailableStockSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId' and normalize-space()='Non Available Stock']"), 5);
		js.doJsClick(element);
	}

	public void clickHistoricStockSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='subMenuId' and normalize-space()='Historic Stock']"), 5);
		js.doJsClick(element);
	}

	public void clickBatchVerificationRequestSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId' and normalize-space()='Batch Verification Requests']"), 5);
		js.doJsClick(element);
	}

	public void clickStockRequestSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("(//span[normalize-space(text())='Stock Request'])[5]"), 10);
		js.doJsClick(element);

	}

	public void clickApproveRequestSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("(//span[normalize-space(text())='Approve Request'])[6]"), 10);
		js.doJsClick(element);
	}

	public void clickEquipmentCatalogueMenu() {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("//a[@id='menuId' and normalize-space()='Equipment Catalogue']"), 10);
		js.doJsClick(element);
	}

	public void clickEquipmentCatalogueSubMenu() {
		WebElement element = eUtil.waitForElementClickable(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Equipment Catalogue']"), 10);
		js.doJsClick(element);
	}

	public void clickInstrumentCatalogueSubMenu() {
		WebElement element = eUtil.waitForElementClickable(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Instrument Catalogue']"), 10);
		js.doJsClick(element);
	}

	public void clickColumnCatalogueSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Column Catalogue']"), 10);
		js.doJsClick(element);
	}

	public void clickMaintenanceScheduleSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Maintenance Schedule']"), 10);
		js.doJsClick(element);
	}

	public void clickCalibrationScheduleSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Calibration Schedule']"), 10);
		js.doJsClick(element);
	}

	public void clickEquipmentVerificationRequestsSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Equipment Verification Requests']"), 10);
		js.doJsClick(element);
	}

	public void clickInstrumentVerificationRequestsSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Instrument Verification Requests']"), 10);
		js.doJsClick(element);
	}

	public void clickColumnVerificationRequestsSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Column Verification Request']"), 10);
		js.doJsClick(element);
	}

	public void clickReviewMaintenanceSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Review Maintenance']"), 10);
		js.doJsClick(element);
	}

	public void clickReviewCalibrationSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Review Calibration']"), 10);
		js.doJsClick(element);
	}

	public void clickReportingMenu() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//span[normalize-space()='Reporting']"), 10);
		js.doJsClick(element);
	}

	public void clickChemicalConsumptionSubMenu() {
		WebElement element = eUtil.waitForElementClickable(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Chemical Consumption Report']"), 10);
		js.doJsClick(element);
	}

	public void clickEquipmentInstrumentUsageReportsSubMenu() {
		WebElement element = eUtil.waitForElementClickable(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Equipment/Instrument Usage Reports']"), 10);
		js.doJsClick(element);
	}

	public void clickColumnUsageReportsSubMenu() {
		WebElement element = eUtil.waitForElementClickable(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Column Usage Reports']"), 10);
		js.doJsClick(element);
	}

	public void clickChemicalRetestandExpiryReportsSubMenu() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//a[@id='subMenuId']//span[normalize-space()='Chemical Retest and Expiry report']"), 10);
		js.doJsClick(element);
	}

	public void clickHomePageButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@alt='homeIcon']"), 10);
		js.doJsClick(element);
	}

	public void clickBatchRequestTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//img[@mattooltip='Batch request'])[2]"), 10);
		js.doJsClick(element);
	}

	public void clickEquipmentVerificationTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Equipment Verification']"), 10);
		js.doJsClick(element);
	}

	public void clickInstrumentVerificationTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Instrument Verification']"), 10);
		js.doJsClick(element);
	}

	public void clickColumnVerificationTab() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Column Verification']"), 10);
		js.doJsClick(element);
	}

	public void clickApprovedRequestSubMenu() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("(//span[normalize-space(text())='Approved Request'])[6]"), 10);
		js.doJsClick(element);
	}

}
