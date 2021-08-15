package pages;

import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

import static configuration.DriverSingleton.waitForElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Actions {

    private static WebDriver driver;

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

    public void DropDownPicker(By locator,By locatorValue) {
        getWebElement(locator).click();
        getWebElement(locatorValue).click();
    }

    public void clearTextBox(By locator) {
        getWebElement(locator).clear();
    }

    public void waitForElementToAppear(By locator) {
        waitForElement().until(elementToBeClickable(locator));
    }

    public void listElementsClickOnIndex(By locator,int index) {
        waitForElement().until(elementToBeClickable(locator));
        List<WebElement> elementsList = driver.findElements(locator);
        elementsList.get(index).click();
    }

}
