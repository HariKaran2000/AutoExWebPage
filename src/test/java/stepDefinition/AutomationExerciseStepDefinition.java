package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationExerciseStepDefinition extends AbstractSteps {
    public AutomationExerciseStepDefinition() {
        super();
    }



    @Given("I launch the browser")
    public void lauchBrowser() {
        startDriver();
    }

    @Then("I navigate to automation exercise URl")
    public void iNavigateToAutomationExerciseURl() {
        getDriver().get("https://automationexercise.com/");
    }

    @Then("Verify that home page is displayed")
    public void verifyThatHomePageIsDisplayed() {
        getPageObjectManager().getAutomationExercisePage().VerifyHomePageTittle();
    }

    @When("Click on SignUp or Login button")
    public void clickOnSignUpOrLoginButton() {
        getPageObjectManager().getAutomationExercisePage().clickOnLogin();
    }
    @Then("Verify {string} is visible")
    public void verify_is_visible(String string) {
       getPageObjectManager().getAutomationExercisePage().verifyNewUserSignUpPage(string);
    }
    @Then("Enter name and email address")
    public void enter_name_and_email_address() {
        getPageObjectManager().getAutomationExercisePage().inputNameAndEmail();
    }
    @Then("Click {string} button")
    public void click_button(String string) {
        getPageObjectManager().getAutomationExercisePage().buttonClick(string);

    }
    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String string) {

    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {

    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        
    }

    @Then("Verify that {string} is visible and click {string} button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
    }


}
