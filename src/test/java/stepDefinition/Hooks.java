package stepDefinition;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportUtil;
import utils.ScreenshotUtils;

public class Hooks extends AbstractSteps{

    @Before
    public void setup(Scenario scenario) {
        startDriver();
        ExtentReportUtil.setupReport();
        ScreenshotUtils.startTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.attachScreenshot(getDriver(), "Failure Screenshot");
            ScreenshotUtils.addStepInReportFail("Scenario Failed: " + scenario.getName());
        }

        if (getDriver() != null) {
           getDriver().quit();
        }
        ExtentReportUtil.tearDownReport();
    }
}
