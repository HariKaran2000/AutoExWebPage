package stepDefinition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BasePage;
import utils.DriverManager;
import utils.ScreenshotUtils;


public class LoginStepDefinition extends BasePage {


    WebDriver driver = DriverManager.getDriver();

    public LoginStepDefinition(WebDriver driver) {
        super(driver);
    }

//    @Given("I launch the browser")
//    public void i_launch_the_browser() throws IOException, InstantiationException, IllegalAccessException {
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hari S\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//
//    }


    @When("I am on the ebay login page")
    public void i_am_on_the_ebay_login_page() throws IOException {
        driver.get("https://www.ebay.com/");
        Logger.getLogger("Web Driver").info("Ebay Website Launched");
        ScreenshotUtils.attachScreenshot(driver, "Login to Ebay");
        ScreenshotUtils.addStepInReport("STEP Number 1 Completed");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay", "Title does not match");;
        Logger.getLogger("Ebay").info("Ebay Title verified");
        ScreenshotUtils.addStepInReport(title);
        ScreenshotUtils.addStepInReport("STEP Number 2 Completed");
    }

    @Then("I enter username and password")
    public void i_enter_username_and_password() throws IOException, InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
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
            implictWait(20);
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

    @Then("I verify login successful")
    public void i_verify_login_successful() throws InterruptedException {
        Thread.sleep(5000);
        ScreenshotUtils.attachScreenshot(driver, "User Signed In");
        ScreenshotUtils.addStepInReport("Page Title " + driver.getTitle());
        ScreenshotUtils.addStepInReport("STEP Number 4 Completed");
    }

    @When("I get all the links from the page and validate the status")
    public void i_get_all_the_links_from_the_page() throws IOException {
        List<WebElement> links = driver.findElements(By.tagName("A"));
        Logger.getLogger("Links").info("no of links present in login page is = " + links.size());

        for (WebElement ele : links) {
            String url = ele.getDomAttribute("href");
            assert url != null;
            if (url.equals("#mainContent")) {
                Logger.getLogger("URL").info("Ignoring First url");
            } else {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    Logger.getLogger("URL").info(ele.getText() + " URL = " + url + " is valid");
                    ScreenshotUtils.addStepInReport(responseCode + " URL = " + url);
                } else {
                    Logger.getLogger("URL").info(ele.getText() + " URL = " + url + " invalid");
                    ScreenshotUtils.addStepInReportFail(responseCode + " URL = " + url);
                }
            }


        }

    }

    @Then("Validate actions")
    public void validateActions() {
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(By.className(""));
        actions.moveToElement(ele).perform();

    }


}
