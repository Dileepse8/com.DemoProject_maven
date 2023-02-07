package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//FeaturesFile/",
		//features= {"FeaturesFile/Login.feature","FeaturesFile/Customers.feature"},
		features="FeaturesFile/Customers.feature",
		glue="stepDefinations",
		dryRun=false,
		//dryRun=true,
		monochrome=true,
		//tags= ("@sanity"),
		tags= ("@sanity ,@regression"),
		plugin= {"pretty","html:test-output.html"}
		
		)
public class Login_runner {

}
