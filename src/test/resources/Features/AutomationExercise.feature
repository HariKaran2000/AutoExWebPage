@Automation_exercise
Feature: Automation Exercise Page

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
#    When Click 'Delete Account' button
#    Then Verify 'ACCOUNT DELETED!' is visible
#    And Click 'Continue' button

  @TC02_AE
  Scenario: Validate Login User
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    When Click on SignUp or Login button
    And Verify 'Login to your account' is visible
    And Enter name and email address for login user
    And Click 'Login' button
    And Verify 'Logged in as username' is visible
    When Click 'Delete Account' button
    Then Verify 'ACCOUNT DELETED!' is visible
    And Click 'Continue' button

  @TC03_AE
  Scenario: Validate Invalid user Login
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    When Click on SignUp or Login button
    And Verify 'Login to your account' is visible
    And Enter In Correct name and email address for login user
    And Click 'Login' button
    And Verify 'Your email or password is incorrect!' is visible

  @TC04_AE
  Scenario: Validate Logout User
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    When Click on SignUp or Login button
    And Verify 'Login to your account' is visible
    And Enter name and email address for login user
    And Click 'Login' button
    And Verify 'Logged in as username' is visible
    And Click 'Logout' button
    Then Verify that user is navigated to login page

  @TC05_AE
  Scenario: Register User with existing email
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    When Click on SignUp or Login button
    And Verify 'New User Signup!' is visible
    And Enter name and email address
    When Click 'Signup' button
    Then Verify 'Email Address already exist!' is visible

  @TC06_AE
  Scenario: Contact Us Form
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    And Click 'Contact Us' button
    And Verify 'GET IN TOUCH' is visible
    And Enter name, email, subject and message and upload
    And Click 'Submit' button

  @TC07_AE
  Scenario: TestCase Page
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    And Click 'Test Cases' button
    Then Verify user is navigated to test cases page successfully

  @TC08_AE
  Scenario: Verify All Products and product detail page
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    And Click 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click 'View Product' button
    Then Verify that detail detail is visible: product name, category, price, availability, condition, brand

  @TC09_AE
  Scenario: Verify All Products and product detail page
    Given I launch the browser
    Then I navigate to automation exercise URl
    Then Verify that home page is displayed
    And Click 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input and click search button
    And Verify 'SEARCHED PRODUCTS' is visible
    Then Verify all the products related to search are visible