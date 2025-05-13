package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "stepDefinition",
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "summary",
                "html:AutomationReport/ExtentReport.html",
                "json:AutomationReport/cucumber.json",
                "junit:AutomationReport/cucumber.xml"
        },
        tags = "@TC08_AE"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
