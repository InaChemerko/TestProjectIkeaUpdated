package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseHeaderPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductItem(int num) {
        getActions().moveToElement(getDriver()
                        .findElement(By.xpath("//div[@class='plp-fragment-wrapper'][" + num + "]//div[contains(@class, 'bottom-wrapper')]//a")))
                .click().build().perform();

        return new ProductPage(getDriver());
    }
}
