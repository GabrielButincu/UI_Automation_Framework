Feature: User Authentication and Registration

  @SMOKE1
  # Happy Flow for User Registration
  Scenario: User registers with valid credentials
    Given User is on the HomePage
    When User clicks on Create an Account button from HomePage
    Then User is sent to the Registration Page
    And User enters valid registration details
    Then User clicks on Create an Account button from RegistrationPage
    And User wait for 10 seconds
    Then User should see a success message "Thank you for registering with Main Website Store."

  @SMOKE
  # Negative Flow for User Registration
  Scenario: User fails to register with invalid input data
    Given User is on the HomePage
    When User clicks on Create an Account button from HomePage
    Then User is sent to the Registration Page
    And User enters invalid registration details
    Then User clicks on Create an Account button from RegistrationPage
    Then User should see validation errors for invalid input in the email, password, and confirm password fields

  @SMOKE
  # Happy Flow for User Login
  Scenario: User login with valid credentials
    Given User is on the HomePage
    When User clicks on Sign in button
    Then User is sent to the LoginPage
    And User enter valid login details
    Then User clicks on Sign in button from LoginPage
    And User should be successfully logged in