package pages;

import ConfigProvider.ConfigProvider;
import org.openqa.selenium.UnhandledAlertException;
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
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;
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
    @FindBy(xpath = "//p[contains(text(),'Your email')]")
    WebElement errortext;
    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    WebElement emailExists;
    @FindBy(xpath = "//a[contains(text(),' Logout')]")
    WebElement logout;
    @FindBy(xpath = "//a[contains(text(),' Contact us')]")
    WebElement contactUs;
    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElement getInTouch;
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCases;
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement products;
    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    List<WebElement> viewProduct;
    @FindBy(name = "name")
    WebElement contactName;
    @FindBy(name = "email")
    WebElement contactEmail;
    @FindBy(name = "subject")
    WebElement contactSubject;
    @FindBy(name = "message")
    WebElement contactMessage;
    @FindBy(name = "upload_file")
    WebElement contactUploadFile;
    @FindBy(name = "submit")
    WebElement contactSubmit;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement contactUpdateSuccess;
    @FindBy(xpath = "//div[@id='accordian']/div/div/h4/a")
    List<WebElement> productCategory;

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
                case "Login to your account":
                    Assert.assertEquals(signUpText.get(0).getText(), value, "Login page is not displayed");
                    Logger.getLogger("Login Up Page").info("Login Header Validated");
                    break;
                case "Your email or password is incorrect!":
                    Assert.assertEquals(errortext.getText(), value, "Error text does not match");
                    ScreenshotUtils.addStepInReport(errortext.getText());
                    Logger.getLogger("Login Up Page").info("Login error Validated");
                    break;
                case "Email Address already exist!":
                    Assert.assertEquals(emailExists.getText(), value, "Email exists is not displayed");
                    ScreenshotUtils.addStepInReport(emailExists.getText());
                    Logger.getLogger("Login Up Page").info("Login error Validated");
                    break;
                case "GET IN TOUCH":
                    Assert.assertEquals(getInTouch.getText(), value, "Header does not match");
                    Logger.getLogger("Contact Us page").info("Header message validated");
                    break;
                default:
                    throw new RuntimeException("Not a valid header");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputNameAndEmail() {
        implicitWait(5);
        setInput(signUpName, ConfigProvider.getProperty("name"));
        setInput(signUpEmail, ConfigProvider.getProperty("email"));

    }

    public void inputNameAndEmailforLogin() {
        implicitWait(5);
        setInput(loginEmail, ConfigProvider.getProperty("email"));
        setInput(loginPassword, ConfigProvider.getProperty("password"));
    }

    public void inCorrectNameAndEmail() {
        implicitWait(5);
        setInput(loginEmail, ConfigProvider.getProperty("incorrectEmail"));
        setInput(loginPassword, ConfigProvider.getProperty("incorrectPassword"));
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
                case "Login":
                    clickElement(loginButton, "Login button clicked");
                    Logger.getLogger("Login page").info("Login button clicked");
                    break;
                case "Logout":
                    clickElement(logout, "Logout button ");
                    Logger.getLogger("Logout page").info("Logout  button clicked");
                    break;
                case "Contact Us":
                    clickElement(contactUs, "Contact us");
                    Logger.getLogger("Contact us").info("contact us button clicked");
                    break;
                case "Submit":
                    try {
                        scrollDown();
                        clickElementWithoutScreenshot(contactSubmit);
                        Logger.getLogger("Contact us").info("Submit button clicked");
                        switchToAlertAccept(); // Will now wait and check for alert
                        Logger.getLogger("Contact us").info("Pop Up ok clicked");
                    } catch (UnhandledAlertException e) {
                        e.printStackTrace();
                        Logger.getLogger("Contact us").warning("Error while handling alert: " + e.getMessage());
                    }
                    break;
                case "Test Cases":
                    clickElement(testCases, "Testcase");
                    Logger.getLogger("Testcase").info("Test case button clicked");
                    break;
                case "Products":
                    clickElement(products, "Products");
                    Logger.getLogger("Products").info("Products button clicked");
                    break;
                case "View Product":
                    scrollDown();
                    clickElement(viewProduct.get(0), "View Products");
                    Logger.getLogger("View Products").info("View Products button clicked");
                    break;
                default:
                    Assert.assertTrue(false, "No value to check");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterAccountInformation() {
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

    public void validateLoginPage() {
        if (driver.getCurrentUrl().contains("login")) {
            System.out.println("User navigated to login page");
            ScreenshotUtils.attachScreenshot(driver, "User navigated back to login page");
        } else {
            Assert.assertTrue(false, "User not naviagted");
        }
    }

    public void validateContactUsPage() {
        try {
            setInput(contactName, ConfigProvider.getProperty("name"));
            setInput(contactEmail, ConfigProvider.getProperty("email"));
            setInput(contactSubject, "Contact us Form Automation");
            setInput(contactMessage, "Automation message");
            uploadFile(contactUploadFile, "C:\\Users\\prade\\Test.txt");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void testCasePageValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Automation Practice Website for UI Testing - Test Cases","Title does not match");
    }
    public void productPageValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Automation Exercise - All Products","Title does not match");
        scrollDown();
        for(int i=0; i<productCategory.size(); i++){
            clickElement(productCategory.get(i), productCategory.get(i).getText());
        }
    }


}
