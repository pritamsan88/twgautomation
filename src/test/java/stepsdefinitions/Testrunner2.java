package stepsdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",glue = {"stepsdefinitions"},
monochrome = true,
plugin= {"pretty","html:target/HtmlReports"},
tags="@addtocart")
public class Testrunner2 {

}
