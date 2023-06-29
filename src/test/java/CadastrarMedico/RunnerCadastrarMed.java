package CadastrarMedico;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDMedicoRC.feature", 
				 glue = "CadastrarMedico",
				 tags = "@emailMedInvalido")
public class RunnerCadastrarMed {

}
