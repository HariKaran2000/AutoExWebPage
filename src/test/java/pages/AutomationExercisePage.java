package pages;

import ConfigProvider.ConfigProvider;
import io.cucumber.java.bs.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinition.DefaultStepDefinition;
import utils.BasePage;
import utils.ScreenshotUtils;

import java.util.List;
import java.util.logging.Logger;

public class AutomationExercisePage extends BasePage {
    public AutomationExercisePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    WebElement login;
    @FindBy(tagName = "H2")
    List<WebElement> signUpText;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signUpName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;


    public void VerifyHomePageTittle() {
        Logger.getLogger("Login page").info("Launched Automation Exercise page");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Exercise", "Title does not match");
        ScreenshotUtils.attachScreenshot(driver, "Tittle --> " + title);
    }

    public void clickOnLogin() {
        waitUntilClickable(login);
        clickElement(login, "Login button");
        Logger.getLogger("Sign Up Page").info("Opened Sign uUp or Login page");
    }

    public void verifyNewUserSignUpPage(String value){
        try{
         switch (value){
             case "New User Signup!":
                 Assert.assertEquals(signUpText.get(2).getText(),value,"Sign up text does not match");
                 Logger.getLogger("Sign Up Page").info("Header Validated");
                 break;
             default: Assert.assertTrue(false,"No value to check");
         }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void inputNameAndEmail(){
        implictWait(5);
        setInput(signUpName,ConfigProvider.getProperty("name"));
        setInput(signUpEmail,ConfigProvider.getProperty("email"));

    }
    public void buttonClick(String value){
        try{
            switch (value){
                case "Signup":
                    clickElement(signUpButton,"SignUp Button");
                    Logger.getLogger("Sign Up Page").info("SignUp Button clicked");
                    break;
                default: Assert.assertTrue(false,"No value to check");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
