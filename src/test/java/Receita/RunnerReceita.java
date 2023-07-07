package Receita;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/Receita/report-html/report.html", "json:src/test/java/Receita/report-json/report.json"},
				 features = "src/test/resources/CRUDReceitaRC.feature", 
				 glue = "Receita",
				 tags = "@excluirreceita")
public class RunnerReceita {

}
