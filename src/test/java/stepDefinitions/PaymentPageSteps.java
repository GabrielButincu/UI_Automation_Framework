package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import magneto_01.pages.PaymentPage;
import magneto_01.pages.RegistrationPage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

public class PaymentPageSteps {


    private WebDriver driver;

    private Utils utils;

    private PaymentPage paymentPage;

    public PaymentPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.paymentPage = new PaymentPage(driver);
    }

    @And("User validates the shipping information's")
    public void userValidatesTheShippingInformations() {
        paymentPage.validateShippingInfoOnPaymentPage();
    }

    @And("User completes the checkout process and places the order")
    public void userCompletesTheCheckoutProcessAndPlacesTheOrder() {
        paymentPage.userCompletesTheCheckoutProcessAndPlacesTheOrder();
    }

    @Then("The order should be confirmed")
    public void theOrderShouldBeConfirmed() {
        paymentPage.theOrderShouldBeConfirmed();
    }
}
