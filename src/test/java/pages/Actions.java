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

    /**
     * click on any Element
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void clickElement(By locator) {

        getWebElement(locator).click();
    }

    /**
     * send keys or string to any Element
     *
     * @param locator - By.Id/cssLocator etc...
     * @param text    - the keys you want to send
     */
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    /**
     * @param locator - By.Id/cssLocator etc...
     * @return - returns the value of the text value in text boxes
     */
    public String getElementAttribute(By locator) {
        return getWebElement(locator).getAttribute("value");
    }

    /**
     * @param locator By.Id/cssLocator etc...
     * @return driver object instance for the WebElement
     */
    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }


    /**
     * clearing text boxes values
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void clearTextBox(By locator) {
        getWebElement(locator).clear();
    }

    /**
     * explicit wait for element to be visible
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void waitForElementToAppear(By locator) {
        waitForElement().until(elementToBeClickable(locator));
    }

    /**
     *
     * @param locator -  By.Id/cssLocator etc...
     * @return elemnts text
     */
    public String getTextFromElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }


}
