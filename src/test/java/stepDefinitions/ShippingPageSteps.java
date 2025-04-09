package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import magneto_01.pages.PaymentPage;
import magneto_01.pages.ShippingPage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

public class ShippingPageSteps {


    private WebDriver driver;

    private Utils utils;

    private ShippingPage shippingPage;

    public ShippingPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.shippingPage = new ShippingPage(driver);
    }

    @And("User completes the shipping details")
    public void userCompletesTheShippingDetails() {
        shippingPage.userCompletesTheShippingDetails();
    }

    @And("User proceeds to the payment page")
    public void userProceedsToThePaymentPage() {
        shippingPage.userProceedsToThePaymentPage();
    }
}
