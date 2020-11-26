package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order {
    public WebDriver driver;

    public Order(WebDriver driver) {
        this.driver = driver;
    }

    By proceedCheckoutButton = By.cssSelector("div#center_column a.button.btn.btn-default.standard-checkout.button-medium > span");
    By termsOfServiceCheckBox = By.id("cgv");
    By proceedCheckoutButtonOrderPage = By.cssSelector("form#form button[type=\"submit\"] > span");

    public void clickOnProceedCheckoutButtonOnOrderPage() {
        driver.findElement(proceedCheckoutButton).click();
    }

    public void clickOnTermsAndServiceCheckBox() {
        driver.findElement(termsOfServiceCheckBox).click();
    }

    public void clickOnProceedCheckoutButtonOnOrderPageShipping() {
        driver.findElement(proceedCheckoutButtonOrderPage).click();
    }

}
