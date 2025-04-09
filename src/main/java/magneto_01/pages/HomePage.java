package magneto_01.pages;

import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Create an Account')]")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement signInButton;

    private WebDriver driver;

    private Utils utils;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }


    public void userClicksOnCreateAnAccountButtonFromHomePage() {
        utils.clickOnElement(createAnAccountButton);
    }

    public void userClicksOnSignInButton() {
        utils.clickOnElement(signInButton);
    }
}