#@addtocart
#Feature: To check the product added in the cart
# @addtocart
#Scenario: without login  product addtocart
# Given browser open
#And Go to shop page
# When click add to cart button selective products
# And Go to cart page
#Then cart should display items count
@puplist
Feature: puplist add,edit.delete

  @puplist
  Scenario Outline: To check the puplist add , edit, delete or not
    Given open website login page
    And login with login credentials <email> and <password>
    When click on login button
    Then verify dashboard
    When click on Add new button
    And user add details of pup <year> and <month> and <breed>
    And click on submit
    Then verify user goes to puplist page
    When click on edit button
    And edit details of pup <weight> and <foodallergy>
    Then verify edit properly or not
    When delete the pup from puplist
    Then verify delete properly or not

    Examples: 
      | email                     | password      | year    | month   | breed            | weight | foodallergy            |
      | pritam.sanyal@yopmail.com | Sanyal88888@@ | 13 Year | 3 Month | Golden Retriever |     25 | Lamb and lamb products |
      | smith_doe@yopmail.com     | Testing$$$123 | 7 Year  | 6 Month | Basset Hound     |     50 | Blueberry              |
