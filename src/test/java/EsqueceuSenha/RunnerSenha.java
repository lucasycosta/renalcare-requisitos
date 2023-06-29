package EsqueceuSenha;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/EsqueceuSenhaRC.feature", 
				 glue = "EsqueceuSenha",
				 tags = "@senha")
public class RunnerSenha {

}
