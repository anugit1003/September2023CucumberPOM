package com.automation.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	static Logger logger = LogManager.getLogger(BasePage.class.getName());

	protected WebDriver driver;

	

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		logger.info(data + " - extracted the text from " + objectName);
		return data;
	}
	
	public String getTextFromElementAttribute(WebElement ele, String attribute, String objectName) {
		String data = ele.getAttribute(attribute);
		logger.info(data + " - extracted the text from " + objectName);
		return data;
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			logger.info("data is entered in the " + objectName);
		} else {
			logger.error(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			logger.info(objectName + "button is clicked");
		} else {
			logger.error(objectName + " button element is not enabled");
		}
	}

	public void clickCheckBox(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			logger.info(objectName + "checkbox is clicked");
		} else {
			logger.error(objectName + " checkbox is already selected");
		}

	}

	public boolean isElementSelected(WebElement ele, String objectName) {
		logger.info(objectName + " is selected");
		return ele.isSelected();
	}

	
	public void clearElement(WebElement ele, String objectNam) {
		if (ele.isDisplayed()) {
			ele.clear();
			logger.info(objectNam + "is cleared");
		} else {
			logger.error(objectNam + "is not displayed");
		}
	}

	/*
	 * public void findElementByAndClick(By by) { WebElement element =
	 * getDriver().findElement(by); element.click();
	 * 
	 * }
	 * 
	 * public void findIframeAndSwitchTo(By by) { WebElement element =
	 * getDriver().findElement(by); getDriver().switchTo().frame(element);
	 * 
	 * }
	 */

}
