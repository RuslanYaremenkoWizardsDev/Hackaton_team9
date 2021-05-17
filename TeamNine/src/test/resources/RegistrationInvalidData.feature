Feature: User registration with invalid data


  Scenario Outline: User registration with invalid login
    Given I open registration page
    When user fill in required fields with invalid data <login> and <password>
    And I click the button "registrate"
    Then error message is displayed
    Examples:
      | login | password |
      | юзер| password1|
      | Us|passW2|
      | UserMoreThan20Symbols|passWord2|


  Scenario Outline: User registration with invalid password
    Given I open registration page
    When user fill in required fields with invalid data <login> and <password>
    And I click the button "registrate"
    Then error message is displayed
    Examples:
      | login | password |
      | UserT1| пароль|
      | UserT12|pass|
      | UserTe12|!@#!@%!@|
      | UserT2|wqfgqfgfwqjn^!#&@%$21|



  Scenario Outline: User registration with invalid email
    Given I open registration page
    Given I open registration page
    When user fill in required fields with invalid data <login> and <password>
    And I click the button "registrate"
    Then error message is displayed
    Examples:
      | login | password |
      | emailcom| password1|
      | @email|passW2|
