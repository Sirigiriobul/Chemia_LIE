package com.chemia.inventory.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class ExperimentEditorPage extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public ExperimentEditorPage(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);
	}

	public void clickOnGoingExperimentTab() throws InterruptedException {
		
		WebElement element = eUtil.waitForElementPresence(By.xpath("//mat-card//img[contains(@title,'Ongoing experiments')]"), 15);
		Thread.sleep(2000);
		js.doJsClick(element);
	}
	
	//input[@name='experimentDisplayId']
	public void setExperimentCode(String experimentCode) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@name='experimentDisplayId']"), 15);
		eUtil.doSendKeys(element,experimentCode);
	}
	
	public void clickExperimentCode() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//tbody//tr//td//a)[2]"), 15);
		js.doJsClick(element);
	}			
	
	// restore experiment pop up
	public boolean isRestoreDisplayed() {
		try {
			WebElement element = eUtil.waitForElementPresence(By.xpath(
					"//span[contains(@class,'p-dialog-title') and normalize-space()='Restore experiment information']"),
					5);
			return eUtil.isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isConfirmButtonDisplayed() {
		try {
			Thread.sleep(2000);
			return eUtil.isElementDisplayed(By.xpath("//button[normalize-space()='Confirm']"));
		} catch (Exception e) {
			return false;
		}
	}

	public void clickConfirmTextBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='Confirm']"), 15);
		eUtil.doClick(element);
	}

	public void clickNoBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='No']"), 15);
		eUtil.doClick(element);
	}

	public void clickYesBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='Yes']"), 15);
		js.doJsClick(element);
	}

	public void waitforScrollComponent() {
		eUtil.waitForElementPresence(By.xpath("//*[@id='scrollToComponentId']"), 15);
	}

	// common buttons
	public void clickSaveBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='Save']"), 10);
		js.scrollIntoView(element);
		eUtil.doClick(element);
	}


//	@FindBy(xpath="//button[@id='submitForApprovaId']")
//	private WebElement confirmBtn;
//	public void clickConfirmBtn() throws InterruptedException {
//		WebElement element = eUtil.waitForElementVisible(confirmBtn, 20);
//		js.scrollIntoView(element);
//		eUtil.doClick(element);
//	}

	
	
	
	//div[@id='columnDetails_Id']
	
	// Equipment Details
	public void clickEqDetailsAddIcon() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//div[contains(text(),' Equipment Details')]//mat-icon"), 10);
		js.scrollIntoViewCenter(element);
		js.doJsClick(element);
	}
	
	public void clickEquipmentTypeDropDown(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@id='loadMasterDataEquipmentFromType_Id']"), 10);
		js.doJsClick(element);
	}
	
	public void setEquipmentType(String equipmentType) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@type='text']"), 10);
		eUtil.doSendKeys(element, equipmentType);
		js.doJsClick(element);
		Thread.sleep(1000);
	}
	
	public void clickEquipmentNameDropDown(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@id='equipNameList_Id']"), 10);
		js.doJsClick(element);
	}
	
	public void setEquipmentName(String equipmentname) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@type='text']"), 10);
		eUtil.doSendKeys(element, equipmentname);
		js.doJsClick(element);
		Thread.sleep(1000);
	}
	
	public void selectStartDate(String text) {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("(//p-datepicker[@dateformat='dd-M-yy'])[1]//button"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						10);
		js.doJsClick(element1);
	}
	public void selectEndDate(String text) {
		WebElement element = eUtil
				.waitForElementClickable(By.xpath("(//p-datepicker[@dateformat='dd-M-yy'])[1]//button"), 5);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementClickable(
						By.xpath("//span[normalize-space()='" + text+ "' and contains(@class,'p-datepicker-day') and not(contains(@class,'p-disabled'))]"),
						10);
		js.doJsClick(element1);
	}
	
	public void setEquipmentRemarks(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@id='remarks_Id']"), 10);
		eUtil.doSendKeys(element, text);
	}




	public void setEqRemarks1(String text) {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//th[contains(@id,'equipremarksId')]/following::textarea[1]"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void clickEqSave() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//button[@id='saveEquipment_Id' or @id='saveEquipManually_Btn']"), 10);
		js.scrollIntoView(element);
		js.doJsClick(element);
	}

	public void clickEqCancel() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='cancleAddEquipment_Id']"), 10);
		js.doJsClick(element);
	}

	public void clickEqEditIcon(int index) {
		WebElement element = eUtil
					.waitForElementPresence(By.xpath("//div[@id='equipmentdetailsDiv']/following::table[1]/tr[" + index+ "]/td[10]//mat-icon   [@mattooltip='Edit']"), 10);
		js.scrollIntoViewCenter(element);
		js.doJsClick(element);
	}

	public void clickEqDeleteIcon(int index) {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//div[@id='equipmentdetailsDiv']/following::table[1]/tr[" + index
						+ "]/td[10]//mat-icon   [@mattooltip='Delete']"), 10);
		js.scrollIntoViewCenter(element);
		js.doJsClick(element);
	}



	public void clickEqDeleteSaveBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='submitBtn']"), 10);
		js.doJsClick(element);

	}

	// Column Details
	public void clickColumnDetailsAddIcon() throws InterruptedException {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//div[contains(text(),' Column Details')]//mat-icon"), 10);
		js.scrollIntoViewCenter(element);
		js.doJsClick(element);
		Thread.sleep(500);
	}

	public void clickColumnAddOptn() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//a[@id='addNewColumn_btn' or @id='addNewColumn_btnA']"), 10);
		js.doJsClick(element);
	}

	public void setClColumnNum(String columnNumber) throws InterruptedException {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//p-select[@id='checkInUseColumnFlag_Id']//chevrondownicon"), 10);
		js.doJsClick(element);
		Thread.sleep(1000);
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@role='searchbox']"), 10);
		eUtil.doSendKeys(element1, columnNumber);
		eUtil.doClick(element1);
		Thread.sleep(1000);
		
	}


	public void setClColumnName(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@id='columnName_Id']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void setClNumOfInjections(String text) {
		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//th[@id='noOfInjects']/following-sibling::td/input"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClInternalSampleNum(String text) {
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//th[@id='sampleNum']/following-sibling::td/input[@id='sampleNum_Id']"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClBackPressure(String text) {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@id='backPressure_Id']"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClTheoriticalPlates(String text) {
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//input[@id='theoreticalPlates_Id' or @id='theoreticalPlates_Id_a']"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClTrailingFactor(String text) {
		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//input[@id='traillingFactorId' or @id='traillingFactor_Id']"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClInstrumentType(String text) {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@id='equipInstrTypeId']"), 10);
		eUtil.doSendKeys(element1, text);
	}

	public void setClInstrumentType() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//p-select[@id='equipInstrTypeId']//chevrondownicon"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@id='equipInstrTypeId_1']"), 10);
		js.doJsClick(element1);
	}

	public void setClInstrumentCode(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@id='equipInstrId']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void setClInstrumentCode() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@id='equipInstrId']//chevrondownicon"),
				5);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@id='equipInstrId_1']"), 10);
		js.doJsClick(element1);
	}

	public void setClStartDate(int date) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@id='equipStartTime_ID']"), 10);
		eUtil.doClick(element);
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//span[not(contains(@class,'p-disabled')) and normalize-space()='" + date + "']"), 10);
		js.doJsClick(element1);
		Thread.sleep(1000);
	}

	public void setClStartDate(String date) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@id='startTimeId']/following::input[1]"), 10);
		eUtil.doClick(element);
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//span[not(contains(@class,'p-disabled')) and normalize-space()='" + date + "']"), 10);
		js.doJsClick(element1);
		Thread.sleep(1000);
	}

	public void setClEndDate(int date) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@id='equipEndTime_Id']"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//span[not(contains(@class,'p-disabled')) and normalize-space()='" + date + "']"), 10);
		js.doJsClick(element1);
	}

	public void setClEndDate(String date) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@id='endTimeId']/following::input[1]"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//span[not(contains(@class,'p-disabled')) and normalize-space()='" + date + "']"), 10);
		js.doJsClick(element1);
	}

	public void setClRemarks(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@id='remarks_ID' or @id='remarks_Id']"),
				10);
		js.scrollIntoView(element);
		eUtil.doClick(element);
		eUtil.doSendKeys(element, text);
	}

	public void clickClSaveBtn() {
		WebElement element1 = eUtil
				.waitForElementPresence(By.xpath("//button[@id='saveNewColumn_btn'or @id='saveNewColumnId_btn']"), 10);
		js.doJsClick(element1);

	}

	public void clickClEditIcon(int index) {
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//div[contains(text(),' Column Details')]/following::table[1]/tbody/tr[" + index
						+ "]/td[10]//mat-icon[@mattooltip='Edit']"),
				10);
		js.doJsClick(element1);
	}

	public void clickClDeleteIcon(int index) {
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//div[contains(text(),' Column Details')]/following::table[1]/tbody/tr[" + index
						+ "]/td[10]//mat-icon[@mattooltip='Delete']"),
				10);
		js.doJsClick(element1);
	}

	public void setClDeleteRemarks(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@inputid='remarksTextarea']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void clickClDeleteSaveBtn() {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//button[@id='submitBtn']"), 10);
		js.doJsClick(element1);
	}

	// Material Details
	public void clickMtDetailsAddIcon() {
		WebElement element = eUtil
				.waitForElementPresence(By.xpath("//div[contains(text(),' Material Details')]//mat-icon"), 10);
		js.scrollIntoViewCenter(element);
		js.doJsClick(element);
	}

	public void clickMtDetailsAddOptn() {
		WebElement element = eUtil.waitForElementPresence(
				By.xpath("//span[text()='Add from MasterData' or normalize-space()='Enter Manually']"), 10);
		eUtil.doClick(element);
	}

	public void clickMtBatchNo() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@id='batchId']//chevrondownicon"), 10);
		js.doJsClick(element);
	}
	
	public void setBatchNumber(String batchNumber) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@role='searchbox']"), 10);
		eUtil.doSendKeys(element, batchNumber);
		Thread.sleep(1000);
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//p-select[@id='batchId']//chevrondownicon"), 10);
		js.doJsClick(element1);
		Thread.sleep(1000);
		WebElement element2 = eUtil.waitForElementPresence(By.xpath("//li[@role='option']"), 10);
		js.doJsClick(element2);
	}
	
	public void setMtQuantityRequired(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='qtyRequired']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void setMtReqQuantityUom(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//*[@formcontrolname='qtyRequiredUom']"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li/span[text()='" + text + "']"), 10);
		js.doJsClick(element1);
	}

	public void setMtBatchNo() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='batchId']//chevrondownicon"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[@id='batchId_0']"), 10);
		js.doJsClick(element1);
	}

	public void setMtUom(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//div[@id='uomId']"), 10);
		eUtil.doClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li/span[text()='" + text + "']"), 10);
		js.doJsClick(element1);
	}

	public void setMtRemarks(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//th[@id='remarksId']/following::td/textarea[1]"),
				10);
		js.doJsClick(element);
		eUtil.doSendKeys(element, text);

	}

	public void clickMtSaveBtn() {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//button[@id='saveLookpButtonId']"), 10);
		js.doJsClick(element1);
	}

	@FindBy(xpath = "//div[contains(text(),'Material Details')]/following::table[1]/tbody/tr")
	private List<WebElement> MaterialRowCount;

	public int getMaterialRowCount() {
		return MaterialRowCount.size();
	}

	public void clickMtDeleteIcon(int index) {
		WebElement element1 = eUtil.waitForElementPresence(
				By.xpath("//div[contains(text(),'Material Details')]/following::table[1]/tbody/tr[" + index
						+ "]/td[14]//mat-icon[@mattooltip='Delete']"),
				10);
		js.doJsClick(element1);
	}

	public void setMtDeleteRemarks(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@inputid='Remarkstextarea']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void clickMtDeleteSave() {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//button[@id='submitBtn']"), 10);
		js.doJsClick(element1);

	}

	
	// select verifier popup
	public void setVerifier(String text) {
		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//p-select[@id='verList']"), 15);
		js.doJsClick(element1);
		WebElement element2 = eUtil.waitForElementPresence(By.xpath("//input[@aria-owns='verList_list']"), 10);
		eUtil.doSendKeys(element2, text);
		WebElement element3 = eUtil.waitForElementPresence(By.xpath("//li[@id='verList_0']"), 10);
		js.doJsClick(element3);
	}

	public void setComments(String text) {
		eUtil.waitForFrameToBeAvailableAndSwitchToIt(By.xpath("//div[@id='saveCommentsId']//iframe"), 10);
		WebElement element2 = eUtil.waitForElementPresence(By.xpath("//body[@id='tinymce']"), 10);
		js.scrollIntoView(element2);
		eUtil.doSendKeys(element2, text);
		eUtil.doSwitchToDefaultContent();
	}

	public void setPassword(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@type='password']"), 10);
		eUtil.doSendKeys(element, text);
	}

	public void clickAuthenticateSubmit() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='validatePasswordSave_btn']"), 10);
		eUtil.doClick(element);
	}

	public void clickVerifyConfirm() throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='submitForVerification']"), 10);
		js.scrollIntoViewCenter(element);
		eUtil.doClick(element);
	}



	
	

	// footer
	public void clickSubmitForReviewBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='validateVerificationReq_btn']"), 10);
		js.scrollIntoViewCenter(element);
		eUtil.doClick(element);
	}

	public void clickSubmitForApprovalBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='validateApproveReq_btn']"), 10);
		js.scrollIntoViewCenter(element);
		eUtil.doClick(element);
	}

	public void clickSaveExperimentBtn() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='showRemarksPopupId']"), 10);
		js.scrollIntoViewCenter(element);
		eUtil.doClick(element);
	}

	public void setSaveRemarks(String text) {
		eUtil.waitForFrameToBeAvailableAndSwitchToIt(By.xpath("//editor[@id='saveComments']//iframe"), 10);
		WebElement element2 = eUtil.waitForElementPresence(By.xpath("//body[@id='tinymce']"), 10);
		eUtil.doSendKeys(element2, text);
		eUtil.doSwitchToDefaultContent();
	}

	public void clickSaveRemarks() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[@id='saveRemarksExp']"), 10);
		js.scrollIntoViewCenter(element);
		eUtil.doClick(element);
	}

}
