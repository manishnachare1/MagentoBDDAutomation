Feature: Login Functionality

Scenario: Valid login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user is navigated to the homepage
