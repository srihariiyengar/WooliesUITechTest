package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmation {
    public WebDriver driver;

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    By confirmationBox = By.cssSelector("div#center_column p > strong");

    public String getConfirmationMessage() {
        return driver.findElement(confirmationBox).getText();
    }
}