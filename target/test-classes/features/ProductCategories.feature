#Author: Name: Sumeet Agrawal
Feature: To test all the product catoegries

  Background:
    Given User opens the browser
    Then navigates to the url

  Scenario Outline: Verify user is able to click all the Product Categoties
    Given User click on a product "<Product>"
    And Verify URL is "<URL>"
    And closes the browser
    Examples:
      | Product          | URL                                                |
      | CAMERA           | http://demowebshop.tricentis.com/camera-photo      |
      | CELLPHONES       | http://demowebshop.tricentis.com/cell-phones       |
      | BOOKS            | http://demowebshop.tricentis.com/books             |
      | DESKTOPS         | http://demowebshop.tricentis.com/desktops          |
      | NOTEBOOKS        | http://demowebshop.tricentis.com/notebooks         |
      | ACCESSORIES      | http://demowebshop.tricentis.com/accessories       |
      | GIFTCARDS        | http://demowebshop.tricentis.com/gift-cards        |
      | JEWELRY          | http://demowebshop.tricentis.com/jewelry           |
      | DIGITALDOWNLOADS | http://demowebshop.tricentis.com/digital-downloads |
      | APPAREL          | http://demowebshop.tricentis.com/apparel-shoes     |



