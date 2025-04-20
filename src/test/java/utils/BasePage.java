package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public void waitUntilClickable(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waiUntilDisplayed(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void implictWait(int num) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
    public void clickElement(final WebElement ele, String description){
        ele.click();
        implictWait(5);
        ScreenshotUtils.attachScreenshot(driver,"Clicked " + description);
    }
    public void setInput(final WebElement ele, String value){
        ele.click();
        ele.sendKeys(value);
        implictWait(3);
        ScreenshotUtils.attachScreenshot(driver,"Entered value : " + value);
    }
    public void moveToElement(WebElement ele){
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        implictWait(5);
    }

    public void selectElementByValue(WebElement ele, String value){
        Select select = new Select(ele);
        select.selectByValue(value);
        implictWait(5);
        ScreenshotUtils.attachScreenshot(driver,"Selected " + value);
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }


}
