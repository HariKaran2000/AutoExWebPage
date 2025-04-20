package stepDefinition;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjectManager.PageObjectManager;

public class AbstractSteps {
    protected static WebDriver driver;
    protected PageObjectManager pageObjectManager;

    public void startDriver() {
        try {
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                String userDataDir = System.getProperty("user.dir") + "/temp/userDataDir_" + System.currentTimeMillis();  // Unique directory for each run
                options.addArguments("user-data-dir=" + userDataDir);  // Set user data dir

                if (ConfigProvider.getProperty("browser").equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hari S\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver(options);  // Pass ChromeOptions
                    driver.manage().window().maximize();
                }
                if (ConfigProvider.getProperty("browser").equals("edge")) {
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pageObjectManager = new PageObjectManager(driver);
    }


    public WebDriver getDriver() {
        return driver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
