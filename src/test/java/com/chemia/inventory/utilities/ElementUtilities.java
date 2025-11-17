package com.chemia.inventory.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {
	
	private WebDriver driver;
	private Actions actions;
//	private JavascriptUtils jsUtils;
	private WebDriverWait wait;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
//		act = new Actions(driver);
//		jsUtils = new JavascriptUtils(driver);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void doRefresh() {
		driver.navigate().refresh();
	}

	public void doSendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public void doClear(WebElement element) {
		element.clear();
	}
	
	
	
	public void doSendFilePath(WebElement element, String text) {
		File filePath = new File(text);
        String absolutePath = filePath.getAbsolutePath();
		element.sendKeys(absolutePath);
	}

	public void doClick(WebElement element){

	}
	public String doGetColor(WebElement element) {
		String clr = element.getCssValue("background-color");
		Color cl= Color.fromString(clr);
		String hexCode = cl.asHex();
		return hexCode;
	}
	
	private Select getSelect(WebElement element) {
		return new Select(element);
	}

	public int getDropDownOptionsCount(WebElement element) {
		return getSelect(element).getOptions().size();
	}

	public void selectDropDownValueByVisibleText(WebElement element, String visibleText) {
		getSelect(element).selectByVisibleText(visibleText);
	}
	
	public boolean doCheckIsSelected(WebElement element) {
		return element.isSelected();
	}
	
	public String doGetAttributeValue(WebElement element,String text) {
		return element.getAttribute(text);
	}

	public String doGetElementText(WebElement element) {
		String eleText = element.getText().trim();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("Element text is null:" + eleText);
			return null;
		}
	}

	public boolean isElementDisplayed(WebElement element) {

		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			//System.out.println("Element is not displayed : " + element);
			return false;
		}
	}
	
	public boolean isElementDisplayed(By byPath) {

		try {
			return driver.findElement(byPath).isDisplayed();
		} catch (NoSuchElementException e) {
			//System.out.println("Element is not displayed : " + element);
			return false;
		}
	}
	
	public WebElement waitForElementVisible(WebElement element, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public WebElement waitForElementClickable(WebElement element, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public WebElement waitForElementPresence(By path, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(path));	
	}
	
	public List<WebElement> waitForElementAllPresence(By path, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(path));
		
	}
	
	public WebElement waitForElementClickable(By path, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(path));
	}
	
	public boolean waitForUrlContains(String fractionURL, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.urlContains(fractionURL));
		} catch (TimeoutException e) {
			System.out.println("URL is not matched");
			return false;
		}catch(Exception e) {
			return false;
		}

	}
	
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement frameElement, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public void waitForFrameToBeAvailableAndSwitchToIt(By frameElement, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public void doSwitchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public String doGetCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void Uploadfile(String Path) throws Exception {

		Robot robot = new Robot();
		File filePath = new File(Path);
        String absolutePath = filePath.getAbsolutePath();
        
		StringSelection stringSelection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.delay(1500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

	}
	
	public void doActionScrollIntoElement(WebElement element) {
		actions.moveToElement(element).perform();
	}
	
	
	
	public void waitForElementInVisible(By xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));	
	}
	
 
	
	
//	XWPFDocument document = new XWPFDocument();
//	FileOutputStream out = new FileOutputStream("DocumentWithScreenshot.docx");
//
//	XWPFParagraph paragraph = document.createParagraph();
//	XWPFRun run = paragraph.createRun();
//
//	FileInputStream pic = new FileInputStream("screenshot.png");
//	run.addPicture(pic, Document.PICTURE_TYPE_PNG, "screenshot.png", Units.toEMU(500), Units.toEMU(300));
//	pic.close();

}
