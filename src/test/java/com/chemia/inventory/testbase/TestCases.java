package com.chemia.inventory.testbase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.chemia.LabInventory.constants.AppConstants;
import com.chemia.inventory.listeners.ExtentListeners;
import com.chemia.inventory.pageobject.HomePage;
import com.chemia.inventory.utilities.ExcelUtility;

@Listeners(ExtentListeners.class)
public class TestCases extends BaseClass {

	public ExcelUtility excelUtil;
	public String materialName="mat123";
	public String vendorName = "Honour Lab";
	public String materialCode = "MAT/25/100175";
	public String columnNumber = "";
	public String equipmentTypeData;
	public String instrumentTypeData;
	public String columnNameData;
	public String batchNumberData;
	public String EquipmentCodeData;
	public String InstrumentCodeData;

	public TestCases() {
		excelUtil = new ExcelUtility("C://Automation//Chemia//Chemia 5.1//Chemia_Lie//testData//Automation-Sheet.xlsx");
	}

	public void loggingIntoApplication(String username) throws Exception {
		login(username);
		homePage.clickLIE();
		homePage.clickHamIcon();
	}

	public void loggingIntoStoreInchargeApplication(String username) throws Exception {
		login(username);
		homePage.clickHamIcon();
	}

	public void loggingIntoARDModule(String username) throws Exception {
		login(username);
		homePage.clickARD();
	}

	@Test(priority = 1)
	public void TC01_AddMaterial() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication("obul-cpl-ard-analyst");
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickInvMasterData();
			homePage.clickMaterialMenu();
			homePage.waitForLoaderRemoval();
			materialPage.clickAddButton();
			Thread.sleep(2000);
			homePage.waitForLoaderRemoval();
			materialPage.selectMaterialType(excelUtil.getCellData("Material", 1, 0));
			materialPage.setCode("materialCode" + randomString());
			materialName = excelUtil.getCellData("Material", 0, 0) + randomString();
			materialPage.setMaterialName(materialName);
			System.out.println(materialPage.getMaterialCode());
			materialCode = materialPage.getMaterialCode();
			materialPage.setAbbreviation(excelUtil.getCellData("Material", 1, 2));
			materialPage.selectUOM(excelUtil.getCellData("Material", 1, 4));
			materialPage.setAlertLevel(excelUtil.getCellData("Material", 1, 5));
			materialPage.setTechGrade(excelUtil.getCellData("Material", 1, 6));
			materialPage.setStorageCondition(excelUtil.getCellData("Material", 1, 7));
			materialPage.setSpecification(excelUtil.getCellData("Material", 1, 8));
			materialPage.clickHazardousCheckBox();
			materialPage.setDescription(excelUtil.getCellData("Material", 1, 10));
			materialPage.setPrecaution(excelUtil.getCellData("Material", 1, 11));
			materialPage.clickSaveButton();
			homePage.waitForLoaderRemoval();
			
			
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval();
			addBatch.clickSearchbar(materialCode);
			materialPage.clickChemicalProperties();
			homePage.waitForLoaderRemoval();
			materialPage.setCasNo(excelUtil.getCellData("Chemical and Formulation", 1, 0));
			materialPage.setFormula(excelUtil.getCellData("Chemical and Formulation", 1, 1));
			materialPage.setMolecularWeight(excelUtil.getCellData("Chemical and Formulation", 1, 2));
			materialPage.setDensity(excelUtil.getCellData("Chemical and Formulation", 1, 3));
			materialPage.setBoilingPointLR(excelUtil.getCellData("Chemical and Formulation", 1, 4));
			materialPage.setBoilingPointUR(excelUtil.getCellData("Chemical and Formulation", 1, 5));
			materialPage.setMeltingPointLR(excelUtil.getCellData("Chemical and Formulation", 1, 6));
			materialPage.setMeltingPointUR(excelUtil.getCellData("Chemical and Formulation", 1, 7));
			materialPage.clickSaveButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			
			
			materialPage.clickFormulationProperties();
			homePage.waitForLoaderRemoval();
			materialPage.setTherapeuticFunction(excelUtil.getCellData("Chemical and Formulation", 1, 9));
			materialPage.setIUmcgFactor(excelUtil.getCellData("Chemical and Formulation", 1, 10));
			materialPage.clickSaveButton();
			homePage.waitForLoaderRemoval();
			//Disable
			addBatch.clickSearchbar(materialCode);
			addBatch.clickResultantActionsIcon(materialCode);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			addBatch.clickDisableYesButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			addBatch.clickSearchbar(materialCode);
			addBatch.clickResultantActionsIcon(materialCode);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 2)
	public void TC02_AddVendor() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication("obul-cpl-ard-analyst");
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickInvMasterData();
			homePage.clicKVendorsMenu();
			homePage.waitForLoaderRemoval();
			vendorPage.clickAddButton();
			homePage.waitForLoaderRemoval();
			vendorName = excelUtil.getCellData("Vendor", 0, 0) + randomString();
			vendorPage.setVendorName(vendorName);
			vendorPage.clickVendorCodeAddButton("vendorName" + randomString());
			vendorName = vendorPage.getVendorName();
			vendorPage.setDescripiton(excelUtil.getCellData("Vendor", 0, 2));
			vendorPage.clickSaveButton();
			homePage.waitForLoaderRemoval();
			// vendorPage.clickCancelButton();
			
			//Disable
			addBatch.clickSearchbar(vendorName);
			addBatch.clickResultantActionsIcon(vendorName);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			addBatch.clickDisableYesButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			addBatch.clickSearchbar(vendorName);
			addBatch.clickResultantActionsIcon(vendorName);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval();
			
		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 3)
	public void TC03_VendorMapping() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication("obul-cpl-ard-analyst");
			homePage.waitForLoaderRemoval();
			homePage.clickInvMasterData();
			homePage.clickVendorMapping();
			homePage.waitForLoaderRemoval();
			vendorMapping.clickAddButton();
			materialPage.waitForLoaderRemoval();
			vendorMapping.setMaterialCode(materialCode);      //materialCode- while executing all 
			vendorMapping.setVendorNameSearch(vendorName);    //vendorName-while executing all
			homePage.waitForLoaderRemoval();
			Thread.sleep(2000);
			vendorMapping.clickSearchButton();
			vendorMapping.clickReqVendorCheckbox(vendorName);
			vendorMapping.clickSaveButton();
			homePage.waitForLoaderRemoval();
			// vendorMapping.clickCancelButton();
			Thread.sleep(5000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 4)
	public void TC04_InvMasterDataAuditTrail() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication("obul-cpl-ard-analyst");
			homePage.waitForLoaderRemoval();
			homePage.clickInvMasterData();
			homePage.clickInvMasterAuditTrail();
			inventoryMasterDataAuditTrail.clickGoButton();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 5)
	public void Tc05_AddingEquipmentType() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication("obul-cpl-ard-analyst");
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipMasterDataMenu();
			homePage.clickEquipTypeSubMenu();
			homePage.waitForLoaderRemoval();
			Thread.sleep(2000);
			equipType.clickAddButton();
			Thread.sleep(1000);
			equipmentTypeData = excelUtil.getCellData("Equipment Type", 1, 1) + randomString();
			equipType.setEquipmentType(equipmentTypeData);
			equipType.selectMovable();
			equipType.setDescription(excelUtil.getCellData("Equipment Type", 1, 2));
			Thread.sleep(3000);
			equipType.clickSaveButton();
			homePage.waitForLoaderRemoval();
			// equipType.clickCancelButton();

			
			//Disable
			addBatch.clickSearchbar(equipmentTypeData);
			addBatch.clickResultantActionsIcon(equipmentTypeData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			addBatch.clickDisableYesButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			addBatch.clickSearchbar(equipmentTypeData);
			addBatch.clickResultantActionsIcon(equipmentTypeData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval();


		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 6)
	public void Tc06_AddingInstrumentType() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipMasterDataMenu();
			homePage.clickInstrumentTypeSubMenu();
			homePage.waitForLoaderRemoval();
			Thread.sleep(2000);
			instrumentType.clickAddButton();
			instrumentTypeData = excelUtil.getCellData("Instrument Type", 1, 1) + randomString();
			instrumentType.setInstrumentType(instrumentTypeData);
			instrumentType.selectMovable();
			instrumentType.setDescription(excelUtil.getCellData("Instrument Type", 1, 2));
			Thread.sleep(3000);
			instrumentType.clickSaveButton();
			homePage.waitForLoaderRemoval();
			// instrumentType.clickCancelButton();
			
			//Disable
			addBatch.clickSearchbar(instrumentTypeData);
			addBatch.clickResultantActionsIcon(instrumentTypeData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			addBatch.clickDisableYesButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			addBatch.clickSearchbar(instrumentTypeData);
			addBatch.clickResultantActionsIcon(instrumentTypeData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval(); 	

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 7)
	public void Tc07_AddColumnType() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipMasterDataMenu();
			homePage.clickColumnTypeSubMenu();
			homePage.waitForLoaderRemoval();
			columnType.clickAddButton();
			columnNameData = excelUtil.getCellData("Column Type", 1, 1) + randomString();
			columnType.setColumnName(columnNameData);
			columnType.setDescription(excelUtil.getCellData("Column Type", 1, 1));
			columnType.selectLength(excelUtil.getCellData("Column Type", 1, 3));
			columnType.selectParticleSize(excelUtil.getCellData("Column Type", 1, 4));
			columnType.selectPoreSize(excelUtil.getCellData("Column Type", 1, 5));
			Thread.sleep(1000);
			columnType.selectfilmThickness(excelUtil.getCellData("Column Type", 1, 6));
			columnType.selectInnerDiameter(excelUtil.getCellData("Column Type", 1, 7));
			columnType.selectOuterDiameter(excelUtil.getCellData("Column Type", 1, 8));
			columnType.seRemarks(excelUtil.getCellData("Column Type", 1, 9));
			columnType.clickSaveButton();
			homePage.waitForLoaderRemoval();
			// columnType.clickCancelButton();
			Thread.sleep(2000);			
			
			//Disable
			Thread.sleep(2000);
			addBatch.clickSearchbar(columnNameData);
			addBatch.clickResultantActionsIcon(columnNameData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			addBatch.clickDisableYesButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			addBatch.clickSearchbar(columnNameData);
			addBatch.clickResultantActionsIcon(columnNameData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			homePage.waitForLoaderRemoval(); 	

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 8)
	public void Tc_08_EquipMasterDataAuditTrail() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipMasterDataMenu();
			homePage.clickEquipMasterDataAuditTrailSubMenu();
			homePage.waitForLoaderRemoval();
			equipMasterDataAuditTrail.clickGoButton();
			Thread.sleep(2000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 9)
	public void Tc09_AddBatch() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickHomePageButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickInventoryBatchMenu();
			homePage.clickAvailableStockSubMenu();
			homePage.waitForLoaderRemoval();
			addBatch.clickAddButton();
			homePage.waitForLoaderRemoval();
			addBatch.setMaterialCode(materialCode);     //add materialCode while executing whole
			addBatch.selectVendorName(vendorName);      //add vendorName while executing whole
			batchNumberData = (excelUtil.getCellData("Add Batch", 1, 1)) + randomString();
			addBatch.setBatchNumber(batchNumberData);
			addBatch.selectReceivedQuantity(excelUtil.getCellData("Add Batch", 1, 2));
			addBatch.selectManufacturerDate(getTodayDateNum());
			Thread.sleep(1000);
			addBatch.selectExpiryDate(getTodayDateNum());
			addBatch.setLocation(excelUtil.getCellData("Add Batch", 1, 3));
			addBatch.selectRetestDate(getTommorrowsDate());
			addBatch.setManufacturer(excelUtil.getCellData("Add Batch", 1, 4));
			addBatch.setPrice(excelUtil.getCellData("Add Batch", 1, 5));
			addBatch.selectReceivedBy(excelUtil.getCellData("Add Batch", 1, 6));
			addBatch.setPurityAsIsBasis(excelUtil.getCellData("Add Batch", 1, 7));
			addBatch.selectReceivedDate(getTodayDateNum());
			addBatch.setPurityOnAnhydrous(excelUtil.getCellData("Add Batch", 1, 8));
			addBatch.uploadFile(AppConstants.PDF);
			addBatch.setBatchRemarks(excelUtil.getCellData("Add Batch", 1, 9));
			addBatch.clickSaveButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(5000);
			addBatch.clickSearchbar(batchNumberData);   //batchNumberData- Replace while executing all
			addBatch.clickResultantActionsIcon(batchNumberData);  //batchNumberData- Replace while executing all
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 12));
			homePage.waitForLoaderRemoval();
			addBatch.clickDisableYesButton();
			Thread.sleep(2000);
			homePage.waitForLoaderRemoval();
			addBatch.clickSearchbar(batchNumberData);
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 13));
			homePage.waitForLoaderRemoval();
			
			addBatch.clickActionsOptn(excelUtil.getCellData("Add Batch", 1, 10));
			Thread.sleep(1000);
			addBatch.setComments(excelUtil.getCellData("Add Batch", 1, 11));
			addBatch.clickViewAttachment();
			addBatch.closeViewAttachmentPopup();
			addBatch.clickEditSubmitButton();
			Thread.sleep(1000);
			addBatch.setAuthentication(excelUtil.getCellData("Login Credentials", 1, 2));
			addBatch.clickFinalSubmit();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);
			

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 10)
	public void Tc10_AddEquipmentCatalogue() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickEquipmentCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			addEquipmentCatalogue.clickAddButton();
			homePage.waitForLoaderRemoval();
			addEquipmentCatalogue.selectEquipType(excelUtil.getCellData("Add Equipment", 1, 1));
			Thread.sleep(2000);
			EquipmentCodeData = excelUtil.getCellData("Add Equipment", 1, 2) + randomString();
			addEquipmentCatalogue.setEquipmentCode(EquipmentCodeData);
			addEquipmentCatalogue.setEquipmentName(excelUtil.getCellData("Add Equipment", 1, 3));
			addEquipmentCatalogue.setManufacturer(excelUtil.getCellData("Add Equipment", 1, 4));
			addEquipmentCatalogue.setModel(excelUtil.getCellData("Add Equipment", 1, 5));
			addEquipmentCatalogue.setSerialNumber(excelUtil.getCellData("Add Equipment", 1, 6));
			addEquipmentCatalogue.setLocation(excelUtil.getCellData("Add Equipment", 1, 7));
			addEquipmentCatalogue.setGrossCapacity(excelUtil.getCellData("Add Equipment", 1, 8));
			addEquipmentCatalogue.selectCapacityUnit("Celsius");
			addEquipmentCatalogue.selectMaintenanceType("INTERNAL");
			addEquipmentCatalogue.setMainFrequency("10");
			addEquipmentCatalogue.setCriticalityLevel("HIGH");
			addEquipmentCatalogue.clickLastMainDate(getTodayDateNum());
			Thread.sleep(2000);
			addEquipmentCatalogue.clickMainDueDate(getTommorrowsDate());
			addEquipmentCatalogue.setDescription(excelUtil.getCellData("Add Equipment", 1, 15));
			addBatch.uploadFile(AppConstants.PDF);
			addEquipmentCatalogue.clickSaveButton();
			homePage.waitForLoaderRemoval();
			addSpecification.clickSpecificationTab();
			homePage.waitForLoaderRemoval();
			addSpecification.clickAddButton();
			addSpecification.setSpecificationName("12334");
			addSpecification.setSpecificationValue("1234");
			addSpecification.clickSpecificationUnit();
			addSpecification.clickSaveButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			
			
			
			addInstrumentCatalogue.clickEquipmentInstrumentTab();
			homePage.waitForLoaderRemoval();
			addInstrumentCatalogue.clickEquipmentInstrumentAddButton();
			homePage.waitForLoaderRemoval();
			addInstrumentCatalogue.selectInsType(excelUtil.getCellData("Add Instrument", 1, 1));
			InstrumentCodeData = excelUtil.getCellData("Add Instrument", 1, 2) + randomString();
			addInstrumentCatalogue.setInstrumentCode(InstrumentCodeData);
			addInstrumentCatalogue.setInstrumentName(excelUtil.getCellData("Add Instrument", 1, 3));
			addInstrumentCatalogue.setManufacturer(excelUtil.getCellData("Add Instrument", 1, 4));
			addInstrumentCatalogue.setModel(excelUtil.getCellData("Add Instrument", 1, 5));
			addInstrumentCatalogue.setSerialNumber(excelUtil.getCellData("Add Instrument", 1, 6));
			addInstrumentCatalogue.setLowerOperatingRange(excelUtil.getCellData("Add Instrument", 1, 7), "Celsius");
			addInstrumentCatalogue.setUpperOperatingRange(excelUtil.getCellData("Add Instrument", 1, 8), "Celsius");
			addInstrumentCatalogue.setGrossCapacity(excelUtil.getCellData("Add Instrument", 1, 10), "Celsius");
			addInstrumentCatalogue.setCalibrationFrequency(excelUtil.getCellData("Add Instrument", 1, 11));
			//addInstrumentCatalogue.checkHasColumn();
			addInstrumentCatalogue.selectCalibrationType("INTERNAL");
			addInstrumentCatalogue.setDescription(excelUtil.getCellData("Add Instrument", 1, 13));
			Thread.sleep(3000);
			addInstrumentCatalogue.clickLastCalibrationDate(getTodayDateNum());
			addInstrumentCatalogue.clickNextCalibrationDueDate(getTommorrowsDate());
			addBatch.uploadFile(AppConstants.PDF);
			addInstrumentCatalogue.clickEquipmentInstrumentSaveButton();
			//addInstrumentCatalogue.clickSubmitButton();
			Thread.sleep(3000);
			addEquipmentCatalogue.clickLogtab();
			addEquipmentCatalogue.clickEquipmentLogGoButton();
			Thread.sleep(5000);
			
			addEquipmentCatalogue.clickSummaryTab();
			homePage.waitForLoaderRemoval();
			addEquipmentCatalogue.clickFinalEquipmentSubmit();
			Thread.sleep(3000);
			addEquipmentCatalogue.setAuthenticationDetails(excelUtil.getCellData("Login Credentials", 1, 2));
			addEquipmentCatalogue.clickFinalEquipmentConfirm();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			
			

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 11)
	public void Tc11_AddInstrumentCatalogue() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickHomePageButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickInstrumentCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			addInstrumentCatalogue.clickAddButton();
			homePage.waitForLoaderRemoval();
			addInstrumentCatalogue.selectInsType(excelUtil.getCellData("Add Instrument", 1, 1));
			InstrumentCodeData = excelUtil.getCellData("Add Instrument", 1, 2) + randomString();
			addInstrumentCatalogue.setInstrumentCode(InstrumentCodeData);
			addInstrumentCatalogue.setInstrumentName(excelUtil.getCellData("Add Instrument", 1, 3));
			addInstrumentCatalogue.setManufacturer(excelUtil.getCellData("Add Instrument", 1, 4));
			addInstrumentCatalogue.setModel(excelUtil.getCellData("Add Instrument", 1, 5));
			addInstrumentCatalogue.setSerialNumber(excelUtil.getCellData("Add Instrument", 1, 6));
			addInstrumentCatalogue.setLowerOperatingRange(excelUtil.getCellData("Add Instrument", 1, 7), "Celsius");
			addInstrumentCatalogue.setUpperOperatingRange(excelUtil.getCellData("Add Instrument", 1, 8), "Celsius");
			addInstrumentCatalogue.setGrossCapacity(excelUtil.getCellData("Add Instrument", 1, 10), "Celsius");
			addInstrumentCatalogue.setCalibrationFrequency(excelUtil.getCellData("Add Instrument", 1, 11));
			addInstrumentCatalogue.checkHasColumn();
			addInstrumentCatalogue.selectCalibrationType("INTERNAL");
			addInstrumentCatalogue.setDescription(excelUtil.getCellData("Add Instrument", 1, 13));
			Thread.sleep(3000);
			addInstrumentCatalogue.clickLastCalibrationDate(getTodayDateNum());
			addInstrumentCatalogue.clickNextCalibrationDueDate(getTommorrowsDate());
			addInstrumentCatalogue.clickLastMainDate(getTodayDateNum());
			addInstrumentCatalogue.clickMainDueDate(getTommorrowsDate());
			addBatch.uploadFile(AppConstants.PDF);
			addInstrumentCatalogue.clickEquipmentInstrumentSaveButton();
			Thread.sleep(3000);
			
			homePage.waitForLoaderRemoval();
			addSpecification.clickSpecificationTab();
			homePage.waitForLoaderRemoval();
			addSpecification.clickAddButton();
			addSpecification.setSpecificationName("12334");
			addSpecification.setSpecificationValue("1234");
			addSpecification.clickSpecificationUnit();
			addSpecification.clickSaveButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			addInstrumentCatalogue.clickInstrumentLogTab();
			addEquipmentCatalogue.clickEquipmentLogGoButton();
			Thread.sleep(5000);
			
			addEquipmentCatalogue.clickSummaryTab();
			homePage.waitForLoaderRemoval();
			addEquipmentCatalogue.clickFinalEquipmentSubmit();
			Thread.sleep(3000);
			addEquipmentCatalogue.setAuthenticationDetails(excelUtil.getCellData("Login Credentials", 1, 2));
			addEquipmentCatalogue.clickFinalEquipmentConfirm();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
					
			
		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 12)
	public void Tc12_AddColumnCatalogue() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickHamIcon();
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickColumnCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			addColumnCatalogue.clickAddButton();
			homePage.waitForLoaderRemoval();
			addColumnCatalogue.selectColumnName(excelUtil.getCellData("Add Column", 1, 1));
			addColumnCatalogue.selectCategory(excelUtil.getCellData("Add Column", 1, 2));
			addColumnCatalogue.selectColumnNumber("columnNumber"+randomString());
			addColumnCatalogue.setManufacturer(excelUtil.getCellData("Add Column", 1, 3));
			columnNumber = addColumnCatalogue.getColumnNumber();
			addColumnCatalogue.setSerialNumber(excelUtil.getCellData("Add Column", 1, 4));
			addColumnCatalogue.setPartNo(excelUtil.getCellData("Add Column", 1, 5));
			addColumnCatalogue.setColumnPoNumber(excelUtil.getCellData("Add Column", 1, 6));
			addColumnCatalogue.selectType(excelUtil.getCellData("Add Column", 1, 7));
			addColumnCatalogue.setColumnDescription(excelUtil.getCellData("Add Column", 1, 8));
			addColumnCatalogue.selectQualificationStatus();
			addColumnCatalogue.selectReceivedBy(excelUtil.getCellData("Add Column", 1, 9));
			addColumnCatalogue.selectReceivedOn(getTodayDateNum());
			Thread.sleep(1000);
			addColumnCatalogue.selectActivatedBy(excelUtil.getCellData("Add Column", 1, 10));
			addColumnCatalogue.selectActivatedOn(getTodayDateNum());
			addColumnCatalogue.setMaxInjections(excelUtil.getCellData("Add Column", 1, 11));
			addColumnCatalogue.setCumulativeInjections(excelUtil.getCellData("Add Column", 1, 12));
			addColumnCatalogue.setRemarks(excelUtil.getCellData("Add Column", 1, 13));
			Thread.sleep(4000);
			addBatch.uploadFile(AppConstants.PDF);
			addColumnCatalogue.clickSubmitButton();
			addColumnCatalogue.setAuthenticationRemarks(excelUtil.getCellData("Authentication Data", 1, 1));
			addColumnCatalogue.setPassword(excelUtil.getCellData("Login Credentials", 1, 2));
			addColumnCatalogue.clickConfirmButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(5000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 13)
	public void Tc13_chemicalUsageReport() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
		//	loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickHamIcon();
			homePage.clickReportingMenu();
			homePage.clickChemicalConsumptionSubMenu();
			chemicalConsumptionReport.clickGoButton();
			Thread.sleep(2000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 14)
	public void Tc14_EquipmentAndInstrumentUsageReport() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			//loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickHomePageButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickReportingMenu();
			homePage.clickEquipmentInstrumentUsageReportsSubMenu();
			homePage.waitForLoaderRemoval();
			equipmentAndInstrumentUsageReport.clickEquipmentTab();
			equipmentAndInstrumentUsageReport.clickEquipmentGoButton();
			Thread.sleep(3000);
			homePage.waitForLoaderRemoval();
			equipmentAndInstrumentUsageReport.clickInstrumentTab();
			equipmentAndInstrumentUsageReport.clickInstrumentGoButton();
			Thread.sleep(5000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 15)
	public void Tc15_columnUsageReport() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
		//	loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickReportingMenu();
			homePage.clickColumnUsageReportsSubMenu();
			homePage.waitForLoaderRemoval();
			columnUsageReport.clickGoButton();
			Thread.sleep(3000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}
	

	@Test(priority = 16, dependsOnMethods = { "Tc09_AddBatch" })
	public void Tc16_VerifyBatch() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
			homePage.clickBatchRequestTab();
			Thread.sleep(2000);
			verifyBatch.setSearchBar(batchNumberData);  //Change to batchNumberData
			Thread.sleep(2000);
			verifyBatch.clickVerifyButton();
			Thread.sleep(2000);
			verifyBatch.setRemarks("Verified");
			verifyBatch.setPassword("Chemia@1234");
			Thread.sleep(2000);
			verifyBatch.clickConfirmButton();
			Thread.sleep(2000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 17
			//, dependsOnMethods = { "Tc10_AddEquipmentCatalogue" }
			)
	public void Tc17_VerifyEquipment() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
			homePage.clickEquipmentVerificationTab();
			Thread.sleep(2000);
			verifyBatch.setSearchBar(EquipmentCodeData);   //
			Thread.sleep(2000);
			verifyBatch.clickVerifyButton();
			Thread.sleep(2000);
			verifyBatch.setRemarks(excelUtil.getCellData("Authentication Data", 2, 1));
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 2, 2));
			Thread.sleep(2000);
			verifyBatch.clickConfirmButton();
			Thread.sleep(5000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 18
			//, dependsOnMethods = { "Tc11_AddInstrumentCatalogue" }
			)
	public void Tc18_VerifyInstrument() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
		loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
			homePage.clickInstrumentVerificationTab();
			Thread.sleep(2000);
			verifyBatch.setSearchBar(InstrumentCodeData);
			Thread.sleep(2000);
			verifyBatch.clickVerifyButton();
			Thread.sleep(2000);
			verifyBatch.setRemarks(excelUtil.getCellData("Authentication Data", 2, 1));
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 2, 2));
			Thread.sleep(2000);
			verifyBatch.clickConfirmButton();
			Thread.sleep(5000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 19
			//, dependsOnMethods = { "Tc12_AddColumnCatalogue" }
			)
	public void Tc19_VerifyColumn() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));			homePage.clickColumnVerificationTab();
			Thread.sleep(2000);
			verifyBatch.setSearchBar(columnNameData);
			Thread.sleep(2000);
			verifyBatch.clickVerifyButton();
			Thread.sleep(2000);
			verifyBatch.setRemarks(excelUtil.getCellData("Authentication Data", 2, 1));
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 2, 2));
			Thread.sleep(2000);
			verifyBatch.clickConfirmButton();
			Thread.sleep(5000);
			homePage.waitForLoaderRemoval();

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	

	@Test(priority = 24
			//, dependsOnMethods = {"Tc10_AddEquipmentCatalogue","Tc17_VerifyEquipment"}
	)
	public void Tc24_startMaintenance() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickEquipmentCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			addMaintenance.setEquipmentCode("Equip CodeHOtNq");
			addMaintenance.clickEquipmentCode();
			addMaintenance.clickEquipmentTab();
			addMaintenance.clickAddButton();
			Thread.sleep(10000);
			addMaintenance.selectMaintenanceCategory();
			Thread.sleep(10000);
			addMaintenance.clickStartButton();
			Thread.sleep(3000);
			addMaintenance.clickEndButton();
			addMaintenance.selectEndTime(getTodayDateNum());
			addMaintenance.setRemarks("Remarks are added!!!");
			addMaintenance.selectNextDueDate(getTommorrowsDateForEquipmentEnd(), getTodayDateNum());
			Thread.sleep(5000);
			addMaintenance.clickStartButton();
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 26
			//, dependsOnMethods = {"Tc10_AddEquipmentCatalogue","Tc17_VerifyEquipment", "Tc24_startMaintenance"}
			)
			public void Tc26_ReviewMaintenance() throws Exception {
				SoftAssert sa = new SoftAssert();
				try {
					loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
					homePage.clickEquipmentCatalogueMenu();
					homePage.clickReviewMaintenanceSubMenu();
					homePage.waitForLoaderRemoval();
					Thread.sleep(2000);
					verifyEquipment.setSearchBar("Equip CodedTnZm");  //equipmentCode
					addBatch.clickResultantActionsIcon("Equip CodedTnZm");  //equipmentCode
					addBatch.clickActionsOptn("Verify");
					Thread.sleep(5000);
					verifyEquipment.setRemarks("Maintenance is Reviewed");
					verifyBatch.setPassword("Chemia@1234");
					verifyBatch.clickConfirmButton();	
					Thread.sleep(5000);		
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	
	
	@Test(priority = 30
			//, dependsOnMethods = {"Tc11_AddInstrumentCatalogue","Tc17_VerifyInstrument", "Tc24_startCalibration"}
			)
			public void Tc30_ReviewCalibration() throws Exception {
				SoftAssert sa = new SoftAssert();
				try {
					loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
					homePage.clickEquipmentCatalogueMenu();
					homePage.clickReviewCalibrationSubMenu();
					homePage.waitForLoaderRemoval();
					Thread.sleep(2000);
					verifyEquipment.setSearchBar("Equip/Hplc/01");  //equipmentCode
					addBatch.clickResultantActionsIcon("Equip/Hplc/01");  //equipmentCode
					addBatch.clickActionsOptn("Verify");
					Thread.sleep(5000);
					verifyEquipment.setRemarks("Calibration is Reviewed");
					verifyBatch.setPassword("Chemia@1234");
					verifyBatch.clickConfirmButton();	
					Thread.sleep(5000);		
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}	
	
	
	
	
	

	
	
	@Test(priority = 25)
	public void Tc25_startCalibration() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickInstrumentCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			addCalibration.setInstrumentCode("Instrument CodesQNmB");
			addCalibration.clickInstrumentCode();
			addCalibration.clickCalibrationTab();
			 addCalibration.clickAddButton();
			 addCalibration.selectCalibrationCategory();
			 Thread.sleep(1000);
			 addCalibration.clickStartButton();
			 Thread.sleep(3000);
			addCalibration.clickEndButton();
			addCalibration.selectEndTime(getTodayDateNum());
			addCalibration.setRemarks("Remarks are added!!!");
			addCalibration.selectNextDueDate(getTommorrowsDateForEquipmentEnd(), getTodayDateNum());
			Thread.sleep(5000);
			addMaintenance.clickStartButton();
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
		

	
	public void Tc27_addInstrumentSpecification() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickEquipmentCatalogueMenu();
			homePage.clickEquipmentCatalogueSubMenu();
			homePage.waitForLoaderRemoval();
			addMaintenance.setEquipmentCode(InstrumentCodeData);
			addMaintenance.clickEquipmentCode();
			homePage.waitForLoaderRemoval();
			addSpecification.clickSpecificationTab();
			homePage.waitForLoaderRemoval();
			addSpecification.clickAddButton();
			addSpecification.setSpecificationName("12334");
			addSpecification.setSpecificationValue("1234");
			addSpecification.clickSpecificationUnit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/*
	@Test
	public void Tc31_addLIEDataToExperiment() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoARDModule(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.waitForLoaderRemoval();
			experimentEditorPage.clickOnGoingExperimentTab();
			homePage.waitForLoaderRemoval();
			experimentEditorPage.setExperimentCode("DEMO/LIE/0001");
			Thread.sleep(2000);
			experimentEditorPage.clickExperimentCode();
			homePage.waitForLoaderRemoval();
			if(experimentEditorPage.isRestoreDisplayed());
			{
				experimentEditorPage.clickYesBtn();
			}
			homePage.waitForLoaderRemoval();
			Thread.sleep(3000);
			experimentEditorPage.clickEqDetailsAddIcon();
			Thread.sleep(2000);
			experimentEditorPage.setEquipmentType("Chromotography");
			experimentEditorPage.setEquipmentName("Equipment-Chromotography");
			experimentEditorPage.selectStartDate(getTodayDateNum());
			
			

		
			}
		
			
			
			
	 catch (Exception e) {
		System.out.println(e);
	}

}

	
	
	*/
	
	
	
	
	
	@Test(priority = 20)
	public void Tc20_requestStock() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 1, 1));
			homePage.clickInventoryBatchMenu();
			homePage.clickAvailableStockSubMenu();
			homePage.waitForLoaderRemoval();
			requestStock.clickStockRequestButton();
			homePage.waitForLoaderRemoval();
			requestStock.selectMaterialType(excelUtil.getCellData("Material", 1, 0));
			materialCode = materialCode + randomString();
			requestStock.setCode(materialCode); // Replace with materialCode
			requestStock.setMaterialName("mat123"); // Replace with materialName
			requestStock.setTechGrade(excelUtil.getCellData("Material", 1, 6));
			vendorPage.setVendorName(vendorName); // Replace with vendorName
			materialCode = requestStock.getCode();
			requestStock.selectRequiredQuantity("1");
			requestStock.setLab("Lab-01");
			requestStock.selectCriticality();
			requestStock.setBatchRemarks(excelUtil.getCellData("Add Batch", 1, 9));
			BaseClass.getBase64Screenshot();
			requestStock.clickSubmit();
			homePage.waitForLoaderRemoval();
			Thread.sleep(5000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 21, dependsOnMethods = "Tc20_requestStock")
	public void Tc21_approveBatch() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 2, 1));
			homePage.clickInventoryBatchMenu();
			homePage.clickApproveRequestSubMenu();
			homePage.waitForLoaderRemoval();
			approveBatch.setSearch(materialCode); // Replace with materialCode
			approveBatch.clickAction();
			approveBatch.clickReview();
			Thread.sleep(2000);
			verifyBatch.setRemarks("Reviewed");
			verifyBatch.setPassword("Chemia@1234");
			verifyBatch.clickConfirmButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(5000);

			loggingIntoApplication(excelUtil.getCellData("Login Credentials", 3, 1));
			homePage.clickInventoryBatchMenu();
			homePage.clickApproveRequestSubMenu();
			homePage.waitForLoaderRemoval();
			approveBatch.setSearch(materialCode); // Replace with materialCode
			approveBatch.clickAction();
			approveBatch.clickApprove();
			verifyBatch.setRemarks(excelUtil.getCellData("Authentication Data", 4, 1));
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 3, 2));
			verifyBatch.clickConfirmButton();
			homePage.waitForLoaderRemoval();
			homePage.waitForLoaderRemoval();
			Thread.sleep(10000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 22, dependsOnMethods = { "Tc20_requestStock", "Tc21_approveBatch" })
	public void Tc22_allocatingBatch() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoStoreInchargeApplication(excelUtil.getCellData("Login Credentials", 5, 1));
			homePage.clickInventoryBatchMenu();
			homePage.clickApprovedRequestSubMenu();
			allocateBatchFromStoreIncharge.setSearch(materialCode); // Make it materialCode while running all the the
																	// Test's
			allocateBatchFromStoreIncharge.clickAction();
			allocateBatchFromStoreIncharge.clickAllocate();
			allocateBatchFromStoreIncharge.clickAvailablePopupCheckBox();
			// Thread.sleep(1000);
			allocateBatchFromStoreIncharge.setIndentQuantity("1");
			allocateBatchFromStoreIncharge.clickAllocateButton(excelUtil.getCellData("Login Credentials", 3, 2));
			homePage.waitForLoaderRemoval();
			allocateBatchFromStoreIncharge.clickSubmitTick();
			Thread.sleep(3000);
		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}

	@Test(priority = 23)
	public void Tc23_allocatingNewBatch() throws Exception {
		SoftAssert sa = new SoftAssert();
		try {
			loggingIntoStoreInchargeApplication(excelUtil.getCellData("Login Credentials", 4, 1));
			homePage.waitForLoaderRemoval();
			homePage.clickInvMasterData();
			homePage.clickMaterialMenu();
			homePage.waitForLoaderRemoval();
			materialPage.clickAddButton();
			homePage.waitForLoaderRemoval();
			materialPage.selectMaterialType(excelUtil.getCellData("Material", 1, 0));
			materialPage.setCode("materialCode"+randomString());
			materialName = excelUtil.getCellData("Material", 0, 0) + randomString();
			materialPage.setMaterialName(materialName);
			System.out.println(materialPage.getMaterialCode());
			materialCode = materialPage.getMaterialCode();
			materialPage.setAbbreviation(excelUtil.getCellData("Material", 1, 2));
			materialPage.selectUOM(excelUtil.getCellData("Material", 1, 4));
			materialPage.setAlertLevel(excelUtil.getCellData("Material", 1, 5));
			materialPage.setTechGrade(excelUtil.getCellData("Material", 1, 6));
			materialPage.setStorageCondition(excelUtil.getCellData("Material", 1, 7));
			materialPage.setSpecification(excelUtil.getCellData("Material", 1, 8));
			materialPage.clickHazardousCheckBox();
			materialPage.setDescription(excelUtil.getCellData("Material", 1, 10));
			materialPage.setPrecaution(excelUtil.getCellData("Material", 1, 11));
			materialPage.clickSaveButton();
			materialPage.getConfirmationMessage();

			homePage.clickInvMasterData();
			homePage.clicKVendorsMenu();
			homePage.waitForLoaderRemoval();
			vendorPage.clickAddButton();
			homePage.waitForLoaderRemoval();
			vendorName = excelUtil.getCellData("Vendor", 0, 0) + randomString();
			vendorPage.setVendorName(vendorName);
			vendorPage.clickVendorCodeAddButton("vendorName" + randomString());
			vendorName = vendorPage.getVendorName();
			vendorPage.setDescripiton(excelUtil.getCellData("Vendor", 0, 2));
			vendorPage.clickSaveButton();
			homePage.waitForLoaderRemoval();

			homePage.waitForLoaderRemoval();
			homePage.clickInvMasterData();
			homePage.clickVendorMapping();
			homePage.waitForLoaderRemoval();
			vendorMapping.clickAddButton();
			materialPage.waitForLoaderRemoval();
			vendorMapping.setMaterialCode(materialCode);
			vendorMapping.setVendorNameSearch(vendorName);
			homePage.waitForLoaderRemoval();
			Thread.sleep(2000);
			vendorMapping.clickSearchButton();
			vendorMapping.clickReqVendorCheckbox(vendorName);
			vendorMapping.clickSaveButton();
			materialPage.getConfirmationMessage();

			homePage.waitForLoaderRemoval();
			homePage.clickInvMasterData();
			homePage.clickInvMasterAuditTrail();
			inventoryMasterDataAuditTrail.clickGoButton();
			homePage.waitForLoaderRemoval();

			homePage.clickHomePageButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickInventoryBatchMenu();
			homePage.clickAvailableStockSubMenu();
			homePage.waitForLoaderRemoval();
			addBatch.clickAddButton();
			homePage.waitForLoaderRemoval();
			addBatch.setMaterialCode(materialCode);
			addBatch.selectVendorName(vendorName);
			batchNumberData = (excelUtil.getCellData("Add Batch", 1, 1)) + randomString();
			addBatch.setBatchNumber(batchNumberData);
			addBatch.selectReceivedQuantity(excelUtil.getCellData("Add Batch", 1, 2));
			addBatch.selectManufacturerDate(getTodayDateNum());
			Thread.sleep(1000);
			addBatch.selectExpiryDate(getTommorrowsDateForEquipmentEnd());
			addBatch.setLocation(excelUtil.getCellData("Add Batch", 1, 3));
			addBatch.selectRetestDate(getTommorrowsDate());
			addBatch.setManufacturer(excelUtil.getCellData("Add Batch", 1, 4));
			addBatch.setPrice(excelUtil.getCellData("Add Batch", 1, 5));
			addBatch.selectReceivedBy("obul-inv-storeIncharge");
			addBatch.setPurityAsIsBasis(excelUtil.getCellData("Add Batch", 1, 7));
			addBatch.selectReceivedDate(getTodayDateNum());
			addBatch.setPurityOnAnhydrous(excelUtil.getCellData("Add Batch", 1, 8));
			addBatch.setBatchRemarks(excelUtil.getCellData("Add Batch", 1, 9));
			addBatch.clickSaveButton();
			
			homePage.waitForLoaderRemoval();
			Thread.sleep(5000);
			addBatch.clickSearchbar(batchNumberData);  //change to batchNumberData later
			addBatch.clickResultantActionsIcon(batchNumberData);  //change to batchNumberData later
			addBatch.clickActionsOptn("Edit");
			Thread.sleep(2000);
			addBatch.setComments("Edited");
			addBatch.clickEditSubmitButton();
			Thread.sleep(1000);
			addBatch.setAuthentication(excelUtil.getCellData("Login Credentials", 1, 2));
			addBatch.clickFinalSubmit();
			homePage.waitForLoaderRemoval();
			Thread.sleep(1000);

			loggingIntoStoreInchargeApplication(excelUtil.getCellData("Login Credentials", 5, 1));
			allocatingNewBatch.clickBatchRequest();
			homePage.waitForLoaderRemoval();
			verifyBatch.setSearchBar(batchNumberData); // Replace with batchNumberData
			Thread.sleep(2000);
			verifyBatch.clickVerifyButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(2000);
			verifyBatch.setRemarks(excelUtil.getCellData("Authentication Data", 2, 1));
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 5, 2));
			Thread.sleep(2000);
			verifyBatch.clickConfirmButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHomePageButton();
			homePage.waitForLoaderRemoval();
			homePage.clickHamIcon();
			homePage.clickInventoryBatchMenu();
			homePage.clickAvailableStockSubMenu();
			verifyBatch.setSearchBar(batchNumberData); // Replace with batchNumberData
			Thread.sleep(2000);
			allocatingNewBatch.clickActionButton();
			allocatingNewBatch.clickAllocate();
			allocatingNewBatch.selectDepartment();
			allocatingNewBatch.selectUser(excelUtil.getCellData("Login Credentials", 1, 1));
			allocatingNewBatch.setQuantity("1");
			allocatingNewBatch.setRemarks(excelUtil.getCellData("Authentication Data", 5, 1));
			Thread.sleep(5000);
			allocatingNewBatch.clickSaveButton();
			verifyBatch.setPassword(excelUtil.getCellData("Login Credentials", 5, 2));
			verifyBatch.clickConfirmButton();
			homePage.waitForLoaderRemoval();
			Thread.sleep(10000);

		} catch (Exception e) {
			sa.fail("context: " + e.getMessage());
			e.printStackTrace();
		} finally {
			sa.assertAll();
		}
	}
	
}








