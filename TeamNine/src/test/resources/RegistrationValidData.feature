Feature: User registration with valid data

  Scenario: User registration with valid login and password
    Given I open registration page
    When user fill in required fields with valid data "UserTester2" and "Password12"
    And I click the button "registrate"
    Then transition to the authorization page


  Scenario: User registration with valid email and password
    Given I open registration page
    When user fill in required fields with valid data "Tester123@mail.ru" and "passworD12"
    And I click the button "registrate"
    Then transition to the authorization page







