package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\features"},
		glue = {"stepDefinations","hooks"},
		publish = true
	//	plugin ={"pretty","html:target/CucumberReports/CucumberReport.html"}		
		
		)
	

public class MyRunner extends AbstractTestNGCucumberTests {

}
