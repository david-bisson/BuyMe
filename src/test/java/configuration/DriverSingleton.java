package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DriverSingleton {
    private static WebDriverWait wait;
    private static WebDriver driver;

    public static WebDriverWait waitForElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }


    public static WebDriver getDriverInstance() throws Exception {
        String type = getData("browserType");
        if (driver == null) {
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Git\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (type.equals("FF")) {
                System.setProperty("webdriver.firefox.driver", "C:\\Git\\chromedriver_win32\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static String getURL() throws Exception {
        return getData("websiteURL");
    }


    private static String getData(String keyName) throws Exception {
//        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
//        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File("src/main/resources/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }


}
