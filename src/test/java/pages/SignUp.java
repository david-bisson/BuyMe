package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SignUp extends Actions{
    private final Long timeStamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
    private static final String signUpButton = "//*[@id=\"ember953\"]/div/ul[1]/li[3]/a/span[2]";
    private static final String registerLink = ".text-link";
    private static final String nameTextBox = "#ember1461";
    private static final String emailAddressTextBox = "#ember1464";
    private static final String logInEmailAddressTextBox = "#ember1617";
    private static final String logInPasswordTextBox = "#ember1616";
    private static final String logInButton = "#ember1625";
    private String NewEmailAddress;
    private static final String passwordTextBox1 = "#ember1467";
    private static final String passwordTextBox2 = "#ember1470";
    private static final String submitSignUpButton= "#ember1473";
    private static final String myAccount= "#ember1510";
    private static final String logOut= "יציאה";
    private static final String signIn= "#ember1510";
    private static final String accountDetails= "#ember1510";

    public void signUpToPage(String name, String email, String password1, String password2){

        clickElement(By.xpath(signUpButton));
        clickElement(By.cssSelector(registerLink));
        this.NewEmailAddress = timeStamp+email;
        sendKeysToElement(By.cssSelector(nameTextBox), name);

        sendKeysToElement(By.cssSelector(emailAddressTextBox), this.NewEmailAddress);
        sendKeysToElement(By.cssSelector(passwordTextBox1), password1);
        sendKeysToElement(By.cssSelector(passwordTextBox2), password2);
        clickElement(By.cssSelector(submitSignUpButton));

        //Assert
        //ALL fields

    }
}
