package Noticia;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
				 features = "src/test/java/features/CRUDNoticiaRC.feature", 
				 glue = "Noticia",
				 tags = "@noticia")
public class RunnerNoticia {

}
