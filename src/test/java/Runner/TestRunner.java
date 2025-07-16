package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features/Sample.feature",
glue = "stepdefinitions",
plugin = {"pretty",
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
"html:target/cucumber-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
