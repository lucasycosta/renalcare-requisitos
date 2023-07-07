package CadastrarGerente;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/CadastrarGerente/report-html/report.html", "json:src/test/java/CadastrarGerente/report-json/report.json"},
				 features = "src/test/resources/CRUDGerenteRC.feature", 
				 glue = "CadastrarGerente",
				 tags = "@emailGerInvalido")
public class RunnerCadastrarGer {

}
