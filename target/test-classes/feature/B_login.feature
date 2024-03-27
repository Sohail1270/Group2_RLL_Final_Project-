Feature: User Login
  As a registered user
  I want to be able to log in
  So that I can access my account

  Scenario: Successful login
    Given I am on the login page
    When I enter username "sadiqali@gmail.com"  and password "Admin@1234"
    And I click the login button
    Then I should be redirected to my account dashboard

  Scenario: Login with invalid username
    Given I am on the login page
    When I enter invalid username "s@gmail.com" and password "Admin@1234"  
    And I click the login button
    Then I should see an error message
    
 Scenario: Login with invalid password
    Given I am on the login page
    When I enter invalid password , username "sadiqali@gmail.com"   and password "sa"
    And I click the login button
    Then I should see an error message
    