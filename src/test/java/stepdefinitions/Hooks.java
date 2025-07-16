package stepdefinitions;

import io.automation.core.ui.DriverContext;
import io.automation.core.ui.LocalExecutionStrategy;
import io.automation.core.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void beforeScenario(){
        DriverContext driverContext = new DriverContext(new LocalExecutionStrategy());
        driver = driverContext.getDriverInstance();
    }


    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            ScreenshotUtil.saveScreenshot(driver);
        }
        driver.quit();
    }
}
