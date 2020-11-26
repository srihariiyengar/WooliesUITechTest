package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Home {
    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    By signIn = By.cssSelector("header#header div.header_user_info > a");
    By clickOnContinue = By.cssSelector("div#layer_cart div.button-container > span > span");
    By clickOnProceedCheckout = By.cssSelector("div#layer_cart a > span");

    public void clickAddFirstItemToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        WebElement addCartHover = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));
        js.executeScript("arguments[0].click();", addCartHover);
    }

    public void clickOnContinueButton() {
        driver.findElement(clickOnContinue).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickAddSecondItemToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addSecCartHover = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));
        js.executeScript("arguments[0].click();", addSecCartHover);
    }

    public void clickOnProceedCheckoutButton() {
        driver.findElement(clickOnProceedCheckout).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }
}