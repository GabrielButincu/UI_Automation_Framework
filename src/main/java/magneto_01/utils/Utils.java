package magneto_01.utils;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {


    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void waitUntillTextIsPresent(WebElement element, String stringElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(element, stringElement));
    }

    public void waitForPageToLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(60)).until(isPageLoaded());
        } catch (Exception e) {
            // Page did not load within the specified time, throw an exception
            throw new RuntimeException("Page was not loaded within the expected time of 60 seconds", e);
        }
    }

    public ExpectedCondition<Boolean> isPageLoaded() {
        return webDriver -> !isPageLoading();
    }

    public Boolean isPageLoading() {

        String pageLoadingLocator = "page-loading-locator";
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            return driver.findElement(By.xpath(pageLoadingLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
        }
    }

    public void typeTextIntoElement(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        } catch (Exception e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].value='" + text + "'", element);
            element.click();
        }
    }


    public boolean isElementDisplayed(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            System.err.println("Timeout occurred while waiting for the element to be displayed: " + e.getMessage());
            return false;
        }
    }

    public void clickOnElement(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
        }
    }

    public void waitForElementToBeDisplayed(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverWaitAndClickElement(WebElement firstContainer,
                                         WebElement secondContainer,
                                         WebElement targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);


            actions.moveToElement(firstContainer).perform();

            wait.until(ExpectedConditions.visibilityOf(secondContainer));

            actions.moveToElement(secondContainer).perform();

            wait.until(ExpectedConditions.elementToBeClickable(targetElement));

            targetElement.click();

        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for elements: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Error during element hover and click: " + e.getMessage());
            throw e;
        }
    }

    public void selectOptionFromAutocompleteDropdown(WebElement dropdown, WebElement dropdownOption) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(dropdown));
            dropdown.click();
        } catch (Exception e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].value=", dropdown);
            dropdown.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(dropdownOption));
        clickOnElement(dropdownOption);
    }

    public void waitForElementToDissapear(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception e) {
            // Element not found within the specified time, continue execution
            System.out.println("Element not found within 10 seconds. Moving on...");
        }
    }
}