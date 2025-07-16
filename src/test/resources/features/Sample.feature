Feature: Amazon Login Page Feature



  Scenario: Verify user is able to login with valid credentials
    Given User opens chrome browser
    And User navigates to login page
    When User enters valid credentials as "username" and "password"
