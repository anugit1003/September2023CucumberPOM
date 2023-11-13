package com.automation.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automation.tests.base.BaseTest;
import com.automation.tests.utilities.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ForgotPasswordTest extends BaseTest {
	
	static Logger logger = LogManager.getLogger(ForgotPasswordTest.class.getName());

	@Before
	public void beforeScenario() {
		logger.info("initialize and launch browser");
		initializeProperties();
		launchBrowser(getProps().getProperty(Constants.BROWSER));
	}

	@After
	public void afterScenario() throws Exception {
		quitBrowser();
	}

}
