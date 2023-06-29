package CadastrarEquipe;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDEquipeRC.feature", 
				 glue = "CadastrarEquipe",
				 tags = "@equipe")
public class RunnerCadastrarEquipe {

}
