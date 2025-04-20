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
                if (ConfigProvider.getProperty("browser").equals("chrome")) {
                  ChromeOptions options = new ChromeOptions();

String tempProfileDir = Files.createTempDirectory("chrome-profile").toString();
options.addArguments("--user-data-dir=" + tempProfileDir);
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--headless=new");
 driver = new ChromeDriver(options);
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
