Feature: Testing Bankdemo login page

  Scenario: User should open BankDemo login page on ChromeBrowser and he register
    Given User is on Chrome browser and he opens the link
    When User fills the details on the page
    Then User fills the details of next page and fills details
    And user clicks on register and he comes on login

    
     Scenario: User is unable to register the bankdemo page
    Given User is on Chrome browser and he opens the links
    When User fills the invalid details on the page 
    Then User will gets message that it has been already registered
    And user closes the browser
    
    