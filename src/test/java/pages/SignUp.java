package pages;

import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SignUp extends Actions {
    private final Long timeStamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
    private static final String signUpButton = "//*[@id=\"ember953\"]/div/ul[1]/li[3]/a/span[2]";
    private static final String registerLink = ".text-link";
    private static final String nameTextBox = "#ember1462";
    private static final String emailAddressTextBox = "#ember1465";
    private static final String logInEmailAddressTextBox = "#ember1617";
    private static final String logInPasswordTextBox = "#ember1616";
    private static final String logInButton = "#ember1625";
    private String NewEmailAddress;
    private static final String passwordTextBox1 = "#valPass";
    private static final String passwordTextBox2 = "#ember1471";
    private static final String submitSignUpButton = "button[type=submit]";
    private static final String myAccount = "#ember1510";
    private static final String logOut = "יציאה";
    private static final String signIn = "#ember1510";
    private static final String accountDetails = "#ember1510";
    private static final String signUpEmailErrorMessage = "#parsley-id-12";
    private static final String signUpPasswordErrorMessage = "#parsley-id-14";

    public void signUpToPage(String name, String email, String password1, String password2) {

        clickElement(By.xpath(signUpButton));
        clickElement(By.cssSelector(registerLink));
        this.NewEmailAddress = timeStamp + email;
        sendKeysToElement(By.cssSelector(nameTextBox), name);
        getElementAttribute(By.cssSelector(nameTextBox));
        sendKeysToElement(By.cssSelector(emailAddressTextBox), this.NewEmailAddress);
        sendKeysToElement(By.cssSelector(passwordTextBox1), password1);
        sendKeysToElement(By.cssSelector(passwordTextBox2), password2);

        Assert.assertEquals(name, getElementAttribute(By.cssSelector(nameTextBox)));
        Assert.assertEquals(NewEmailAddress, getElementAttribute(By.cssSelector(emailAddressTextBox)));
        Assert.assertEquals(password1, getElementAttribute(By.cssSelector(passwordTextBox1)));
        Assert.assertEquals(password2, getElementAttribute(By.cssSelector(passwordTextBox2)));

        clickElement(By.cssSelector(submitSignUpButton));


    }

    public void validateErrorMessagesOnLogging() {
        String errorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
        clickElement(By.xpath(signUpButton));
        clickElement(By.cssSelector(submitSignUpButton));
        Assert.assertEquals(getTextFromElement(By.cssSelector(signUpEmailErrorMessage)), errorMessage);
        Assert.assertEquals(getTextFromElement(By.cssSelector(signUpPasswordErrorMessage)), errorMessage);
        DriverSingleton.getDriverInstance().findElement(By.id("times")).click();

    }
}
