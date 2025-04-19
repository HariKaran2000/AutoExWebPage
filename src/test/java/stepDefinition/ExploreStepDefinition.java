package stepDefinition;

import ConfigProvider.ConfigProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import jdk.jpackage.internal.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;
import utils.DriverManager;
import utils.ScreenshotUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ExploreStepDefinition extends BasePage {

    public ExploreStepDefinition(WebDriver driver) {
        super(driver);
    }

    @When("I click on explore link")
    public void i_click_on_explore_link() {

        driver.findElement(By.xpath("//a[contains(text(),'Explore')]")).click();
        Logger.getLogger("Explore Page").info("Clicked on ExplorePage");
        ScreenshotUtils.addStepInReport("Clicked on ExplorePage");
    }

    @Then("I choose the fashion category and size")
    public void i_choose_the_fashion_category() {
        driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Shoes')]")).click();
        Logger.getLogger("Explore Page").info("Clicked on Shoes");
        implictWait(10);
        ScreenshotUtils.attachScreenshot(driver, "Clicked on Shoes");
        driver.findElement(By.xpath("//li[2]/button[@class='segmented-buttons__button']")).click();
        Logger.getLogger("Explore Page").info("Clicked on Men");
        implictWait(10);
        ScreenshotUtils.attachScreenshot(driver, "Selected Men");
        List<WebElement> ListSize = driver.findElements(By.className("ap-toggle-button"));
        System.out.println(ListSize.size());
        implictWait(10);
        ListSize.get(6).click();
        ScreenshotUtils.attachScreenshot(driver, "Selected Size" + ListSize.get(6).getText());
        Logger.getLogger("Explore Page").info("Selected Size" + ListSize.get(6).getText());
        implictWait(10);
        driver.findElement(By.xpath("//button[@class='button-cta-button btn btn--primary']")).click();
        Logger.getLogger("Explore Page").info("Clicked on Save button");
        implictWait(10);
    }

    @Then("I Validate the selected explore Page")
    public void i_validate_the_selected_explore_page() {
        ScreenshotUtils.addStepInReport("Title--> " + driver.getTitle() + " Url-->" + driver.getCurrentUrl());
        Logger.getLogger("explore").info("Title--> " + driver.getTitle() + " Url-->" + driver.getCurrentUrl());
        WebElement ele = driver.findElement(By.xpath("//button[@class='explore-header__edit-button--large btn btn--tertiary']"));
        Dimension Size = ele.getSize();
        int width = Size.getWidth();
        int height = Size.getHeight();

        Logger.getLogger("Explore Page").info("Width = " + width + " Height = " + height);

    }

    @When("I Click on list {string} items")
    public void iClickOnListItems(String arg0) {

    }

    @When("I click on {string} dropdown")
    public void iClickOnDropdown(String arg) {

        if (arg.equalsIgnoreCase("Shoes")) {
            driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Shoes')]")).click();
            Logger.getLogger("Explore Page").info("Clicked on Shoes");
            implictWait(10);
            ScreenshotUtils.attachScreenshot(driver, "Clicked on Shoes");
        }
        if (arg.equalsIgnoreCase("Tops & T-Shirts")) {
            WebElement ele = driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Tops & T-Shirts')]"));
            waitUntilClickable(ele);
            driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Tops & T-Shirts')]")).click();
            Logger.getLogger("Explore Page").info("Clicked on Tops & T-Shirts");
            implictWait(10);
            ScreenshotUtils.attachScreenshot(driver, "Clicked on Tops & T-Shirts");
        }
        if (arg.equalsIgnoreCase("Coats & Jackets")) {
            WebElement ele = driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Coats & Jackets')]"));
            waitUntilClickable(ele);
            driver.findElement(By.xpath("//span[@role='text' and contains(text(),'Coats & Jackets')]")).click();
            Logger.getLogger("Explore Page").info("Clicked on Coats & Jackets");
            implictWait(10);
            ScreenshotUtils.attachScreenshot(driver, "Clicked on Coats & Jackets");
        }

    }

    @Then("I select the Size and gender")
    public void iSelectTheSizeAndGender() {
        driver.findElement(By.xpath("//li[2]/button[@class='segmented-buttons__button']")).click();
        Logger.getLogger("Explore Page").info("Clicked on Men");
        implictWait(10);
        ScreenshotUtils.attachScreenshot(driver, "Selected Men");
        List<WebElement> ListSize = driver.findElements(By.className("ap-toggle-button"));
        Logger.getLogger("Explore Page").info("Size = " + ListSize.size());
        implictWait(10);
        ListSize.get(6).click();
        ScreenshotUtils.attachScreenshot(driver, "Selected Size " + ListSize.get(6).getText());
        Logger.getLogger("Explore Page").info("Selected Size " + ListSize.get(6).getText());
        implictWait(10);


    }

    @And("I save the changes")
    public void iSaveTheChanges() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn--primary']")).click();
        Logger.getLogger("Explore Page").info("Clicked on Save button");
        Thread.sleep(10000);
    }

    @Then("I enter username and password for login page")
    public void iEnterUsernameAndPasswordForLoginPage() throws InterruptedException {
        ScreenshotUtils.attachScreenshot(driver, "Navigated to Sign In Page");
        implictWait(20);
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Sign in to your account")) {
            driver.findElement(By.id("userid")).sendKeys(ConfigProvider.getProperty("email"));
            Logger.getLogger("Ebay SignIn :").info("Email ID Entered");
            ScreenshotUtils.attachScreenshot(driver, "Email ID Entered");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("signin-continue-btn")).click();

        }
        if (pageSource.contains("Please verify yourself to continue")) {
            Thread.sleep(20000);
            Logger.getLogger("Ebay").info("Manual captcha Override");
            driver.findElement(By.id("userid")).sendKeys(ConfigProvider.getProperty("email"));
            ScreenshotUtils.attachScreenshot(driver, "Email ID Entered");
            Logger.getLogger("Ebay SignIn :").info("Email ID Entered");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("signin-continue-btn")).click();
        }
        driver.findElement(By.id("pass")).sendKeys(ConfigProvider.getProperty("password"));
        ScreenshotUtils.attachScreenshot(driver, "Password Entered");
        Logger.getLogger("Ebay SignIn :").info("Password Entered");
        driver.findElement(By.id("sgnBt")).click();
        String pageSource1 = driver.getPageSource();
        if (pageSource1.contains("Let’s verify it’s you")) {
            Thread.sleep(20000);
        }
        if (pageSource1.contains("Simplify your sign-in")) {
            driver.findElement(By.id("passkeys-cancel-btn")).click();
            ScreenshotUtils.addStepInReport("STEP Number 3 Completed");
        }
    }

    @When("I select the jacket")
    public void iSelectTheJacket() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> jacket = driver.findElements(By.xpath("//div[@class='recs-image-frame']"));
        Logger.getLogger("Select Dress").info("No of jackets displayed : " + jacket.size());
        jacket.get(1).click();
        Thread.sleep(3000);
        ScreenshotUtils.attachScreenshot(driver, "Clicked on Jacket");
        Logger.getLogger("Select Dress").info("Clicked on Jacket");

    }

    @Then("Jacket details displayed")
    public void jacket_details_displayed() throws InterruptedException {
        String price = driver.findElement(By.className("x-price-primary")).getText();
        ScreenshotUtils.addStepInReport("jacket price : " + price);
        Logger.getLogger("Price").info(price);
        String condition = driver.findElement(By.className("x-item-condition-label")).getText();
        String quality = driver.findElement(By.className("ux-icon-text__text")).getText();
        ScreenshotUtils.addStepInReport(condition + " = " + quality);
        driver.findElement(By.className("ux-call-to-action__cell")).click();
        Thread.sleep(3000);
        ScreenshotUtils.attachScreenshot(driver,"Clicked on Buy It");
    }

    @Then("I checkout the Jacket")
    public void i_checkout_the_jacket() throws InterruptedException {
        String ShipDetails = driver.findElement(By.className("loadable-icon-and-text")).getText();
        String ShipAddress = driver.findElement(By.className("module-body")).getText();

        ScreenshotUtils.addStepInReport(ShipDetails + " ---> " + ShipAddress);
        driver.findElement(By.id("selectable-render-summary3")).click();

        ScreenshotUtils.attachScreenshot(driver,"Clicked on Paypal");

    }


    @And("Click on SignUp\\/Lofin button")
    public void clickOnSignUpLofinButton() {
    }
}
