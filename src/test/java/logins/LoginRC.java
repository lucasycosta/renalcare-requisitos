package logins;

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

public class LoginRC {

	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";
	
	private WebElement email;
	private WebElement senha;
	private WebElement botao;
	private WebElement mensagem;

	// BACKGROUND
	@Given("estar na tela de login")
	public void estar_na_tela_de_login() {
		driver = new ChromeDriver();
		driver.get(url);
	}

	// LOGIN REALIZADO COM SUCESSO
	@When("inserir o e-mail {string}")
	public void inserir_o_e_mail(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("inserir a senha {string}")
	public void inserir_a_senha(String string) {
		senha = driver.findElement(By.cssSelector("input[name='password']"));
		senha.sendKeys(string);
	}
	
	@When("clicar no botão Entrar")
	public void clicar_no_botão_entrar() {
		botao = driver.findElement(By.cssSelector("button[type='submit']"));
		botao.click();
	}

	@Then("abrira a {string} inicial")
	public void abrira_a_inicial(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Cadastrar')]")));
	}

	// LOGIN INVALIDO
	@When("inserir e-mail {string}")
	public void inserir_e_mail(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("inserir senha {string}")
	public void inserir_senha(String string) {
		senha = driver.findElement(By.cssSelector("input[name='password']"));
		senha.sendKeys(string);
	}
	@When("clique em Entrar")
	public void clique_em_entrar() {
		botao = driver.findElement(By.cssSelector("button[type='submit']"));
		botao.click();
	}

	@Then("apresenta {string}")
	public void apresenta(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Login e/ou senha inválido(s)']")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// LOGIN COM CAMPOS VAZIOS
	@When("inserir um e-mail {string}")
	public void inserir_um_e_mail(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("inserir uma senha {string}")
	public void inserir_uma_senha(String string) {
		senha = driver.findElement(By.cssSelector("input[name='password']"));
		senha.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='email']")).click();
	}
	
	@Then("apresenta a mensagem {string}")
	public void apresenta_a_mensagem(String string) {
		
		if (email.getAttribute("data-maska-value") == null) {
			String errorMessageEmail = email.getAttribute("errormessage");
			Assert.assertEquals("O campo Email é obrigatório", errorMessageEmail);
		} else if (senha.getAttribute("data-maska-value") == null) {
			String errorMessageSenha = senha.getAttribute("errormessage");
			Assert.assertEquals("O campo Senha é obrigatório", errorMessageSenha);
		}
		/*
		 * else { WebElement invalido =
		 * driver.findElement(By.xpath("//span[@class='text-xs text-red-500']")); String
		 * invalidoTexto = invalido.getText();
		 * Assert.assertEquals("O campo Email deve ser um email válido", invalidoTexto);
		 * }
		 */
	}
	
	@After
	public void fecharLoginRC() {
		driver.quit();
	}
}
