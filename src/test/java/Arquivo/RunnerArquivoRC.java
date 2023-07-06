package Arquivo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/ArquivoRC.feature", 
				 glue = "Arquivo",
				 tags = "@lista")
public class RunnerArquivoRC {

}
