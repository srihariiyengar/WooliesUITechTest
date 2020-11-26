package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
    public WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    By homeButton = By.xpath("//*[@id=\"center_column\"]/ul/li/a/span");

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }
}
