package pages;

import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Actions {
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public String getElementText(By locator) {
        return getWebElement(locator).getText();
    }

    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
