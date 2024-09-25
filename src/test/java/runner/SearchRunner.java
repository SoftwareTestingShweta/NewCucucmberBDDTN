package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\features\\Search.feature"},
		glue = {"stepDefinations","hooks"}
		
		
		)

public class SearchRunner extends AbstractTestNGCucumberTests{

}
