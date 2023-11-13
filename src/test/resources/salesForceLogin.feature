@SalesforceLoginFeature
Feature: Salesforce login

  @SuccessfulLogin
  Scenario: Login with valid userId and password
    Given the user wants to operate the salesforce application
    When user is on the "LoginPage"
    When user inputs the username as "agorpalli@agorpalli.com"
    And user inputs the password as "Tekarch23"
    And user clicks the login button
    When user is on the "HomePage"
    Then verify that we can see "Anuradha Jackson" 
       
  @InvalidLogin
  Scenario: Login with invalid userId and password
  	Given the user wants to operate the salesforce application
    When user is on the "LoginPage"
    When user inputs the username as "123"
    And user inputs the password as "22131"
    And user clicks the login button
    Then verify error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."  
    
   @InvalidLogin
   Scenario: Login with valid userId and empty password
  	Given the user wants to operate the salesforce application
    When user is on the "LoginPage"
    When user inputs the username as "agorpalli@agorpalli.com"
    And user inputs the password as ""
    And user clicks the login button
    Then verify error message for blank password "Please enter your password."  