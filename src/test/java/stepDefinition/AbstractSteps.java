package stepDefinition;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjectManager.PageObjectManager;

public class AbstractSteps {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;

    public void startDriver() {
        try {
            if (driver == null) {
                if (ConfigProvider.getProperty("browser").equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hari S\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
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
