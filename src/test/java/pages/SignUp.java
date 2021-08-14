package pages;

import configuration.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUp extends Actions{

    private static final String signUpButton = "//*[@id=\"ember953\"]/div/ul[1]/li[3]/a/span[2]";
    private static final String registerLink = ".text-link";
    private static final String fullName = "#ember1461";
    private static final String emailAddress = "#ember1464";
    private static final String passwordBox1 = "#ember1467";
    private static final String passwordBox2 = "#ember1470";
    private static final String submitSignUpButton= "#ember1473";

    public void signUpToPage(String name, String email, String password1, String password2){
       /* press on signup
            press on signup in popup
            fill: name, rmail password and passrod
            press register to buy me

       * */
        clickElement(By.xpath(signUpButton));
        clickElement(By.cssSelector(registerLink));
        sendKeysToElement(By.cssSelector(fullName), name);
        sendKeysToElement(By.cssSelector(emailAddress), email);
        sendKeysToElement(By.cssSelector(passwordBox1), password1);
        sendKeysToElement(By.cssSelector(passwordBox2), password2);
        clickElement(By.cssSelector(submitSignUpButton));

    }



}
