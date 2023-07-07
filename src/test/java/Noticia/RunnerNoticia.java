package Noticia;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:src/test/java/Noticia/report-html/report.html", "json:src/test/java/Noticia/report-json/report.json"},
				 features = "src/test/resources/CRUDNoticiaRC.feature", 
				 glue = "Noticia",
				 tags = "@noticia")
public class RunnerNoticia {

}
