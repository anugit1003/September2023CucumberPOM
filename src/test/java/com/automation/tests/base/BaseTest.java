package com.automation.tests.base;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.tests.utilities.PropertiesUtility;

public class BaseTest {
	static Logger logger = LogManager.getLogger(BaseTest.class.getName());
	
	private WebDriverWait wait;
	
	private Properties props;
	
	private WebDriver driver;

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void goToUrl(String url) {
		getDriver().get(url);
		logger.info(url + "is entered");
	}

	public void maximizeBrowser() {
		getDriver().manage().window().maximize();
		logger.info("browser window has maximized");
	}
	
	public void initializeProperties() {
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties props = propUtility.loadFile("applicationDataProperties");
		//logger.info(props);
		setProps(props);
		
	}
	public void launchBrowser(String browserName) {

		switch (browserName) {
		case "firefox":
			setDriver(new FirefoxDriver());
			logger.info("firefox driver initialized");
			break;
		case "chrome":
			setDriver(new ChromeDriver());
			logger.info("chrome driver initialized");
			break;
		default:
			logger.error("you have not entrered the correct browser");
		}
	}
	
	public void quitBrowser() {
		logger.info("Quitting the browser");
		getDriver().quit();
	}
	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOf(ele));
		logger.info(objectName + " is waited for visibility using fluent wait");
	}

	public void waitForVisibility(WebElement ele, int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


}
