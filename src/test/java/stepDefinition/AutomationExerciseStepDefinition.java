package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
       getPageObjectManager().getAutomationExercisePage().verifyHeader(string);
    }
    @Then("Enter name and email address")
    public void enter_name_and_email_address() {
        getPageObjectManager().getAutomationExercisePage().inputNameAndEmail();
    }
    @Then("Click {string} button")
    public void click_button(String string) {
        getPageObjectManager().getAutomationExercisePage().buttonClick(string);

    }

    @Then("Fill details: for account registration with valid information")
    public void fill_details_title_name_email_password_date_of_birth() {
        getPageObjectManager().getAutomationExercisePage().enterAccountInformation();
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        getPageObjectManager().getAutomationExercisePage().createAccount();
    }
    @And("Enter name and email address for login user")
    public void enterNameAndEmailAddressForLoginUser() {
        getPageObjectManager().getAutomationExercisePage().inputNameAndEmailforLogin();
    }

    @And("Enter In Correct name and email address for login user")
    public void enterInCorrectNameAndEmailAddressForLoginUser() {
        getPageObjectManager().getAutomationExercisePage().inCorrectNameAndEmail();
    }


    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        getPageObjectManager().getAutomationExercisePage().validateLoginPage();
    }

    @And("Enter name, email, subject and message and upload")
    public void enterNameEmailSubjectAndMessage() {
        getPageObjectManager().getAutomationExercisePage().validateContactUsPage();
    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        getPageObjectManager().getAutomationExercisePage().testCasePageValidation();
    }

    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        getPageObjectManager().getAutomationExercisePage().productPageValidation();
    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
    }

    @And("Enter product name in search input and click search button")
    public void enterProductNameInSearchInputAndClickSearchButton() {
        
    }

    @Then("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
    }
}
