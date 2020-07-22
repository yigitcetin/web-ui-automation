Feature: Existing user login
  As an existing customer of the shopping website
  I should be able to login into the application
  So that I can view items for purchase

  Scenario: User should be able to login to the application
    Given Darth Vader, an existing customer navigates to application home page
    When Darth Vader logs into the application with his credentials
    Then Dart should be able to view his account page
    And view the sign out option