package logins;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/LoginRC.feature", 
				 glue = "logins",
				 tags = "")
public class RunnerLogin {
}
