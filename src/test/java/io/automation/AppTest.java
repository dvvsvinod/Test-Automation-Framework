package io.automation;

import io.automation.core.ui.DriverContext;
import io.automation.core.ui.LocalExecutionStrategy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AppTest {
    private WebDriver driver;


@Test
public void my_test_case_01(){
    DriverContext driverContext = new DriverContext(new LocalExecutionStrategy());
    driver = driverContext.getDriverInstance();
    driver.get("https://google.co.in");
    driver.close();
}


}
