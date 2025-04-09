package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import magneto_01.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonSteps {

    private WebDriver driver;

    private Utils utils;

    public CommonSteps() {
        driver = DriverFactory.getDriver();
        utils = new Utils(driver);
    }

    @And("User wait for {int} seconds")
    public void userWait(int milliseconds) throws InterruptedException {
        int seconds = milliseconds * 1000;
        Thread.sleep(seconds);
    }

    @And("User verifies the success message indicating the product was successfully added to the cart")
    public void userVerifiesTheSuccessMessageIndicatingTheProductWasSuccessfullyAddedToTheCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-ui-id='message-success']")));
        String successMessageText = successMessage.getText();

        String startOfMessage = "You added";
        String endOfMessage = "to your shopping cart.";

        Assert.assertTrue("The success message does not start with the expected static part.",
                successMessageText.startsWith(startOfMessage));

        Assert.assertTrue("The success message does not end with the expected static part.",
                successMessageText.endsWith(endOfMessage));

    }

    @Then("User proceeds to checkout")
    public void userProceedsToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement loadingCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
            utils.waitForElementToBeDisplayed(loadingCircle, 5);
            utils.waitForElementToDissapear(loadingCircle);
        } catch (Exception e) {
            System.out.println("The shopping cart page loaded faster than expected, no loading spinner detected.");
        }

        WebElement shoppingCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='action showcart']")));
        utils.waitForElementToBeDisplayed(shoppingCartButton, 5);
        utils.clickOnElement(shoppingCartButton);

        WebElement proceedToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-cart-btn-checkout")));
        utils.waitForElementToBeDisplayed(proceedToCartButton, 5);
        utils.clickOnElement(proceedToCartButton);

    }

    @And("User select the product named {string}")
    public void userSelectTheProductNamed(String productName) {
        WebElement productLink = driver.findElement(By.linkText(productName));
        utils.clickOnElement(productLink);
    }

}