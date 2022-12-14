Feature: Address add

  Scenario Outline: user can add new address
    Given An url https://mystore-testlab.coderslab.pl opened in browser
    When Sign In button clicked
    And Email <email> is entered into Email field
    And Password <pass> is entered into Password field
    And SUBMIT button clicked
    And Address link clicked
    And Create address clicked
    And a text <alias> is entered in Alias field
    And a text <first_name> is entered in First Name field
    And a text <last_name> is entered in Last Name field
    And a text <address> is entered in Address field
    And a text <city> is entered in City field
    And a text <postal_code> is entered in Zip/Postal Code field
    And a text <country> is entered in Country field
    And a text <phone> is entered in Phone field
    And SAVE button clicked
    Then Message results contain <afterAddedPhrase> phrase
    And Added address is equal to: <alias> and <first_name> and <last_name> and <address> and <city> and <postal_code> and <country> and <phone> values

    Examples:
      |email                        | pass      |alias      | first_name  | last_name | address | city      | postal_code | country         | phone     | afterAddedPhrase            |
      |klwmlyivgwqvbynsmi@bvhrs.com | coderslab |PaulD      | Paul        | Dzika     | Leona   | Wejherowo | 84-200      | United Kingdom  | 555666999 | Address successfully added! |
