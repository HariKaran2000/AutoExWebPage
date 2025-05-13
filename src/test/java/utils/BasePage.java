package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void get(String url) {
        driver.get(url);
    }

    protected void waitUntilClickable(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    protected void waiUntilDisplayed(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    protected void implicitWait(int num) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
    protected void clickElement(final WebElement ele, String description){
        try{
            ele.click();
            Thread.sleep(1000);
            ScreenshotUtils.attachScreenshot(driver,"Clicked " + description);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    protected void clickElementWithoutScreenshot(final WebElement ele){
        ele.click();
        implicitWait(5);
    }
    protected void setInput(final WebElement ele, String value){
        ele.click();
        ele.sendKeys(value);
        implicitWait(3);
        ScreenshotUtils.attachScreenshot(driver,"Entered value : " + value);
    }
    protected void moveToElement(WebElement ele){
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        implicitWait(5);
    }

    protected void selectElementByValue(WebElement ele, String value){
        Select select = new Select(ele);
        select.selectByValue(value);
        implicitWait(5);
        ScreenshotUtils.attachScreenshot(driver,"Selected " + value);
    }
    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    protected void switchToAlertAccept(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    protected void uploadFile(WebElement ele, String path){
       ele.sendKeys(path);
    }


}
