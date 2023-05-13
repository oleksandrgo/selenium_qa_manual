Feature: Check signUp

  Scenario: Create user with valid data
    Given open main page
    When click button Sign up
    And fill field name with "Test"
    And fill field last name with "Test"
    And set unique email
    And fill field password with "Test!123"
    And fill field re enter password with "Test!123"
    And click register button
    Then redirect to profile page

  Scenario Outline: Check firstName with negative data
    Given open main page
    When click button Sign up
    And fill field name with "<invalidFirstName>"
    And change focus to last name field
    Then error message "<error>" displayed

    Examples:
      | invalidFirstName      | error                                       |
      | q                     | Name has to be from 2 to 20 characters long |
      | qwertyuiopqwertyuiopq | Name has to be from 2 to 20 characters long |

