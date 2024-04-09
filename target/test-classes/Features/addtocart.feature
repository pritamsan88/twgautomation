@addtocart
Feature: To check the product add to cart & wishlist

  @addtocart
  Scenario Outline: To check the add to cart functionality & wishlist
    Given browser lunch
    And enter a website
    When enter product in the search section <product>
    And click on search button in the header search
    And clear the search field
    And select product from auto suggestion dropdown <product> and <autosuggesionproduct>
    And go to product details page
    And click on cart option
    And click on wishlist option
    And go to cart page
    Then user should navigate to cart
    And go to wishlist
    Then user should navigate to wishlist page

    Examples: 
      | product           |  | autosuggesionproduct                |
      | Ring Touch        |  | Ring Touch - White With Red Handle  |
      | Refined Flatstone |  | Refined Flatstone - Tea Cup - Black |
