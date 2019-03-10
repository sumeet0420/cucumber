#Author: Sumeet Agrawal
Feature: To test the Register functionality

  Background:
    Given User opens the browser
    Then navigates to the url

  Scenario: To verify that the registered user is not able to register again
    Given that the user clicks Register button
    Then Register the user with the following details
      | Fields     | Values         |
      | Gender     | MALE           |
      | First Name | Sumeet         |
      | Last Name  | Agrawal        |
      | Email      | abcdef@email.com |
      | Password   | POPOPP         |
      | Repassword | POPOPP        |

    Then verify if the user should not be registered successfully
    And closes the browser

     #The following scenario data can be used only once. Upon successful registration, data will become invalid
  Scenario: To verify that the registered user is not able to register again
    Given that the user clicks Register button
    Then Register the user with the following details
      | Fields     | Values         |
      | Gender     | FEMALE           |
      | First Name | ABC        |
      | Last Name  | DEF        |
      | Email      | abcd@email.com |
      | Password   | POPOPP         |
      | Repassword | POPOPP        |

    Then verify if the user is successfully registered
    And closes the browser