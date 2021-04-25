@smoke_test
Feature:

  Background: chrome testing
    Given user test with "chrome" browser

  @unit_test
  @regression_test
  Scenario:verify that the following types of elements are present
    Given user is on the landing page
    And user verifies that "Browse by Make" is present
    And user verifies that "Browse by Style" is present
    And user verifies that "Advanced Search" is present
    Then user verifies that search button is present
    And user verifies that "Any Make" and "Any Model" are visible

  @integration_test
  @abc_test
  Scenario:Verify those options
    Given user is on the landing page
    When user clicks on Advanced Search link on the home page
    Then user writes "30004" into the Zip Code text box
    And user selects "Certified" check box under "Condition"
    And user selects "Convertible" check box under "Style"
    Then user update year "2017" to "2020"
    Then user selects "BMW" from Make, Model&Trim
    And user clicks "Search" button
    Then user verifies that he is on the result page
    Then user verifies only "BMW" cars in the result page
    And writes the total number of cars in the result page
