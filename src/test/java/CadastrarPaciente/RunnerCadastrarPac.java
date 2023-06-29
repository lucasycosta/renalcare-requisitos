package CadastrarPaciente;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDPacienteRC.feature", 
				 glue = "CadastrarPaciente",
				 tags = "@emailPacInvalido")
public class RunnerCadastrarPac {

}
