package stepDefinition;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectManager.PageObjectManager;

import java.nio.file.Files;

public class AbstractSteps {
    protected static WebDriver driver;
    protected PageObjectManager pageObjectManager;

    public void startDriver() {
        try {
            if (driver == null) {
                if (ConfigProvider.getProperty("browser").equals("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--remote-allow-origins=*");
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