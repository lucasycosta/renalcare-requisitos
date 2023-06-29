package Informacao;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDInformacaoRC.feature", 
				 glue = "Informacao",
				 tags = "@excluirinformacao")
public class RunnerInformacaoRC {

}
