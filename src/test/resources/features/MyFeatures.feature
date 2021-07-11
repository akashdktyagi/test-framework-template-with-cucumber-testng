Feature: My First Feature

  Scenario: Validate Search Results
    Given I Open the Browser
    And I Navigate to the URL
    When I search for a product
    Then Search result is displayed

  Scenario: Validate Returns and orders link
    Given I Open the Browser
    And I Navigate to the URL
    When I click on returns and orders link
    Then Sign page is Displayed

  Scenario: Validate Amazon Pay Link
    Given I Open the Browser
    And I Navigate to the URL
    When I click on amazon pay link
    Then Amazon Pay Page is Displayed

  Scenario: Validate Cart Link is displayed
    Given I Open the Browser
    And I Navigate to the URL
    When I click on Cart link
    Then Cart page is displayed