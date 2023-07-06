package EsqueceuSenha;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EsqueceuSenhaRC {
	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";
	
	private WebElement primeiroBotao;
	private WebElement campoEmail;
	private WebElement botaoFinal;
	private WebElement mensagem;
	
	//LOGIN
	@Given("estar na tela login")
	public void estar_na_tela_login() {
		driver = new ChromeDriver();
	    driver.get(url);
	}

	@Given("clicar em {string}")
	public void clicar_em(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		primeiroBotao = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/auth/forgot']")));
		primeiroBotao.click();
	}

	@When("abrir a tela para digitar email")
	public void abrir_a_tela_para_digitar_email() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/auth/forgot"));
	    String urlAtual = driver.getCurrentUrl();
	    Assert.assertEquals("http://44.201.232.138:3000/auth/forgot", urlAtual);
	}
	
	//ESQUECI SENHA - EMAIL PREENCHIDO
	@When("digitar o {string}")
	public void digitar_o(String string) {
	    campoEmail = driver.findElement(By.cssSelector("input[name='email']"));
	    campoEmail.sendKeys(string);
	}

	@When("clicar no botao {string}")
	public void clicar_no_botao(String string) {
	    botaoFinal = driver.findElement(By.cssSelector("button[type='submit']"));
	    botaoFinal.click();
	}

	@Then("mostrara a {string}")
	public void mostrara_a(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		if(campoEmail != null) {
			mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p")));
			String texto = mensagem.getText();
			Assert.assertEquals(string, texto);
		}
	}
	
	//ESQUECEU SENHA - EMAIL VAZIO
	@When("digitar {string}")
	public void digitar(String string) {
		campoEmail = driver.findElement(By.cssSelector("input[name='email']"));
		campoEmail.sendKeys(string);
	}

	@Then("mostrara {string}")
	public void mostrara(String string) {
		driver.findElement(By.xpath("//span[contains(text(),'E-mail')]")).click();
		String errorMessageEmail = campoEmail.getAttribute("errormessage");
		Assert.assertEquals(string, errorMessageEmail);
	}
	
	@After
	public void fecharEsqueciSenhaRC() {
		driver.quit();
	}
	
}
