Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given User is on the login page
    When User enters username "admin" and password "123456"
    And User clicks on login button
    Then User should be logged in successfully

  Scenario: User logs in with empty credentials
    Given User is on the login page
    When User left the username and password empty
    And User clicks on login button
    Then Error message is displayed