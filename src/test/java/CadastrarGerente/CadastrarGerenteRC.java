package CadastrarGerente;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarGerenteRC {
	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement cadastrar;
	private WebElement gerente;
	private WebElement mensagem;
	private WebElement nome;
	private WebElement email;
	private WebElement sexo;
	private WebElement cpf;
	private WebElement telefone;
	private WebElement data;
	private WebElement nomeRetorno;
	private WebElement emailRetorno;
	private WebElement cpfRetorno;
	private WebElement telRetorno;
	private WebElement nomeNovo;
	private WebElement botaoAlterar;
	private WebElement buscar;
	private WebElement nomeCampo;
	private WebElement botaoDesabilitar;

	// BACKGROUND
	@Given("login Gerente")
	public void login_gerente() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Cadastrar no menu a esquerda")
	public void clicar_em_cadastrar_no_menu_a_esquerda() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cadastrar = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Cadastrar')]")));
		cadastrar.click();
	}

	@Given("clicar em Gerente dentro de Cadastrar")
	public void clicar_em_gerente_dentro_de_cadastrar() throws InterruptedException {
		Thread.sleep(1000);
		gerente = driver.findElement(By.cssSelector("a[href='/user/new?profile=manager']"));
		gerente.click();
	}

	@When("abrir a tela de cadastro de gerente")
	public void abrir_a_tela_de_cadastro_de_gerente() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/user/new?profile=manager"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/user/new?profile=manager", urlAtual);
	}

	// REGISTRAR GERENTE COM SUCESSO
	@When("preencher campo com nome {string}")
	public void preencher_campo_com_nome(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(string);
	}

	@When("preencher campo com email {string}")
	public void preencher_campo_com_email(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher campo com sexo {string}")
	public void preencher_campo_com_sexo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher campo com cpf {string}")
	public void preencher_campo_com_cpf(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher campo com telefone {string}")
	public void preencher_campo_com_telefone(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher campo com data {string}")
	public void preencher_campo_com_data(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
	}

	@When("clicar no botao Cadastrar gerente")
	public void clicar_no_botao_cadastrar_gerente() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retorna a mensagem {string} para gerente")
	public void retorna_a_mensagem_para_gerente(String string) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}

		Thread.sleep(2000);
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p[data-v-bf21962e]")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// REGISTRAR GERENTE COM CAMPO VAZIO
	@When("preencher nome {string} do gerente")
	public void preencher_nome_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(string);
	}

	@When("preencher email {string} do gerente")
	public void preencher_email_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher sexo {string} do gerente")
	public void preencher_sexo_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher cpf {string} do gerente")
	public void preencher_cpf_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher telefone {string} do gerente")
	public void preencher_telefone_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher data {string} do gerente")
	public void preencher_data_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("retorna a mensagem {string} na tela de gerente")
	public void retorna_a_mensagem_na_tela_de_gerente(String string) {

		if (nome.getAttribute("data-maska-value") == null) {
			String errorMessageNome = nome.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageNome);
		} else if (email.getAttribute("data-maska-value") == null) {
			String errorMessageEmail = email.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageEmail);
		} else if (sexo == null) {
			String errorMessageSexo = sexo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageSexo);
		} else if (cpf.getAttribute("data-maska-value") == null) {
			String errorMessageCpf = cpf.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageCpf);
		} else if (telefone.getAttribute("data-maska-value") == null) {
			String errorMessageTelefone = telefone.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTelefone);
		} else if (data.getAttribute("data-maska-value") == null) {
			String errorMessageData = data.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageData);
		}
	}

	// CONSULTAR GERENTE
	@When("rolar pagina")
	public void rolar_pagina() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o gerente pelo {string}")
	public void buscar_o_gerente_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@Then("o retorna o nome do gerente {string}")
	public void o_retorna_o_nome_do_gerente(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String nomeCampo = nomeRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, nomeCampo);
	}

	@Then("o retorna o email do gerente {string}")
	public void o_retorna_o_email_do_gerente(String string) {
		emailRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String emailCampo = emailRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, emailCampo);
	}

	@Then("o retorna o cpf gerente {string}")
	public void o_retorna_o_cpf_gerente(String string) {
		cpfRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String cpfCampo = cpfRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, cpfCampo);
	}

	@Then("o retorna o telefone gerente {string}")
	public void o_retorna_o_telefone_gerente(String string) {
		telRetorno = driver.findElement(By.cssSelector("td[data-col='3']"));
		String telCampo = telRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, telCampo);
	}

	// ALTERAR GERENTE
	@When("role pagina de gerente")
	public void role_pagina_de_gerente() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar Gerente")
	public void inserir_para_buscar_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do gerente com {string} retornar")
	public void o_registro_do_gerente_com_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebElement nomeCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao de gerente")
	public void clicar_no_icone_de_edicao_de_gerente() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do gerente serao apresentados")
	public void os_dados_do_gerente_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o nome do gerente {string}")
	public void altere_o_nome_do_gerente(String string) {
		nomeNovo = driver.findElement(By.cssSelector("input[name='name']"));
		nomeNovo.clear();
		nomeNovo.sendKeys(string);

		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("clique em Alterar gerente")
	public void clique_em_alterar_gerente() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem de alteracao {string}")
	public void mensagem_de_alteracao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// DEASBILITAR GERENTE
	@When("role pagina para baixo")
	public void role_pagina_para_baixo() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca de gerente")
	public void insera_no_campo_de_busca_de_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do gerente do {string} retornar")
	public void o_registro_do_gerente_do_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão do gerente")
	public void clicar_no_icone_de_exclusão_do_gerente() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}

	@When("clicar em SIM para desabilitar gerente")
	public void clicar_em_sim_para_desabilitar_gerente() throws InterruptedException {
		Thread.sleep(2000);
		WebElement caixa = driver.findElement(By.cssSelector("div[name='content']"));
		botaoDesabilitar = caixa.findElement(By.xpath("//button[contains(text(), 'Sim')]"));
		botaoDesabilitar.click();
	}

	@Then("mensagem {string} de desabilitar gerente")
	public void mensagem_de_desabilitar_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// EMAIL INVALIDO
	@When("preencher o campo email invalido do gerente {string}")
	public void preencher_o_campo_email_invalido_do_gerente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);

		driver.findElement(By.cssSelector("input[name='name']")).click();
	}

	@Then("mensagem {string} de email invalido gerente")
	public void mensagem_de_email_invalido_gerente(String string) {
		String errorMessageEmail = email.getAttribute("errormessage");
		Assert.assertEquals(string, errorMessageEmail);
	}
	
	@After
	public void fecharGerenteRC() {
		driver.quit();
	}
}
