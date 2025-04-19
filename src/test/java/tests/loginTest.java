package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BasePage;
import pages.loginPage;

public class loginTest extends BasePage {
    public loginTest(WebDriver driver) {
        super(driver);
    }

//    public loginTest(WebDriver driver) {
//        super(driver);
//    }
//
//    @Test
//    public void login(){
//        loginPage login = new loginPage(driver);
//        login.validateLogin("standard_user","secret_sauce");
//    }

}
