package CadastrarMedico;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarMedicoRC {

	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement cadastrar;
	private WebElement medico;
	private WebElement mensagem;
	private WebElement nome;
	private WebElement email;
	private WebElement sexo;
	private WebElement crm;
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

	// BACKGROUND
	@Given("login medico")
	public void login_medico() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait	.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("lucasycosta@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Cadastrar no menu na lateral")
	public void clicar_em_cadastrar_no_menu_na_lateral() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cadastrar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Cadastrar')]")));
		cadastrar.click();
	}

	@Given("clicar em Medico dentro de Cadastrar")
	public void clicar_em_medico_dentro_de_cadastrar() throws InterruptedException {
		Thread.sleep(1000);
		medico = driver.findElement(By.cssSelector("a[href='/user/new?profile=doctor']"));
		medico.click();
	}

	@When("abrir a tela de cadastro de Medico")
	public void abrir_a_tela_de_cadastro_de_medico() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/user/new?profile=doctor"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/user/new?profile=doctor", urlAtual);
	}

	// REGISTRAR MEDICO COM SUCESSO
	@When("preencher campo com nome {string} medico")
	public void preencher_campo_com_nome_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(string);
	}

	@When("preencher campo com email {string} medico")
	public void preencher_campo_com_email_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher campo com sexo {string} medico")
	public void preencher_campo_com_sexo_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher campo com crm {string} medico")
	public void preencher_campo_com_crm_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		crm = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='crm']")));
		crm.sendKeys(string);
	}

	@When("preencher campo com cpf {string} medico")
	public void preencher_campo_com_cpf_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher campo com telefone {string} medico")
	public void preencher_campo_com_telefone_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher campo com data {string} medico")
	public void preencher_campo_com_data_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
	}

	@When("clicar no botao Cadastrar medico")
	public void clicar_no_botao_cadastrar_medico() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retorna a mensagem {string} para medico")
	public void retorna_a_mensagem_para_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(
					 By.cssSelector("p[class='flex rounded-md border px-4 py-3 text-left border-green-800 bg-green-100 text-green-800'")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// REGISTRAR MEDICO COM CAMPO VAZIO
	@When("preencher nome {string} do medico")
	public void preencher_nome_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(string);
	}

	@When("preencher email {string} do medico")
	public void preencher_email_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher sexo {string} do medico")
	public void preencher_sexo_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher crm {string} medico")
	public void preencher_crm_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		crm = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='crm']")));
		crm.sendKeys(string);
	}

	@When("preencher cpf {string} do medico")
	public void preencher_cpf_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher telefone {string} do medico")
	public void preencher_telefone_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher data {string} do medico")
	public void preencher_data_do_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("retorna a mensagem {string} na tela de medico")
	public void retorna_a_mensagem_na_tela_de_medico(String string) {
		if (nome.getAttribute("data-maska-value") == null) {
			String errorMessageNome = nome.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageNome);
		} else if (email.getAttribute("data-maska-value") == null) {
			String errorMessageEmail = email.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageEmail);
		} else if (sexo == null) {
			String errorMessageSexo = sexo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageSexo);
		} else if (crm.getAttribute("data-maska-value") == null) {
			String errorMessageCrm = crm.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageCrm);
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

	// CONSULTAR MEDICO
	@When("rolar pagina de medico")
	public void rolar_pagina_de_medico() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o medico pelo {string}")
	public void buscar_o_medico_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@Then("o retorna o nome do medico {string}")
	public void o_retorna_o_nome_do_medico(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String nomeCampo = nomeRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, nomeCampo);
	}

	@Then("o retorna o email do medico {string}")
	public void o_retorna_o_email_do_medico(String string) {
		emailRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String emailCampo = emailRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, emailCampo);
	}

	@Then("o retorna o cpf medico {string}")
	public void o_retorna_o_cpf_medico(String string) {
		cpfRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String cpfCampo = cpfRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, cpfCampo);
	}

	@Then("o retorna o telefone medico {string}")
	public void o_retorna_o_telefone_medico(String string) {
		telRetorno = driver.findElement(By.cssSelector("td[data-col='3']"));
		String telCampo = telRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, telCampo);
	}

	// ALTERAR MEDICO
	@When("role pagina de medico")
	public void role_pagina_de_medico() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar medico")
	public void inserir_para_buscar_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do medico com {string} retornar")
	public void o_registro_do_medico_com_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao de medico")
	public void clicar_no_icone_de_edicao_de_medico() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do medico serao apresentados")
	public void os_dados_do_medico_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o nome do medico {string}")
	public void altere_o_nome_do_medico(String string) {
		nomeNovo = driver.findElement(By.cssSelector("input[name='name']"));
		nomeNovo.clear();
		nomeNovo.sendKeys(string);

		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("clique em Alterar medico")
	public void clique_em_alterar_medico() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem de alteracao do cadastro {string}")
	public void mensagem_de_alteracao_do_cadastro(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// DELETAR MEDICO
	@When("role pagina de medico para baixo")
	public void role_pagina_de_medico_para_baixo() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca de medico")
	public void insera_no_campo_de_busca_de_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do medico do {string} retornar")
	public void o_registro_do_medico_do_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão do medico")
	public void clicar_no_icone_de_exclusão_do_medico() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}

	/*
	 * @Then("mensagem {string} de desabilitar medico") public void
	 * mensagem_de_desabilitar_medico(String string) { // Write code here that turns
	 * the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	//EMAIL INVALIDO
		@When("preencher o campo email invalido do medico {string}")
		public void preencher_o_campo_email_invalido_do_medico(String string) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
			email.sendKeys(string);
			
			driver.findElement(By.cssSelector("input[name='name']")).click();
		}

		@Then("mensagem {string} de email invalido medico")
		public void mensagem_de_email_invalido_medico(String string) {
			String errorMessageEmail = email.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageEmail);
		}
}
