package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import magneto_01.pages.LoginPage;
import magneto_01.utils.LoginCredentials;
import magneto_01.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class LoginPageSteps {

    private WebDriver driver;

    private Utils utils;

    private LoginPage loginPage;

    public LoginPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Then("User is sent to the LoginPage")
    public void userIsSentToTheLoginPage() {
        loginPage.userIsSentToTheLoginPage();
    }

    @And("User enter valid login details")
    public void userEnterValidLoginDetails() {
        loginPage.userEnterValidLoginDetails();
    }

    @Then("User clicks on Sign in button from LoginPage")
    public void userClicksOnSignInButtonFromLoginPage() {
        loginPage.userClicksOnSignInButtonFromLoginPage();
    }

    @And("User should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() {
        loginPage.userShouldBeSuccessfullyLoggedIn();
    }

    @And("User enter the login details for the new account created")
    public void userEnterTheLoginDetailsForTheNewAccountCreated() {
        loginPage.userEnterTheLoginDetailsForTheNewAccountCreated();
    }
}
