package hooks;

import config.ConfigReader;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        Properties properties = ConfigReader.initializeProperties();
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("magneto_url");

        DriverFactory.initializeBrowser(browser);
        driver = DriverFactory.getDriver();

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.get(url);
        } else {
            throw new RuntimeException("WebDriver initialization failed for browser: " + browser);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                // Capture and attach screenshot to both Cucumber and Allure
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
            driver.quit();
        }
    }
}
