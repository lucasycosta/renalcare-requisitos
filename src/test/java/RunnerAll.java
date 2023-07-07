import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report-html/report.html", "json:target/report-json/report.json"},
				 features = "src/test/resources", 
				 tags = "@web")
public class RunnerAll {

}
