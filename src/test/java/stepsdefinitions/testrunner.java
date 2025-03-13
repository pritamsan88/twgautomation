package stepsdefinitions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions
 (features = "src/test/resources/Features",
glue = {"stepsdefinitions"},
plugin = {"pretty","json:target/cucumber-reports/CucumberReport.json"},
monochrome = true,		
tags = "@puplist"
		)


public class testrunner extends AbstractTestNGCucumberTests {

}
