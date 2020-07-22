Feature: Add an item and checkout from cart
  As an existing customer of the shopping website,
  I should be able to add products to cart from category and proceed to checkout
  And confirm my order post payment

  Scenario: User should be able to add a product, checkout, pay and complete an order
    Given Darth Vader, an existing customer ordered:
      | Section | Product                     |
      | Women   | Blouse |
    And navigated to payments page
    When Darth Vader choose "Pay by bank wire" payment method
    And confirms the order
    Then Darth Vader should be taken to order confirmation page
    And order should be completed successfully