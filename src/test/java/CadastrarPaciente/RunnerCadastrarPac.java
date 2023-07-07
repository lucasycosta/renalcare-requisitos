package CadastrarPaciente;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/CadastrarPaciente/report-html/report.html", "json:src/test/java/CadastrarPaciente/report-json/report.json"},
				 features = "src/test/resources/CRUDPacienteRC.feature", 
				 glue = "CadastrarPaciente",
				 tags = "@emailPacInvalido")
public class RunnerCadastrarPac {

}
