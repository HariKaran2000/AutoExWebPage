package pageObjectManager;

import org.openqa.selenium.WebDriver;
import pages.AutomationExercisePage;

public class PageObjectManager {
    private  WebDriver driver;
    private AutomationExercisePage automationExercisePage;
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public AutomationExercisePage getAutomationExercisePage(){
        return (automationExercisePage == null)? automationExercisePage = new AutomationExercisePage(driver):automationExercisePage;
    }

}
