package stepDefinition;

import io.cucumber.java.*;
import org.testng.annotations.BeforeSuite;
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
        ExtentReportUtil.tearDownReport();
    }
}
