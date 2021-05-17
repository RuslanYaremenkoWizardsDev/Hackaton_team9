Feature: User authorization of registered user

  Scenario Outline: User registration with not registered data
    Given I open authorization page
    When user fill in required fields with not registered data <login> and <password>
    And I click on button "submit"
    Then error message is shown
    Examples:
      | login | password |
      | UserT1| passW1   |
      | vasilij| passWord1   |
      | sweety23| qwert1   |

