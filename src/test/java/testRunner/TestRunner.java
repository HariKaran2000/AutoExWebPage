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
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:AutomationReport/cucumberHTML.html",
                "json:AutomationReport/cucumberJson.json",
                "junit:AutomationReport/cucumberXml.xml"
        },
        tags = "@TC07_AE"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
