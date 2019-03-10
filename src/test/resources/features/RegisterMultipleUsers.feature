#Author: Sumeet Agrawal
Feature: To Register Multiple Users Simultaneously to support DDT.

  Background:
    Given User opens the browser
    Then navigates to the url

  Scenario Outline: To verify that the registered user is not able to register again
    Given that the user clicks Register button
    Then Register the user with the following details "<Gender>" "<First Name>" "<Last Name>" "<Email>" "<Password>" "<Repassword>"
    Examples:
      | Gender | First Name | Last Name | Email      | Password | Repassword |
      | MALE   | ABCD       | LAST      | abc@ab.com | hello1   | hello1     |

    Then verify if the user is successfully registered
    And closes the browser

