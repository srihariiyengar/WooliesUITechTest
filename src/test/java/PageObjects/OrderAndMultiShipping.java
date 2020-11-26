package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderAndMultiShipping {
    public WebDriver driver;

    public OrderAndMultiShipping(WebDriver driver) {
        this.driver = driver;
    }

    By payByBankWire = By.className("bankwire");

    public void clickPayByBankWire() {
        driver.findElement(payByBankWire).click();
    }

}
