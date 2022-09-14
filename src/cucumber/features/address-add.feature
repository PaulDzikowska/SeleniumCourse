Feature: Address add

  Scenario Outline: user can add new address
    Given An open browser with url https://mystore-testlab.coderslab.pl/index.php?controller=addresses
    When user is logged in
    And a text <alias> is entered in Alias field
    And a text <first_name> is entered in First Name field
    And a text <last_name> is entered in Last Name field
    And a text <address> is entered in Last Name field
    And a text <city> is entered in City field
    And a text <postal_code> is entered in Zip/Postal Code field
    And a text <country> is entered in Country field
    And a text <phone> is entered in Phone field
    And SAVE button clicked
    Then Message results contain phrase <afterAddedPhrase>

    Examples:
      |alias      | first_name  | last_name | address | city      | postal_code | country         | phone     | afterAddedPhrase            |
      |PaulD      | Paul        | Dzika     | Leona   | Wejherowo | 84-200      | United Kingdom  | 555666999 | Address successfully added! |
