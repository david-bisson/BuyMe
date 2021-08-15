package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DriverSingleton {
    private static WebDriverWait wait;
    private static WebDriver driver;



    public static WebDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Git\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }
    public static WebDriverWait waitForElement(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }






}
