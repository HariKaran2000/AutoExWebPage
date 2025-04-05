package basePageObject;

import java.time.Duration;
import java.util.logging.Logger;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import StepDefinition.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;


public class BasePage {
    static WebDriver driver = DriverManager.getDriver();

    public void wait(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void implictWait(int num) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }


}
