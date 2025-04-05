package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "StepDefinition",
        monochrome = false,
        dryRun = false,
        plugin = {
                "pretty",
                "summary",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:AutomationReport/cucumberHTML.html"
        },
        tags = "@explore"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
