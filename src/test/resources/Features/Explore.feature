@explore
Feature: Ebay explore page

  Scenario: Explore_Link
    Given I am on the ebay login page
    When I click on explore link
    Then I enter username and password for login page
    And I Validate the selected explore Page

  Scenario Outline: Selected_Fashion_<Collections>
    When I click on "<Collections>" dropdown
    Then I select the Size and gender
    And I save the changes
    Examples:
      | Collections     |
      | Shoes           |
      | Tops & T-Shirts |
      | Coats & jackets |

    Scenario: Buy a shirt
      When I select the jacket
      Then Jacket details displayed
      And I checkout the Jacket