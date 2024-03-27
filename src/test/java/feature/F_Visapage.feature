Feature: Testing dbankdemo Visa Page

  Scenario Outline: User Should open dbankdemo Visa Trasfer
    Given User Navigate to the URL
    When User click on the Visa Transfer
    Then User choose the Visa Account Number with Zero
    Then User enter the transfer amount '<Amount>'
    And User click submit to VISA

    Examples: 
      | Amount |
      |   1000 |