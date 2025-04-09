//package runner;
//
//import courgette.api.*;
//import courgette.api.junit.Courgette;
//import org.junit.runner.RunWith;
//
//@RunWith(Courgette.class)
//@CourgetteOptions(
//        threads = 8,
//        runLevel = CourgetteRunLevel.SCENARIO,
//        testOutput = CourgetteTestOutput.CONSOLE,
//        reportTargetDir = "build",
//        environmentInfo = "browser=chrome",
//        cucumberOptions = @CucumberOptions(
//                features = "src/test/java/features",
//                glue = {"stepDefinitions", "hooks"},
//                plugin = {
//                        "pretty",
//                        "html:target/courgette-report/courgette.html",
//                },
//                tags = "@E2E"
//        )
//)
//public class TestRunnerThreads {
//}
