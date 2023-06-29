package Receita;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDReceitaRC.feature", 
				 glue = "Receita",
				 tags = "@excluirreceita")
public class RunnerReceita {

}
