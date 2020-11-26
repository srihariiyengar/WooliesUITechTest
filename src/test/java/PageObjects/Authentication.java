package PageObjects;

import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authentication {

    private Helper helper = new Helper();
    public WebDriver driver;
    By userEmail = By.id("email");
    By password = By.id("passwd");
    By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");

    public Authentication(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserEmail() {
        String usrEmail = helper.userEmail("userEmail");
        driver.findElement(userEmail).sendKeys(usrEmail);
    }

    public void enterUserPassword() {
        String usrPassword = helper.userPassword("userPassword");
        driver.findElement(password).sendKeys(usrPassword);
    }

    public void clickSubmitButton() {
        driver.findElement(signInButton).click();
    }

}
