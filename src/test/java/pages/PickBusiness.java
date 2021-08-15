package pages;

import org.openqa.selenium.By;

public class PickBusiness extends Actions{

    private static final String cafeTaizu = "#ember1727";
    private static final String amountTextBox = "#ember2965";
    private static final String amountValue = "500";
    private static final String submitAmountButton = "#ember2967";

    public void pickBusinessAndEnterAmount(String giftAmountValue) {

        clickElement(By.cssSelector(cafeTaizu));
        sendKeysToElement(By.cssSelector(amountTextBox),giftAmountValue);
        clickElement(By.cssSelector(submitAmountButton));


    }
}
