package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import magneto_01.pages.ShippingPage;
import magneto_01.pages.WomenCatalogPage;
import magneto_01.utils.Utils;
import org.openqa.selenium.WebDriver;

public class WomenCatalogPageSteps {

    private WebDriver driver;

    private Utils utils;

    private WomenCatalogPage womenCatalogPage;

    public WomenCatalogPageSteps() {
        driver = DriverFactory.getDriver();
        this.utils = new Utils(driver);
        this.womenCatalogPage = new WomenCatalogPage(driver);
    }

    @And("User navigates through Women category to Bottoms and then Shorts section")
    public void userNavigatesThroughWomenCategoryToBottomsAndThenShortsSection() {
        womenCatalogPage.userNavigatesThroughWomenCategoryToBottomsAndThenShortsSection();
    }


}
