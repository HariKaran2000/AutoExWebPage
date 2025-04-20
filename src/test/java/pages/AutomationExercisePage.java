package pages;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement signUpPassword;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;
    @FindBy(tagName = "B")
    List<WebElement> accountInfoHeader;
    @FindBy(id = "id_gender1")
    WebElement maleGender;
    @FindBy(id = "id_gender2")
    WebElement femMaleGender;
    @FindBy(id = "days")
    WebElement day;
    @FindBy(id = "months")
    WebElement month;
    @FindBy(id = "years")
    WebElement year;
    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkBox;
    @FindBy(id = "last_name")
    WebElement lastName;
    @FindBy(id = "first_name")
    WebElement firstName;
    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "address1")
    WebElement address1;
    @FindBy(id = "address2")
    WebElement address2;
    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "zipcode")
    WebElement zipCode;
    @FindBy(id = "mobile_number")
    WebElement mobileNumber;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccount;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;
    @FindBy(xpath = "//a[contains(text(),' Logged in as')]/b")
    WebElement loggedInUser;
    @FindBy(xpath = "//a[contains(text(),' Delete Account')]")
    WebElement deleteAccount;

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

    public void verifyHeader(String value) {
        try {
            switch (value) {
                case "New User Signup!":
                    Assert.assertEquals(signUpText.get(2).getText(), value, "Sign up text does not match");
                    Logger.getLogger("Sign Up Page").info("Header Validated");
                    break;
                case "ENTER ACCOUNT INFORMATION":
                    Assert.assertEquals(accountInfoHeader.get(0).getText(), value, "Account Info header does not match");
                    Logger.getLogger("Sign Up Page").info("Account information Header Validated");
                    break;
                case "ACCOUNT CREATED!", "ACCOUNT DELETED!":
                    Assert.assertEquals(accountInfoHeader.get(0).getText(), value, "ACCOUNT is not created/Deleted");
                    Logger.getLogger("Sign Up Page").info("ACCOUNT CREATED!/ACCOUNT DELETED! Header Validated");
                    break;
                case "Logged in as username":
                    Assert.assertEquals(loggedInUser.getText(), ConfigProvider.getProperty("name"), "Logged in user is different");
                    Logger.getLogger("Home Page").info("Logged in user validated");
                    break;
                default:
                    throw new RuntimeException("Not a valid header");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputNameAndEmail() {
        implictWait(5);
        setInput(signUpName, ConfigProvider.getProperty("name"));
        setInput(signUpEmail, ConfigProvider.getProperty("email"));

    }

    public void buttonClick(String value) {
        try {
            switch (value) {
                case "Signup":
                    clickElement(signUpButton, "SignUp Button");
                    Logger.getLogger("Sign Up Page").info("SignUp Button clicked");
                    break;
                case "Continue":
                    clickElement(continueButton, "Continue button");
                    Logger.getLogger("Account creation page").info("Clicked on Continue");
                    break;
                case "Delete Account":
                    clickElement(deleteAccount, "Delete account");
                    Logger.getLogger("Home Page").info("Clicked on Continue");
                    break;
                default:
                    Assert.assertTrue(false, "No value to check");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterAccountInfo() {
        try {
            if (ConfigProvider.getProperty("gender").equals("male")) {
                clickElement(maleGender, "MR");
                Logger.getLogger("Sign Up Page").info("Selected gender male");
            } else if (ConfigProvider.getProperty("gender").equals("female")) {
                clickElement(femMaleGender, "Mrs");
                Logger.getLogger("Sign Up Page").info("Selected gender Female");
            }
            setInput(signUpPassword, ConfigProvider.getProperty("password"));
            scrollDown();
            selectElementByValue(day, "23");
            selectElementByValue(month, "9");
            selectElementByValue(year, "2000");
            Logger.getLogger("Sign Up Page").info("Selected Date of birth");
            clickElement(checkBox.get(0), "Newsletter checkbox");
            clickElement(checkBox.get(1), "Receive special offers checkbox");
            Logger.getLogger("Sign Up Page").info("Selected checkbox");
            setInput(firstName, ConfigProvider.getProperty("name"));
            setInput(lastName, ConfigProvider.getProperty("lastName"));
            setInput(company, "ABC Company");
            scrollDown();
            setInput(address1, ConfigProvider.getProperty("address1"));
            setInput(address2, ConfigProvider.getProperty("address2"));
            setInput(state, ConfigProvider.getProperty("state"));
            setInput(city, ConfigProvider.getProperty("city"));
            setInput(zipCode, ConfigProvider.getProperty("zip"));
            scrollDown();
            setInput(mobileNumber, ConfigProvider.getProperty("mobile"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAccount() {
        clickElement(createAccount, "Create Account");
    }

}
