package stepdefinitions;

import io.automation.core.ui.DriverContext;
import io.automation.core.utils.ScreenshotUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SampleStepDefinitions {





    @Given("User opens chrome browser")
    public void user_opens_chrome_browser() {
        DriverContext.getDriver().get("https://google.co.in");
        if (true) { // Simulate a failure
            throw new AssertionError("Test failed intentionally");
        }
        ScreenshotUtil.saveScreenshot(DriverContext.getDriver());

    }
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        Assert.assertEquals(DriverContext.getDriver().getCurrentUrl(),"");
    }
    @When("User enters valid credentials as {string} and {string}")
    public void user_enters_valid_credentials_as_and(String string, String string2) {

    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {

    }
    @Then("User should see home page")
    public void user_should_see_home_page() {

    }

}
