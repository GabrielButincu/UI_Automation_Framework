package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import magneto_01.pages.MenCatalogPage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Target;

public class MenCatalogPageSteps {

    private WebDriver driver;

    private Utils utils;

    private MenCatalogPage menCatalogPage;


    public MenCatalogPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.menCatalogPage = new MenCatalogPage(driver);
    }

    @Then("User navigates through Men category to Tops and then Jackets section")
    public void userNavigatesThroughMenCategoryToTopsAndThenJacketsSection() {
        menCatalogPage.userNavigatesThroughMenCategoryToTopsAndThenJacketsSection();
    }


    @Then("User adjusts the size {string}, color {string}, and quantity {int} for the product")
    public void userAdjustsTheSizeColorAndQuantityForTheProduct(String size, String color, int quantity) {
        menCatalogPage.userAdjustsTheSizeColorAndQuantityForTheProduct(size, color, quantity);
    }

    @And("User clicks on AddToCart button")
    public void userClicksOnAddToCartButton() {
        menCatalogPage.userClicksOnAddToCartButton();
    }
}
