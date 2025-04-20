Feature: Automation Exercise Page

#  Background:
#    Given a workbook named "NAME" and sheet name "il" is read
  @TC01_AE
  Scenario: Register Valid User
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    When Click on SignUp or Login button
    And Verify 'New User Signup!' is visible
    And Enter name and email address
    When Click 'Signup' button
    And Verify 'ENTER ACCOUNT INFORMATION' is visible
    And Fill details: for account registration with valid information
    And Click Create Account button
    And Verify 'ACCOUNT CREATED!' is visible
    And Click 'Continue' button
    And Verify 'Logged in as username' is visible
    When Click 'Delete Account' button
    Then Verify 'ACCOUNT DELETED!' is visible
    And Click 'Continue' button