package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ScreenshotUtils extends ExtentReportUtil {



    public static void attachScreenshot(WebDriver driver, String stepName) {

        if (stepName!=null) {
            String random = RandomStringUtils.randomNumeric(3);
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String screenshotPath = LocalDir + "/AutomationReport/screenshots/Screenshot-" + random + ".png";
            File dest = new File(screenshotPath);
            dest.getParentFile().mkdirs(); // Ensure directory exists
            try {
                FileUtils.copyFile(src, dest);
                scenarioTest.pass(stepName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addStepInReport(String stepName) {

        if (stepName!=null) {
            scenarioTest.log(Status.PASS, stepName);
        }
    }
    public static void addStepInReportFail(String stepName) {

        if (stepName!=null) {
            scenarioTest.log(Status.FAIL, stepName);
        }
    }
}
