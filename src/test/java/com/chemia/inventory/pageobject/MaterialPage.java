package com.chemia.inventory.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.chemia.inventory.utilities.ElementUtilities;
import com.chemia.inventory.utilities.JavaScriptUtilities;

public class MaterialPage extends BasePage {

	ElementUtilities eUtil;
	JavaScriptUtilities js;

	public MaterialPage(WebDriver driver) {
		super(driver);
		eUtil = new ElementUtilities(driver);
		js = new JavaScriptUtilities(driver);

	}

	public void waitForLoaderRemoval() {
		eUtil.waitForElementInVisible(By.xpath("//div[contains(@class,'cssload-speeding-wheel')]"));
	}

	public void setUserName(String userName) {
		WebElement element = eUtil.waitForElementPresence(By.name("username"), 2);
		eUtil.doSendKeys(element, userName);
	}

	public void setPassword(String passWord) {
		WebElement element = eUtil.waitForElementPresence(By.name("password"), 2);
		eUtil.doSendKeys(element, passWord);
	}

	public void clickLoginButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space(text())='Login']"), 2);
		js.doJsClick(element);
	}

	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement successMessageEl;

	public void setUserNamePasswordAndLogin(String userName, String password) throws Exception {
		try {
			WaitForCompanyLogo();
			setUserName(userName);
			setPassword(password);
			clickLoginButton();
			if (isErrorSuccessMessageDisplayed()) {
				throw new Exception(getConfirmationMessage());
			}
			if (isMultiLoginPopupDisplayed()) {
				clickMultiLoginYesButton();
				Thread.sleep(2000);
				clickLoginButton();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getConfirmationMessage() throws InterruptedException {
		WebElement element = eUtil.waitForElementVisible(successMessageEl, 10);
		return eUtil.doGetElementText(element);
	}

	public boolean isErrorSuccessMessageDisplayed() throws InterruptedException {
		Thread.sleep(500);
		return eUtil.isElementDisplayed(successMessageEl);
	}

	public boolean isMultiLoginPopupDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		return eUtil.isElementDisplayed(multipleLoginPopup);
	}

	@FindBy(xpath = "//p-dialog//span[text()='Multiple Login']")
	WebElement multipleLoginPopup; // multiple login popup

	@FindBy(xpath = "//p-dialog//span[contains(text(),'Yes')]")
	WebElement multipleLoginPopupYesButton; // multiple login popup yes button

	public void clickMultiLoginYesButton() {
		WebElement element = eUtil.waitForElementVisible(multipleLoginPopupYesButton, 1);
		js.doJsClick(element);
	}

	public void clickAddButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("(//mat-icon[@id='add'])[1]"), 5);
		js.doJsClick(element);
	}

	public void selectMaterialType(String text) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//p-select[@formcontrolname='materialtype']"), 10);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementPresence(By.xpath("//li[normalize-space()='" + text + "']"), 10);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void setCode(String materialCode) {
		if (eUtil.isElementDisplayed(By.xpath("//span[@class='material-symbols-sharp']"))) {
			WebElement element = eUtil.waitForElementPresence(By.xpath("//span[@class='material-symbols-sharp']"), 2);
			js.doJsClick(element);
		} else {
			WebElement element1 = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='materialcode']"), 2);
			eUtil.doSendKeys(element1, materialCode);

		}

	}

	public String getMaterialCode() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='materialcode']"), 5);
		return js.doGetText(element);
	}

	public void setMaterialName(String materialName) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='materialname']"), 2);
		eUtil.doSendKeys(element, materialName);
	}

	public void setAbbreviation(String abbreviation) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='materialshortcode']"), 2);
		eUtil.doSendKeys(element, abbreviation);

	}

	public void selectUOM(String text) {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//strong[text()=' UOM :']/following::p-select[1]"),
				20);
		js.doJsClick(element);

		WebElement element1 = eUtil.waitForElementClickable(By.xpath("//li[normalize-space()='" + text + "']"), 20);
		js.scrollIntoView(element1);
		js.doJsClick(element1);
	}

	public void setAlertLevel(String alertLevel) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='alertlevel']"), 5);
		eUtil.doSendKeys(element, alertLevel);

	}

	public void setTechGrade(String techGrade) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='technicalgrade']"), 5);
		eUtil.doSendKeys(element, techGrade);
	}

	public void setStorageCondition(String storageCondition) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='storagecondition']"), 5);
		eUtil.doSendKeys(element, storageCondition);
	}

	public void setSpecification(String specification) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='specification']"), 5);
		eUtil.doSendKeys(element, specification);
	}

	public void clickHazardousCheckBox() {
		WebElement element = eUtil.waitForElementClickable(By.xpath("//mat-checkbox[@formcontrolname='hazardous']"), 5);
		js.doJsClick(element);

	}

	public void setDescription(String description) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='description']"), 5);
		eUtil.doSendKeys(element, description);
	}

	public void setPrecaution(String precaution) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//textarea[@formcontrolname='precautions']"), 5);
		eUtil.doSendKeys(element, precaution);
	}

	public void clickSaveButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='Save']"), 5);
		js.doJsClick(element);

	}
	
	public void clickChemicalProperties() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Chemical properties']"), 5);
		js.doJsClick(element);
	}
	
	public void clickFormulationProperties() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//img[@mattooltip='Formulation properties']"), 5);
		js.doJsClick(element);
	}
	
	public void setCasNo(String casNo) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='CasNo']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, casNo);
	}
	
	public void setFormula(String formula) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='Formula']"), 5);
		eUtil.doClear(element);
		Thread.sleep(1000);
		eUtil.doSendKeys(element, formula);
	}
	
	
	public void setMolecularWeight(String molecularWeight) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='MolecularWeight']"), 5);
		eUtil.doClear(element);
		Thread.sleep(1000);
		eUtil.doSendKeys(element, molecularWeight);
	}
	
	
	public void setDensity(String density) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='Density']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, density);
	}
	
	
	public void setBoilingPointLR(String boilingPointLR) throws InterruptedException {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='BoilingpointLR']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, boilingPointLR);
	}
	
	
	public void setBoilingPointUR(String boilingPointUR) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='BoilingpointUR']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, boilingPointUR);
	}
	
	public void setMeltingPointLR(String meltingPointLR) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='MeltingpointLR']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, meltingPointLR);
	}
	public void setMeltingPointUR(String meltingPointUR) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='MeltingpointUR']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, meltingPointUR);
	}
	
	public void setTherapeuticFunction(String therapeuticFunction) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='TherapeuticFunction']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, therapeuticFunction);
	}
	
	public void setIUmcgFactor(String IUmcgFactor) {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//input[@formcontrolname='IUmcgFactor']"), 5);
		eUtil.doClear(element);
		eUtil.doSendKeys(element, IUmcgFactor);
	}
	

	

	public void clickCancelButton() {
		WebElement element = eUtil.waitForElementPresence(By.xpath("//button[normalize-space()='Cancel']"), 5);
		js.doJsClick(element);
	}

	@FindBy(xpath = "//input[@name='username']/preceding::img[@class='dark-logo' and contains(@src,'http')]")
	private WebElement companyLogo;

	public void WaitForCompanyLogo() {
		eUtil.waitForElementVisible(companyLogo, 30);
	}

}
