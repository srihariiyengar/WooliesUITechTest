package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStep1 {
    public WebDriver driver;

    public OrderStep1(WebDriver driver) {
        this.driver = driver;
    }

    By proceedCheckoutButton = By.cssSelector("div#center_column button[type=\"submit\"] > span");

    public void clickOnProceedCheckoutButtonOnOrderStep1Page() {
        driver.findElement(proceedCheckoutButton).click();
    }
}
