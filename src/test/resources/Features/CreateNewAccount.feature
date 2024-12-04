 Feature: Create and Login to Account
@CreateAccount
  Scenario: User successfully creates an account
    Given the user is on the "Create Account" page
    When the user enters the following details to create an account:
      | First Name         | Manish           |
      | Last Name          | Test            |
      | Email              | manish.test@test.com |
      | Password           | SecureP@ss123  |
      | Confirm Password   | SecureP@ss123  |
    And the user clicks on the "Create Account" button
    Then the user should see a welcome message "Thank you for registering with Main Website Store."
    
@Login
  Scenario: User successfully logs in with the created account
    Given the user is on the "Login" page
    When the user enters "manish.test@test.com" as the Email
    And the user enters "SecureP@ss123" as the Password
    And the user clicks on the "Sign In" button
    Then the user should see their account dashboard with the welcome message "Welcome, Manish Test!"
