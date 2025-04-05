package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
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


public class ScreenshotUtils {

    public static String screenshotFolder = "AutomationReport\\screenshots\\";
    public static final Logger logger = Logger.getLogger(String.valueOf(ScreenshotUtils.class));
    private static ExtentTest extentTest;


    public static String takeScreenshot(WebDriver driver, String description) throws IOException {
        String random = RandomStringUtils.randomNumeric(3);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String des = screenshotFolder + description + random + ".png";

        try{
            FileUtils.copyFile(src, new File(des));
        }catch (IOException e){
           logger.warning("cannot take screenshot");
        }

        return des.substring(des.indexOf("/")+1);
    }

    public static void addScreenshot(WebDriver driver, String message) throws IOException {
//        extentTest = ExtentReportUtil.startTest();
        if(extentTest!=null){
            if(driver!=null){

                String path = ScreenshotUtils.takeScreenshot(driver,message);
                extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                System.out.println("Screenshot taken");
            }else{
                Assert.assertTrue(false,"Screenshot failed");
            }
        }


    }

    public static void addStepInReport(String message){
        if(extentTest!=null){
            extentTest.pass(message);
        }
    }
}
