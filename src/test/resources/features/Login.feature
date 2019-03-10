#Author: Name: Sumeet Agrawal
Feature: To test the login functionality

  Background:
    Given User opens the browser
    Then navigates to the url

  Scenario: Verify user is able to login by providing correct credentials

    Given user be able to clicks on login button
    Then user provides his correct credentials
    Then he is able to successfully log in the website
    And closes the browser

  Scenario: Verify user is not to login by providing invalid credentials
    Given user be able to clicks on login button
    Then user provides his incorrect credentials
    Then he should not be able to log in the website
    And closes the browser