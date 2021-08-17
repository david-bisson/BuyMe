package pages;

import org.openqa.selenium.By;

public class PickBusiness extends Actions{

    private static final String cafeTaizu = "CAFE TAIZU -קפה טאיזו";
    private static final String amountTextBox = "input[placeholder='הכנס סכום']";
    private static final String amountValue = "500";
    private static final String submitAmountButton = "button[gtm='בחירה']";

    public void pickBusinessAndEnterAmount(String giftAmountValue) {

        clickElement(By.linkText(cafeTaizu));
        sendKeysToElement(By.cssSelector(amountTextBox),giftAmountValue);
        clickElement(By.cssSelector(submitAmountButton));


    }
}
