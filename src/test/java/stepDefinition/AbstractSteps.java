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
                String userDataDir = System.getProperty("user.dir") + "\\temp\\userDataDir_" + System.currentTimeMillis();
                options.addArguments("user-data-dir=" + userDataDir);

                if (ConfigProvider.getProperty("browser").equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
                    driver = new ChromeDriver(options);
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
