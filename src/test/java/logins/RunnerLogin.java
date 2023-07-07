package logins;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/logins/report-html/report.html", "json:src/test/java/logins/report-json/report.json"},
				 features = "src/test/resources/LoginRC.feature", 
				 glue = "logins",
				 tags = "")
public class RunnerLogin {
}
