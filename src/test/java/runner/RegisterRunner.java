package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resources\\features\\Register.feature"},
		glue = {"stepDefinations","hooks"}
		
		
		)

public class RegisterRunner extends AbstractTestNGCucumberTests{

}
