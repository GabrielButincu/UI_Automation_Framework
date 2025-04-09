package magneto_01.pages;

import magneto_01.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenCatalogPage {

    @FindBy(id = "ui-id-5")
    private WebElement menSectionMenu;

    @FindBy(id = "ui-id-17")
    private WebElement menSectionTopsMenu;

    @FindBy(id = "ui-id-19")
    private WebElement menSectionTopsJacketsMenu;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    private WebDriver driver;

    private Utils utils;

    public MenCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    public void userNavigatesThroughMenCategoryToTopsAndThenJacketsSection() {
        utils.hoverWaitAndClickElement(menSectionMenu, menSectionTopsMenu, menSectionTopsJacketsMenu);
        utils.checkPageTitle("Jackets - Tops - Men");
    }

    public void userSelectTheProductNamed(String productName) {
        WebElement productLink = driver.findElement(By.linkText(productName));
        utils.clickOnElement(productLink);
    }

    public void userAdjustsTheSizeColorAndQuantityForTheProduct(String size, String color, int quantity) {
        String sizeId = mapSizeToId(size);
        WebElement sizeElement = driver.findElement(By.id(sizeId));
        utils.clickOnElement(sizeElement);

        String colorId = mapColorToId(color);
        WebElement colorElement = driver.findElement(By.id(colorId));
        utils.clickOnElement(colorElement);

        // Adjust the quantity of the product
        WebElement quantityInput = driver.findElement(By.id("qty"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
        utils.waitForElementToBeDisplayed(quantityInput, 5);
    }

    private String mapSizeToId(String size) {
        switch (size) {
            case "XS":
                return "option-label-size-143-item-166";
            case "S":
                return "option-label-size-143-item-167";
            case "M":
                return "option-label-size-143-item-168";
            case "L":
                return "option-label-size-143-item-169";
            case "XL":
                return "option-label-size-143-item-170";
            case "29":
                return "option-label-size-143-item-172";
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    private String mapColorToId(String color) {
        switch (color.toLowerCase()) {
            case "black":
                return "option-label-color-93-item-49";
            case "blue":
                return "option-label-color-93-item-50";
            case "orange":
                return "option-label-color-93-item-56";
            default:
                throw new IllegalArgumentException("Invalid color: " + color);
        }
    }


    public void userClicksOnAddToCartButton() {
        utils.waitForElementToBeDisplayed(addToCartButton, 5);
        utils.clickOnElement(addToCartButton);
    }
}
