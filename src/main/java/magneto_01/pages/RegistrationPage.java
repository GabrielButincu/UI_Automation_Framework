package magneto_01.pages;

import magneto_01.utils.GeneratedCredentials;
import magneto_01.utils.LoginCredentials;
import magneto_01.utils.RegistrationCredentials;
import magneto_01.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegistrationPage {

    @FindBy(css = ".action.submit.primary")
    private WebElement createAnAccountButton;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailAddressInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(css = "div[data-bind*=\"prepareMessageForHtml\"]")
    private WebElement successfulRegistrationMessage;

    @FindBy(id = "email_address-error")
    private WebElement invalidEmailAddressMessage;

    @FindBy(id = "password-error")
    private WebElement invalidPasswordMessage;

    @FindBy(id = "password-confirmation-error")
    private WebElement invalidConfirmPasswordMessage;

    private WebDriver driver;

    private Utils utils;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }


    public void userEntersValidRegistrationDetails() {
        utils.typeTextIntoElement(firstNameInput, RegistrationCredentials.MAGNETO_VALID_FIRSTNAME.toString());
        utils.typeTextIntoElement(lastNameInput, RegistrationCredentials.MAGNETO_VALID_LASTNAME.toString());
        utils.typeTextIntoElement(emailAddressInput, RegistrationCredentials.MAGNETO_VALID_EMAIL_ADDRESS.toString());
        utils.typeTextIntoElement(passwordInput, RegistrationCredentials.MAGNETO_VALID_PASSWORD.toString());
        utils.typeTextIntoElement(confirmPasswordInput, RegistrationCredentials.MAGNETO_VALID_PASSWORD.toString());
    }

    public void userEntersInvalidRegistrationDetails() {
        utils.typeTextIntoElement(firstNameInput, RegistrationCredentials.MAGNETO_INVALID_FIRSTNAME.toString());
        utils.typeTextIntoElement(lastNameInput, RegistrationCredentials.MAGNETO_INVALID_FIRSTNAME.toString());
        utils.typeTextIntoElement(emailAddressInput, RegistrationCredentials.MAGNETO_INVALID_EMAIL_ADDRESS.toString());
        utils.typeTextIntoElement(passwordInput, RegistrationCredentials.MAGNETO_INVALID_FIRSTNAME.toString());
        utils.typeTextIntoElement(confirmPasswordInput, RegistrationCredentials.MAGNETO_INVALID_LASTNAME.toString());
    }

    public void userClicksOnCreateAnAccountButtonFromRegistrationPage() {
        utils.clickOnElement(createAnAccountButton);
    }

    public void userShouldSeeASuccessMessage(String successfulMessage) {
        utils.waitForElementToBeDisplayed(successfulRegistrationMessage, 15);
        Assert.assertEquals(successfulMessage, successfulRegistrationMessage.getText());

    }

    public void userShouldSeeValidationErrorsForInvalidInputInTheEmailPasswordAndConfirmPasswordFields() {
        utils.waitForElementToBeDisplayed(invalidEmailAddressMessage, 10);
        Assert.assertEquals("Please enter a valid email address (Ex: johndoe@domain.com).", invalidEmailAddressMessage.getText());
        Assert.assertEquals("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.", invalidPasswordMessage.getText());
        Assert.assertEquals("Please enter the same value again.", invalidConfirmPasswordMessage.getText());
    }

    public void userEntersValidRegistrationDetailsRandomGenerated() {
        String firstName = generateRandomString("FN");
        String lastName = generateRandomString("LN");
        String email = "user" + System.currentTimeMillis() + "@mailinator.com";
        String password = "Pwd@" + new Random().nextInt(999999);

        GeneratedCredentials.setEmail(email);
        GeneratedCredentials.setPassword(password);

        utils.typeTextIntoElement(firstNameInput, firstName);
        utils.typeTextIntoElement(lastNameInput, lastName);
        utils.typeTextIntoElement(emailAddressInput, email);
        utils.typeTextIntoElement(passwordInput, password);
        utils.typeTextIntoElement(confirmPasswordInput, password);
    }

    // Helper method to generate a random string prefix + 5 random letters
    private String generateRandomString(String prefix) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(prefix);
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(letters.charAt(rand.nextInt(letters.length())));
        }
        return sb.toString();
    }

}
