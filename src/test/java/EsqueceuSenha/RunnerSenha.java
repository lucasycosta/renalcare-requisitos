package EsqueceuSenha;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/EsqueceuSenha/report-html/report.html", "json:src/test/java/EsqueceuSenha/report-json/report.json"},
				 features = "src/test/resources/EsqueceuSenhaRC.feature", 
				 glue = "EsqueceuSenha",
				 tags = "@senha")
public class RunnerSenha {

}
