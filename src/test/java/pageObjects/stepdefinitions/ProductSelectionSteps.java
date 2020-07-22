package pageObjects.stepdefinitions;

import pageObjects.account.AccountPageQuestions;
import pageObjects.cart.CartPopUpActions;
import pageObjects.homepage.HomePageActions;
import pageObjects.navigation.NavigateActions;
import pageObjects.productpage.ProductPageActions;
import pageObjects.signin.SignInPageActions;
import cucumber.api.java.en.Given;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Steps;

public class ProductSelectionSteps {

  @Steps
  NavigateActions navigateTo;

  @Steps
  HomePageActions homePageActions;

  @Steps
  CartPopUpActions cartPopUpActions;

  @Steps
  ProductPageActions productPageActions;

  @Steps
  SignInPageActions signInPageActions;

  @Steps
  AccountPageQuestions accountPageQuestions;

  @Given("Darth Vader, an existing customer ordered:")
  public void existing_customer_ordered(List<Map<String, String>> products) {
    navigateTo.theSignInPage();
    signInPageActions.loginAsExistingUser();
    accountPageQuestions.verifyUserInAccountPage();

    //Add each product item to cart and proceed to checkout
    int itemCount = products.size();
    for (Map<String, String> product : products) {
      homePageActions.selectCategory(product.get("Section"));
      homePageActions.selectItem(product.get("Product"));
      productPageActions.addItemToCart();
      if (itemCount != 1) {
        cartPopUpActions.continueShopping();
        itemCount = itemCount-1;
      } else {
        cartPopUpActions.proceedToCheckout();
      }
    }
  }
}
