Feature: New user sign up
  As a new customer of the shopping website
  I should be able to sign up with my email id
  So that I can login to the application

  Background: Generate new customer data
    Given Customer data is available for new user

  Scenario: User should be able to create a new account for the application
    Given Luke, a new customer navigates to application sign in page
    When Luke registers as a new user of the application
    Then Luke should get logged into the application
    And Luke should be able to view his account page
    And view the sign out option