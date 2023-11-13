@SalesforceLoginFeature
Feature: Salesforce login

  @ForgotPassword
  Scenario: Forgot the password
    Given the user wants to operate the salesforce application
    When user is on the "LoginPage"
    When user inputs the username as "agorpalli@agorpalli.com"
    And user clicks the forgot password link  
    When user is on the "ForgotPasswordPage"
    Then user verifies the text "Forgot Your Password"
    When user inputs the username on Forgot Password Page as "agorpalli@agorpalli.com"
    When user clicks the continue button
    When user is on the "CheckYourEmailPage"
    Then user verifies the email page text "Check Your Email"
    When user clicks the return to login button
    Then user is on the "LoginPage"
    
    
       
