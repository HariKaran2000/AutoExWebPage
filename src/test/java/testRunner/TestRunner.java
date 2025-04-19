package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "stepDefinition",
        monochrome = false,
        dryRun = false,
        plugin = {
                "pretty",
                "summary",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:AutomationReport/cucumberHTML.html"
        },
        tags = "@TC01_AE"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
