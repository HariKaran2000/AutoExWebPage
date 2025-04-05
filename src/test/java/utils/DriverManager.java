package utils;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {
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
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
