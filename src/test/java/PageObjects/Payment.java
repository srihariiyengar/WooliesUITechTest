package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {
    public WebDriver driver;

    public Payment(WebDriver driver) {
        this.driver = driver;
    }

    By confirmMyOrderButton = By.cssSelector("p#cart_navigation span");

    public void clickOnConfirmMyOrderButton() {
        driver.findElement(confirmMyOrderButton).click();
    }
}
