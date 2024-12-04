package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"}, // Path to the feature files
		glue = {"StepDefinitions","Utilities"},     // Path to the step definition package and 
		plugin = {
				"pretty",                             
				"html:target/cucumber-reports.html",  // HTML report
				"json:target/cucumber-reports.json",  
				"junit:target/cucumber-reports.xml"   
		},
		monochrome = true,                       
		tags = "@CreateAccount or @Login",     
		dryRun = false                           
		)

public class TestRunner {
}
