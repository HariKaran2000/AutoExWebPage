package stepDefinition;

import io.cucumber.java.*;
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
//        if (driver != null) {
//            driver.quit();
//        }
        ExtentReportUtil.tearDownReport();
    }
}
