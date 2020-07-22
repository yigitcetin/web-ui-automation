Feature: Checkout item from cart
  As an existing customer of the shopping website,
  I should be able to add products to cart, proceed to checkout
  And confirm my order post payment

  Scenario: User should be able to checkout, pay and complete an order
    Given Darth Vader, an existing customer ordered:
      | Section | Product                     |
      | Women   | Faded Short Sleeve T-shirts |
    And navigated to payments page
    When Darth Vader opts "Pay by bank wire" payment method
    And confirms the order
    Then Darth Vader should be taken to order confirmation page
    And order should be completed successfully