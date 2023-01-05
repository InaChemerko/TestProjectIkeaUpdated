package models;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseHeaderPage extends BasePage {
    public BaseHeaderPage(WebDriver driver) {
        super(driver);
    }

    //element for search
    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//div/ul/li[5]/a/span")
    private WebElement shoppingCartButton;

    public SearchPage enterWordAndPressEnterInSearchField(String str) {
        getWait5().until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        searchField.sendKeys(str + Keys.ENTER);

        return new SearchPage(getDriver());
    }

    public ShoppingCartPage clickShoppingCartButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(shoppingCartButton)).click();

        return new ShoppingCartPage(getDriver());
    }
}
