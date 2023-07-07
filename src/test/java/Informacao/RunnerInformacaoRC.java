package Informacao;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/Informacao/report-html/report.html", "json:src/test/java/Informacao/report-json/report.json"},
				 features = "src/test/resources/CRUDInformacaoRC.feature", 
				 glue = "Informacao",
				 tags = "@excluirinformacao")
public class RunnerInformacaoRC {

}
