Feature: This is feature difference request for student

  Scenario: Checking if the student can be access by user
    When The user sent GET request to the list endpoint, then status code return two thousand

    @two
  Scenario Outline: Verify that the student add success into the system and check if the student is added
    When create Student with some information "<firstname>" "<lastname>" "<email>" "<program>" "<course>"
    Then The student is added with "<email>"
    Examples:
      | firstname | lastname | email              | program | course   |
      | chuoi     | moc      | chuoimoc@gmail.com | cay     | thuc vat |
      | xe dap    | di       | xedap@gmail.com    | do vat  | gia dung |

