Feature: User authorization of registered user

  Scenario: User registration with valid login and password
    Given I open authorization page
    When user fill in required fields with registered data "UserTester12" and "Password12"
    And I click on button "submit"
    Then transition to the main page



