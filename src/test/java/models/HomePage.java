package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseHeaderPage{
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookieOkButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickCookieOkButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(cookieOkButton)).click();

        return this;
    }
}
