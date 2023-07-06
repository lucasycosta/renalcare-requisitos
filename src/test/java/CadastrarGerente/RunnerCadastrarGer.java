package CadastrarGerente;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDGerenteRC.feature", 
				 glue = "CadastrarGerente",
				 tags = "@emailGerInvalido")
public class RunnerCadastrarGer {

}
