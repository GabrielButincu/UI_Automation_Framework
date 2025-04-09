package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import magneto_01.pages.HomePage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    private WebDriver driver;

    private Utils utils;

    private HomePage homePage;

    public HomePageSteps() {
        driver = DriverFactory.getDriver();
        utils = new Utils(driver);
        homePage = new HomePage(driver);
    }


    @When("I should see the homepage title as {string}")
    public void iShouldSeeTheHomepageTitleAs(String expectedTitle) {
        utils.checkPageTitle(expectedTitle);
    }

    @Given("The User is sent to the Google page")
    public void theUserIsSentToTheGooglePage() {
        driver.get("https://www.google.ro/");
    }

    @When("User clicks on Create an Account button from HomePage")
    public void userClicksOnCreateAnAccountButtonFromHomePage() {
        homePage.userClicksOnCreateAnAccountButtonFromHomePage();
    }

    @Given("User is on the HomePage")
    public void userIsOnTheHomePage() {
        utils.checkPageTitle("Home Page");
    }

    @When("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        homePage.userClicksOnSignInButton();
    }

}
