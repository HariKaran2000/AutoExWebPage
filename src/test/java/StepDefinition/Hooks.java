package StepDefinition;

import ConfigProvider.ConfigProvider;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.DriverManager;
import utils.ExtentReportUtil;




public class Hooks {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        DriverManager.getDriver();
        ExtentReportUtil.driver = driver;
        ExtentReportUtil.setupReport();
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        ExtentReportUtil.startTest(scenario.getName());
    }

//    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportUtil.attachScreenshot(driver, "Failed Step");
            ExtentReportUtil.logStep("Step failed: " + scenario.getName());
        } else {
            ExtentReportUtil.attachScreenshot(driver, "Passed Step");
            ExtentReportUtil.logStep("Step passed: " + scenario.getName());
        }
    }

    @AfterAll
    public static void tearDown() {
//        driver.quit();
        ExtentReportUtil.tearDownReport();

    }
}
