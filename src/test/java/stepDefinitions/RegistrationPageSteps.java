package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import magneto_01.pages.HomePage;
import magneto_01.pages.RegistrationPage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

public class RegistrationPageSteps {


    private WebDriver driver;

    private Utils utils;

    private RegistrationPage registrationPage;

    public RegistrationPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.registrationPage = new RegistrationPage(driver);
    }

    @Then("User is sent to the Registration Page")
    public void userIsSentToTheRegistrationPage() {
        utils.checkPageTitle("Create New Customer Account");
    }

    @Then("User enters valid registration details random generated")
    public void userEntersValidRegistrationDetailsRandomGenerated() {
        registrationPage.userEntersValidRegistrationDetailsRandomGenerated();
    }

    @Then("User enters valid registration details")
    public void userEntersValidRegistrationDetails() {
        registrationPage.userEntersValidRegistrationDetails();
    }

    @Then("User enters invalid registration details")
    public void userEntersInvalidRegistrationDetails() {
        registrationPage.userEntersInvalidRegistrationDetails();

    }

    @Then("User clicks on Create an Account button from RegistrationPage")
    public void userClicksOnCreateAnAccountButtonFromRegistrationPage() {
        registrationPage.userClicksOnCreateAnAccountButtonFromRegistrationPage();
    }

    @Then("User should see a success message {string}")
    public void userShouldSeeASuccessMessage(String successfulMessage) {
        registrationPage.userShouldSeeASuccessMessage(successfulMessage);
    }

    @Then("User should see validation errors for invalid input in the email, password, and confirm password fields")
    public void userShouldSeeValidationErrorsForInvalidInputInTheEmailPasswordAndConfirmPasswordFields() {
        registrationPage.userShouldSeeValidationErrorsForInvalidInputInTheEmailPasswordAndConfirmPasswordFields();
    }
}
