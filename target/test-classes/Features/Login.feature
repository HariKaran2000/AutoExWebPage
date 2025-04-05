@smoke
Feature: Ebay Login

  @actions
  Scenario: Login to Ebay
    Given I am on the ebay login page
    Then I enter username and password
    And I verify login successful


  @links
  Scenario: Validate Links in Ebay Page
    When I get all the links from the page and validate the status


