package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import configuration.DriverSingleton;
import configuration.Reporting;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static configuration.DriverSingleton.waitForElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Actions {


    private static WebDriver driver;
    private ExtentTest test;

    public Actions(ExtentTest test) {
        this.test = test;
    }

    /**
     * click on any Element
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void clickElement(By locator) throws Exception {
        try {
            getWebElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());


        }
    }

    /**
     * send keys or string to any Element
     *
     * @param locator - By.Id/cssLocator etc...
     * @param text    - the keys you want to send
     */
    public void sendKeysToElement(By locator, String text) throws Exception {
        try {
            getWebElement(locator).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());
        }
    }

    /**
     * @param locator - By.Id/cssLocator etc...
     * @return - returns the value of the text value in text boxes
     */
    public String getElementAttribute(By locator) throws Exception {
        try {
            return getWebElement(locator).getAttribute("value");
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());
        }
        return null;
    }

    /**
     * @param locator By.Id/cssLocator etc...
     * @return driver object instance for the WebElement
     */
    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }


    /**
     * clearing text boxes values
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void clearTextBox(By locator) throws Exception {
        try {
            getWebElement(locator).clear();
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());
        }
    }

    /**
     * explicit wait for element to be visible
     *
     * @param locator - By.Id/cssLocator etc...
     */
    public void waitForElementToAppear(By locator) throws Exception {
        try {
            waitForElement().until(elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());

        }
    }

    /**
     * @param locator -  By.Id/cssLocator etc...
     * @return elemnts text
     */
    public String getTextFromElement(By locator) throws Exception {
        try {
            return DriverSingleton.getDriverInstance().findElement(locator).getText();
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Test has failed");
            test.pass("Failed Test", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Failed Test")).build());
        }
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }

    /**
     * take element Screentshot
     *
     * @param element
     */
    public static void takeElementScreenshot(WebElement element) {
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("bounceElement.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * scroll to element
     *
     * @param locator
     * @throws InterruptedException
     */
    public void scrollToElement(By locator) throws Exception {
        Thread.sleep(2000);
        WebElement element = DriverSingleton.getDriverInstance().findElement(locator);
        ((JavascriptExecutor) DriverSingleton.getDriverInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
        test.pass("Scroll down and Take ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(Reporting.takeScreenShot(DriverSingleton.getDriverInstance(), "Scroll-down-and-Take-ScreenShot")).build());
    }

    /**
     * Select value from drop down list (not used)
     *
     * @param locator
     * @param visibleText
     */
    public void selectFromDropDown(By locator, String visibleText) throws Exception {
        Select mySelection = new Select(DriverSingleton.getDriverInstance().findElement(locator));
        mySelection.selectByVisibleText(visibleText);

    }

    /**
     * click on element from list array
     *
     * @param locator
     * @param text
     */
    public void listClickElement(By locator, String text) throws Exception {
        List<WebElement> elements = DriverSingleton.getDriverInstance().findElements(locator);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }
}
