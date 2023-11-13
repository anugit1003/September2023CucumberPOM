package com.automation.tests.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/salesforceForgotPassword.feature"},
glue = {"com.automation.tests.scripts"})


public class SalesForceRunner extends AbstractTestNGCucumberTests{

}
