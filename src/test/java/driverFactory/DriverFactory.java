package driverFactory;

import lombok.Getter;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    @Getter
    static WebDriver driver = null;

    public static WebDriver initializeBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//            options.addArguments("--headless=new");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser name");
        }

        return driver;
    }
}
