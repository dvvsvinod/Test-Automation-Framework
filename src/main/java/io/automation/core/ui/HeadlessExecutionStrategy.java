package io.automation.core.ui;

import io.automation.core.config.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class HeadlessExecutionStrategy implements TestExecutionStrategy{
    Logger LOGGER = LogManager.getLogger(HeadlessExecutionStrategy.class);
    ConfigManager config = ConfigManager.getInstance();
    @Override
    public WebDriver setupDriver() {
        switch (config.getConfig().getUiConfigData().getBrowserType()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("-headless");
                LOGGER.info("Launched browser :: {}",config.getConfig().getUiConfigData().getBrowserType());
                return new ChromeDriver(options);
            case "safari":
                LOGGER.info("Launched browser :: {}",config.getConfig().getUiConfigData().getBrowserType());
                return new SafariDriver();
            default:
                LOGGER.error("Provide the valid browser name :: Current provided browser type :: {}",config.getConfig().getUiConfigData().getBrowserType());
                throw new IllegalStateException("Provide the valid browser name :: Current provided browser type "+ config.getConfig().getUiConfigData().getBrowserType());
        }
    }
}
