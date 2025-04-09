package magneto_01.pages;

import magneto_01.utils.GeneratedCredentials;
import magneto_01.utils.LoginCredentials;
import magneto_01.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailAddressInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(css = "span.logged-in")
    private WebElement welcomeMessageText;

    private WebDriver driver;

    private Utils utils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    public void userIsSentToTheLoginPage() {
        utils.checkPageTitle("Customer Login");

    }

    public void userEnterValidLoginDetails() {
        utils.typeTextIntoElement(emailAddressInput, LoginCredentials.MAGNETO_VALID_EMAIL_ADDRESS.toString());
        utils.typeTextIntoElement(passwordInput, LoginCredentials.MAGNETO_VALID_PASSWORD.toString());
    }

    public void userClicksOnSignInButtonFromLoginPage() {
        utils.clickOnElement(signInButton);
    }

    public void userShouldBeSuccessfullyLoggedIn() {
        utils.waitForElementToBeDisplayed(welcomeMessageText, 10);
        utils.checkPageTitle("Home Page");
        String expectedWelcomeText = "Welcome, " +
                LoginCredentials.MAGNETO_VALID_FIRSTNAME + " " +
                LoginCredentials.MAGNETO_VALID_LASTNAME + "!";
        Assert.assertEquals(expectedWelcomeText, welcomeMessageText.getText());
    }

    public void userEnterTheLoginDetailsForTheNewAccountCreated() {
        String email = GeneratedCredentials.getEmail();
        String password = GeneratedCredentials.getPassword();

        utils.typeTextIntoElement(emailAddressInput, email);
        utils.typeTextIntoElement(passwordInput, password);
    }
}