package stepDefinition;

import ConfigProvider.ConfigProvider;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.DriverManager;
import utils.ScreenshotUtils;




public class Hooks {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        ScreenshotUtils.driver = driver;
        ScreenshotUtils.setupReport();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ScreenshotUtils.startTest(scenario.getName());
    }

//    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.attachScreenshot(driver, "Failed Step");
            ScreenshotUtils.logStep("Step failed: " + scenario.getName());
        } else {
            ScreenshotUtils.attachScreenshot(driver, "Passed Step");
            ScreenshotUtils.logStep("Step passed: " + scenario.getName());
        }
    }

    @AfterAll
    public static void tearDown() {
//        driver.quit();
        ScreenshotUtils.tearDownReport();

    }
}
