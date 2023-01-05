package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BaseHeaderPage {

    @FindBy(xpath = "//span[text() = 'Add to bag']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'rec-sheets')]/div[contains(@class, 'rec-sheets')]")
    private WebElement confirmationFrame;

    @FindBy(xpath = "//div[contains(@class, 'floating-header')]/button")
    private WebElement closeButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickAddToCartButton() {
        getActions().moveToElement(addToCartButton)
                .click().build().perform();

        return this;
    }

    public ProductPage clickCloseButton() {
        getActions().moveToElement(confirmationFrame).perform();
        getActions().moveToElement(closeButton).click().build().perform();
        getWait5().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        TestUtils.scrollToTopPage(getDriver());

        return this;
    }
}
