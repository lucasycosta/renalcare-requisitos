package Arquivo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/Arquivo/report-html/report.html", "json:src/test/java/Arquivo/report-json/report.json"},
				 features = "src/test/resources/ArquivoRC.feature", 
				 glue = "Arquivo",
				 tags = "@lista")
public class RunnerArquivoRC {

}
