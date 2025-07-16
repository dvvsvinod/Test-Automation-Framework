package io.automation.core.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverContext {
    Logger LOGGER = LogManager.getLogger(DriverContext.class);
    private static final ThreadLocal<WebDriver> tWebDriver = new ThreadLocal<>();

    TestExecutionStrategy executionStrategy;
    public DriverContext(TestExecutionStrategy executionStrategy){
        this.executionStrategy = executionStrategy;
    }

    public void setExecutionStrategy(TestExecutionStrategy executionStrategy){
        this.executionStrategy = executionStrategy;
    }

    public WebDriver getDriverInstance(){
        tWebDriver.set(this.executionStrategy.setupDriver());
        LOGGER.info("Current Thread :: {}",Thread.currentThread().getName()+" and Driver Reference is {}", tWebDriver.get());
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tWebDriver.get();
    }
}
