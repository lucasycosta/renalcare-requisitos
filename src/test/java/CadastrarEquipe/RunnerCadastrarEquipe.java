package CadastrarEquipe;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/CadastrarEquipe/report-html/report.html", "json:src/test/java/CadastrarEquipe/report-json/report.json"},
				 features = "src/test/resources/CRUDEquipeRC.feature", 
				 glue = "CadastrarEquipe",
				 tags = "@equipe")
public class RunnerCadastrarEquipe {

}
