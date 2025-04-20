package stepDefinition;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportUtil;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

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
//            File userDataDir = new File(System.getProperty("user.dir") + "/temp");
//            if (userDataDir.exists()) {
//                try {
//                    FileUtils.deleteDirectory(userDataDir);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        ExtentReportUtil.tearDownReport();
    }
}
