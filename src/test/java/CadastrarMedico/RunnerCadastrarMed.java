package CadastrarMedico;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/CadastrarMedico/report-html/report.html", "json:src/test/java/CadastrarMedico/report-json/report.json"},
				 features = "src/test/resources/CRUDMedicoRC.feature", 
				 glue = "CadastrarMedico",
				 tags = "@excluirMed")
public class RunnerCadastrarMed {

}
