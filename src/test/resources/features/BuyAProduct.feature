#Author: Name: Sumeet Agrawal
Feature: To test the end-to-end functionality of buying a product

  Background:
    Given User opens the browser
    Then navigates to the url

  Scenario: Verify user is able to buy a product
    Given user be able to clicks on login button
    Then user provides his correct credentials
    Then he is able to successfully log in the website
    Then he chooses a product category
    And select a product
    Then he clicks on add to cart
    And clicks on Shopping cart button
    Then he accepts the conditions
    And proceeds to checkout
    Then he selects his Billing Address
    And Shipping Address
    And Shipping Method as Next Day Air
    And Payment Method as COD
    Then Confirms the Payment Information
    And Confirms the Order
    When Order is placed logout from the site
    And closes the browser

  Scenario: Verify user is able to buy a product after applying a discount coupon
    Given user be able to clicks on login button
    Then user provides his correct credentials
    Then he is able to successfully log in the website
    Then he chooses a product category
    And select a product
    Then he clicks on add to cart
    And clicks on Shopping cart button
    When user applies the discount coupon card "AutomationDiscount2"
    And discount coupon card is successfully verified
   Then he accepts the conditions
    And proceeds to checkout
    Then he selects his Billing Address
    And Shipping Address
    And Shipping Method as Next Day Air
    And Payment Method as COD
    Then Confirms the Payment Information
    And Confirms the Order
    When Order is placed logout from the site
    And closes the browser