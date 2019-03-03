package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "Steps", plugin = {"html:target/cucumber-html-report",
		"html:target/cucumber-json-report.json"}, tags={"@Test2"})

public class TestRunner {

}