package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil {
    public static ExtentReports extent;
    public static ExtentTest scenarioTest;
    public static WebDriver driver;
    static String LocalDir = System.getProperty("user.dir");
    private static String Timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm").format(new Date());
    private static String FileName = "ExtentReport_" + Timestamp + ".html";
    private static String Folder = LocalDir +"\\AutomationReport\\";

    public static ExtentReports setupReport() {

        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(LocalDir + "\\AutomationReport\\" + FileName);
            System.out.println(LocalDir +"\\AutomationReport\\"+ FileName);

            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("ExtentReport");
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Execution-Status");
            htmlReporter.config().setCss("css-string");
            htmlReporter.config().setJs("js.string");
            htmlReporter.config().setProtocol(Protocol.HTTPS);
            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;

    }

    public static void startTest(String str) {
        scenarioTest = extent.createTest(str);
    }

    public static void logStep(String stepDetails) {

        if (stepDetails!=null) {
            scenarioTest.log(Status.PASS, stepDetails);
        } else {
            scenarioTest.log(Status.FAIL, stepDetails);
        }
        extent.flush();
    }

    public static void tearDownReport() {

        extent.flush();
    }
}