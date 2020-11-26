package StepDefs;

import PageObjects.*;
import Utility.Helper;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class PlaceOrder {
    public static WebDriver driver;
    Authentication authentication;
    Home home;
    MyAccount myAccount;
    Order order;
    OrderStep1 orderStep1;
    OrderAndMultiShipping orderAndMultiShipping;
    Payment payment;
    OrderConfirmation orderConfirmation;

    public PlaceOrder() {
        driver = Hooks.driver;
    }

    private Helper helper = new Helper();

    @Given("^I land on the homepage$")
    public void i_land_on_the_homepage() {
        String url = helper.baseURL("baseUrl");
        Reporter.addStepLog("URL is => " + url);
        driver.get(url);
        Assert.assertTrue("Page title does not Match ", "My Store".equalsIgnoreCase(driver.getTitle()));
    }

    @Given("^I Sign in$")
    public void i_sign_in() throws InterruptedException {
        home = new Home(driver);
        home.clickSignIn();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        authentication = new Authentication(driver);
        authentication.enterUserEmail();
        authentication.enterUserPassword();
        authentication.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue("Invalid User Login", "My account - My Store".equalsIgnoreCase(driver.getTitle()));
        myAccount = new MyAccount(driver);
        myAccount.clickHomeButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue("Invalid Home Page", "My Store".equalsIgnoreCase(driver.getTitle()));
    }

    @When("^I add 2 items to the cart$")
    public void i_add_two_items_to_the_cart() {
        home.clickAddFirstItemToCart();
        home.clickOnContinueButton();
        home.clickAddSecondItemToCart();
        home.clickOnProceedCheckoutButton();
    }

    @Then("^I click on Proceed to Checkout$")
    public void i_click_on_Proceed_to_Checkout() {
        order = new Order(driver);
        order.clickOnProceedCheckoutButtonOnOrderPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("^I click on Proceed to Checkout on OrderStep1 Page$")
    public void i_click_on_proceed_to_checkout_on_orderstep1_page() {
        orderStep1 = new OrderStep1(driver);
        orderStep1.clickOnProceedCheckoutButtonOnOrderStep1Page();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("^I accept terms of services$")
    public void i_accept_terms_of_services() {
        order.clickOnTermsAndServiceCheckBox();
        order.clickOnProceedCheckoutButtonOnOrderPageShipping();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("^I choose the Payment type$")
    public void i_choose_the_Payment_type() {
        orderAndMultiShipping = new OrderAndMultiShipping(driver);
        orderAndMultiShipping.clickPayByBankWire();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("^I Successfully complete my Order$")
    public void i_confirm_my_Order() throws Throwable {
        payment = new Payment(driver);
        payment.clickOnConfirmMyOrderButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderConfirmation = new OrderConfirmation(driver);
        String ordConfirmText = orderConfirmation.getConfirmationMessage();
        Assert.assertTrue(ordConfirmText.equalsIgnoreCase("Your order on My Store is complete."));
    }
}
