package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public void setUserName(String user){
        driver.findElement(usernameField).sendKeys(user);
    }
    public void setPassWord(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void validateLogin(String user, String pass){
        setUserName(user);
        setPassWord(pass);
        clickLoginButton();
    }

}
