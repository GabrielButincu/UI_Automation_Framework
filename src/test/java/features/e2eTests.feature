@E2E
Feature: E2E Tests

  Scenario: New Customer Successfully Places an Order from the Men’s Catalog
    Given User is on the HomePage
    When User clicks on Create an Account button from HomePage
    Then User is sent to the Registration Page
    And User enters valid registration details random generated
    Then User clicks on Create an Account button from RegistrationPage
    And User wait for 5 seconds
    Then User should see a success message "Thank you for registering with Main Website Store."
    Then User navigates through Men category to Tops and then Jackets section
    And User select the product named "Proteus Fitness Jackshirt"
    Then User adjusts the size "XL", color "BLACK", and quantity 2 for the product
    And User clicks on AddToCart button
    And User verifies the success message indicating the product was successfully added to the cart
    Then User proceeds to checkout
    And User completes the shipping details
    Then User proceeds to the payment page
    And User validates the shipping information's
    And User completes the checkout process and places the order
    Then The order should be confirmed


  Scenario: Registered Customer Successfully Places an Order from the Men’s Catalog
    And User clicks on Sign in button
    Then User is sent to the LoginPage
    And User enter valid login details
    Then User clicks on Sign in button from LoginPage
    And User should be successfully logged in
    Then User navigates through Men category to Tops and then Jackets section
    And User select the product named "Proteus Fitness Jackshirt"
    Then User adjusts the size "XL", color "BLACK", and quantity 2 for the product
    And User clicks on AddToCart button
    And User verifies the success message indicating the product was successfully added to the cart
    Then User proceeds to checkout
    Then User proceeds to the payment page
    And User validates the shipping information's
    And User completes the checkout process and places the order
    Then The order should be confirmed


  Scenario: Registered Customer Successfully Places an Order from the Women’s Catalog
    And User clicks on Sign in button
    Then User is sent to the LoginPage
    And User enter valid login details
    Then User clicks on Sign in button from LoginPage
    And User should be successfully logged in
    Then User navigates through Women category to Bottoms and then Shorts section
    And User select the product named "Angel Light Running Short"
    Then User adjusts the size "29", color "ORANGE", and quantity 4 for the product
    And User clicks on AddToCart button
    And User verifies the success message indicating the product was successfully added to the cart
    Then User proceeds to checkout
    Then User proceeds to the payment page
    And User validates the shipping information's
    And User completes the checkout process and places the order
    Then The order should be confirmed