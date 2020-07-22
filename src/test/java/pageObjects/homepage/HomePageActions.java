package pageObjects.homepage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class HomePageActions extends UIInteractionSteps {

    @Step
    public void selectCategory(String section) {
      findBy(HomePage.SECTION, section).click();
    }

    @Step
    public void selectItem(String productName) {
        WebElementFacade elementFacade = $(HomePage.PRODUCT, productName);
        waitForCondition().until(
                ExpectedConditions.visibilityOf(elementFacade)).click();
    }
}
