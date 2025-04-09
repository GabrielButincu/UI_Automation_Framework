package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Path to the directory containing feature files
        glue = {"stepDefinitions", "hooks"}, // Package where step definitions are located
        plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"},
        tags = "@E2E"
)
public class TestRunner {

}
