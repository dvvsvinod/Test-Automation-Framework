package io.automation.core.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;
public class ScreenshotUtil {


    @Attachment(value="FailureScreenshot",type="image/jpeg",fileExtension = ".jpeg")
    public static byte[] saveScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
