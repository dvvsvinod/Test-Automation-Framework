package io.automation;

import io.automation.core.ui.DriverContext;
import io.automation.core.ui.LocalExecutionStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AppTest {
    private WebDriver driver;


public void my_test_case_01(){
    DriverContext driverContext = new DriverContext(new LocalExecutionStrategy());
    driver = driverContext.getDriverInstance();
    driver.get("https://demoqa.com/alerts");
    driver.findElement(By.xpath("//button[@id='alertButton']")).click();
    driver.close();
}
}
