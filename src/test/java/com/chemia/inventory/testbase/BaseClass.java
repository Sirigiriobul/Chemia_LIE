package com.chemia.inventory.testbase;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.chemia.inventory.listeners.ScreenshotClass;
import com.chemia.inventory.pageobject.AddBatch;
import com.chemia.inventory.pageobject.AddCalibration;
import com.chemia.inventory.pageobject.AddColumnCatalogue;
import com.chemia.inventory.pageobject.AddColumnType;
import com.chemia.inventory.pageobject.AddEquipmentCatalogue;
import com.chemia.inventory.pageobject.AddEquipmentType;
import com.chemia.inventory.pageobject.AddInstrumentCatalogue;
import com.chemia.inventory.pageobject.AddInstrumentType;
import com.chemia.inventory.pageobject.AddMaintenance;
import com.chemia.inventory.pageobject.AddSpecification;
import com.chemia.inventory.pageobject.AllocateBatchFromStoreIncharge;
import com.chemia.inventory.pageobject.AllocatingNewBatch;
import com.chemia.inventory.pageobject.ApproveBatch;
import com.chemia.inventory.pageobject.ChemicalConsumptionReport;
import com.chemia.inventory.pageobject.ColumnUsageReport;
import com.chemia.inventory.pageobject.EquipMasterDataAuditTrail;
import com.chemia.inventory.pageobject.EquipmentAndInstrumentUsageReport;
import com.chemia.inventory.pageobject.ExperimentEditorPage;
import com.chemia.inventory.pageobject.HomePage;
import com.chemia.inventory.pageobject.InvMasterDataAuditTrail;
import com.chemia.inventory.pageobject.MaterialPage;
import com.chemia.inventory.pageobject.RequestStock;
import com.chemia.inventory.pageobject.VendorMapping;
import com.chemia.inventory.pageobject.VendorPage;
import com.chemia.inventory.pageobject.VerifyBatch;
import com.chemia.inventory.pageobject.VerifyColumn;
import com.chemia.inventory.pageobject.VerifyEquipment;
import com.chemia.inventory.pageobject.VerifyInstrument;

public class BaseClass {

	public  static WebDriver driver;
	//public Logger logger; // Log4j
	public HomePage homePage;
	public Properties prop;
	public MaterialPage materialPage;
	public VendorPage vendorPage;
	public VendorMapping vendorMapping;
	public InvMasterDataAuditTrail inventoryMasterDataAuditTrail;
	public AddBatch addBatch;
	public String password ="Chemia@1234";
	public AddEquipmentType equipType;
	public AddInstrumentType instrumentType;
	public AddColumnType columnType;
	public EquipMasterDataAuditTrail equipMasterDataAuditTrail;
	public AddEquipmentCatalogue addEquipmentCatalogue;
	public AddInstrumentCatalogue addInstrumentCatalogue;
	public AddColumnCatalogue addColumnCatalogue;
	public ChemicalConsumptionReport chemicalConsumptionReport;
	public EquipmentAndInstrumentUsageReport equipmentAndInstrumentUsageReport;
	public ColumnUsageReport columnUsageReport;
	public VerifyBatch verifyBatch;
	public VerifyEquipment verifyEquipment;
	public VerifyInstrument verifyInstrument;
	public VerifyColumn verifyColumn;
	public RequestStock requestStock;
	public ApproveBatch approveBatch;
	public ScreenshotClass screenshot;
	public AllocateBatchFromStoreIncharge allocateBatchFromStoreIncharge;
	public AllocatingNewBatch allocatingNewBatch;
	public AddMaintenance addMaintenance;
	public AddCalibration addCalibration;
	public AddSpecification addSpecification;
	
	public ExperimentEditorPage experimentEditorPage;
	
	public DummyAutomation dummyAutomation;
		
	@BeforeClass
	public void setUp() throws IOException {
		// Loading config.properties
		FileReader file = new FileReader("./src/test/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		String br = prop.getProperty("browser");
		//logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			return;

		}
		homePage=new HomePage(driver);
		materialPage = new MaterialPage(driver);
		vendorPage= new VendorPage(driver);
		vendorMapping= new VendorMapping(driver);
		inventoryMasterDataAuditTrail= new InvMasterDataAuditTrail(driver);
		equipType=new AddEquipmentType(driver);
		instrumentType=new AddInstrumentType(driver);
		columnType=new AddColumnType(driver);
		addBatch= new AddBatch(driver);
		equipMasterDataAuditTrail=new EquipMasterDataAuditTrail(driver);
		addEquipmentCatalogue=new AddEquipmentCatalogue(driver);
		addInstrumentCatalogue=new AddInstrumentCatalogue(driver);
		addColumnCatalogue=new AddColumnCatalogue(driver);
		chemicalConsumptionReport=new ChemicalConsumptionReport(driver);
		equipmentAndInstrumentUsageReport=new EquipmentAndInstrumentUsageReport(driver);
		columnUsageReport =new ColumnUsageReport(driver);
		verifyBatch=new VerifyBatch(driver);
		verifyEquipment=new VerifyEquipment(driver);
		verifyInstrument=new VerifyInstrument(driver);
		verifyColumn=new VerifyColumn(driver);
		requestStock=new RequestStock(driver);
		approveBatch=new ApproveBatch(driver);
		allocateBatchFromStoreIncharge=new AllocateBatchFromStoreIncharge(driver);
		allocatingNewBatch =new AllocatingNewBatch(driver);
		addMaintenance = new AddMaintenance(driver);
		addCalibration = new AddCalibration(driver);
		addSpecification= new AddSpecification(driver);
		screenshot = new ScreenshotClass(driver); 
		experimentEditorPage=new ExperimentEditorPage(driver);
		
		
		dummyAutomation = new DummyAutomation();
		
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
	public void login(String userName) throws Exception {
		driver.get(prop.getProperty("appURL")); // reading url from properties file
		materialPage.setUserNamePasswordAndLogin(userName,password);
	}
	

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String getBase64Screenshot() {
		String base64String = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64); 
		return base64String;
	}
	public String getTodayDateNum() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("d");
		LocalDateTime dateNow = LocalDateTime.now();
		return dateNow.format(date).toString();
	}
	
	public String getTommorrowsDateForEquipmentEnd() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("d");
		LocalDateTime dateNow = LocalDateTime.now().plusDays(3);
		return dateNow.format(date).toString();
	}

	public String getTommorrowsDate() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("d");
		LocalDateTime dateNow = LocalDateTime.now().plusDays(2);
		return dateNow.format(date).toString();
	}

}
