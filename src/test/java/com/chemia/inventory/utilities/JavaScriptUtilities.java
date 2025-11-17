package com.chemia.inventory.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptUtilities {

	private JavascriptExecutor js;
	private Actions ac;
	public JavaScriptUtilities(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		ac=new Actions(driver);
	}

	public void doJsClick(WebElement element) {
		try {
			js.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doJsClear(WebElement element) {
		js.executeScript("arguments[0].value = '';", element);
	}
	
	public void doJsSendKeys(WebElement element,String text) {
		js.executeScript("arguments[0].value = '"+text+"';", element);
	}

	public void setBrowerSize(int size) {
		js.executeScript("document.body.style.zoom='" + size + "%'");
	}

	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollIntoViewCenter(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center'});", element);
	}

	public String doGetText(WebElement element) {
		return js.executeScript("return arguments[0].value;", element).toString();
	}

	public String getPageTitle() {
		return js.executeScript("return document.title;").toString();
	}

	public String getPageURL() {
		return js.executeScript("return document.URL;").toString();
	}

	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void goBackWithJS() {
		js.executeScript("history.go(-1)");
	}

	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollPageUp() {
		js.executeScript("window.scrollTo(0,0);");
	}

	public void goForwardWithJS() {
		js.executeScript("history.go(1)");
	}

	public String getTextFromElementWithNodes(WebElement element) {
		String directText = (String) js.executeScript("let text = ''; " + "for (let node of arguments[0].childNodes) { "
				+ "  if (node.nodeType === Node.TEXT_NODE) text += node.textContent; " + "} return text.trim();",
				element);
		return directText;
	}

	public boolean isImageLoadedAndDisplayed(WebElement element) {
		Boolean isImageLoaded = (Boolean) js.executeScript("return arguments[0].complete && "
				+ "typeof arguments[0].naturalWidth != 'undefined' && " + "arguments[0].naturalWidth > 0", element);
		return isImageLoaded;
	}

	public void pageRefreshWithJS() {
		js.executeScript("history.go(0)");
		// js.executeScript("location.reload();");
	}
	
	public void DoMouseHoverclick(WebElement element) {
		ac.moveToElement(element).click().build().perform();
 
	}

}
