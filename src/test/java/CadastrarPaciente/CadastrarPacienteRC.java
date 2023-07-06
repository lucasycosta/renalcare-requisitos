package CadastrarPaciente;

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

public class CadastrarPacienteRC {

	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";
	
	private WebElement nome;
	private WebElement email;
	private WebElement sexo;
	private WebElement medico;
	private WebElement just;
	private WebElement cpf;
	private WebElement telefone;
	private WebElement data;
	private WebElement cns;
	private WebElement cadastrar;
	private WebElement mensagem;
	private WebElement nomeRetorno;
	private WebElement emailRetorno;
	private WebElement cpfRetorno;
	private WebElement nomeNovo;
	private WebElement botaoAlterar;
	private WebElement nomeCampo;
	private WebElement botaoDesabilitar;

	// BACKGROUND LOGIN
	@Given("login")
	public void login() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Cadastrar no menu lateral")
	public void clicar_em_cadastrar_no_menu_lateral() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		cadastrar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Cadastrar')]")));
		cadastrar.click();
	}

	@Given("clicar em Paciente dentro de Cadastrar")
	public void clicar_em_paciente_dentro_de_cadastrar() throws InterruptedException {
		Thread.sleep(1000);
		WebElement paciente = driver.findElement(By.cssSelector("a[href='/user/new?profile=patient']"));
		paciente.click();
	}

	@When("abrir a tela de cadastro de paciente")
	public void abrir_a_tela_de_cadastro_de_paciente() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/user/new?profile=patient"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/user/new?profile=patient", urlAtual);
	}

	// REGISTRAR PACIENTE COM SUCESSO
	@When("preencher campo nome {string}")
	public void preencher_campo_nome(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(name);
	}

	@When("preencher campo email {string}")
	public void preencher_campo_email(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher campo sexo {string}")
	public void preencher_campo_sexo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher campo medico {string}")
	public void preencher_campo_medico(String string) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		medico = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='doctor']")));
		medico.sendKeys(string);
	}

	@When("preencher campo justificativa {string}")
	public void preencher_campo_justificativa(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		just = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='accessNegatedReason']")));
		just.sendKeys(string);
	}

	@When("preencher campo cpf {string}")
	public void preencher_campo_cpf(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher campo telefone {string}")
	public void preencher_campo_telefone(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher campo data {string}")
	public void preencher_campo_data(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
	}

	@When("preencher campo cns {string}")
	public void preencher_campo_cns(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cns = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cns']")));
		cns.sendKeys(string);
	}

	@When("clicar no botao Cadastrar paciente")
	public void clicar_no_botao_cadastrar_paciente() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retornara a mensagem {string}")
	public void retornara_a_mensagem(String string) throws InterruptedException {
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

	// REGISTRAR PACIENTE CAMPOS VAZIOS

	@When("preencher nome {string}")
	public void preencher_nome(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		nome = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
		nome.sendKeys(string);
	}

	@When("preencher email {string}")
	public void preencher_email(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
	}

	@When("preencher sexo {string}")
	public void preencher_sexo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		sexo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='sex']")));
		sexo.sendKeys(string);
	}

	@When("preencher medico {string}")
	public void preencher_medico(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		medico = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='doctor']")));
		medico.sendKeys(string);
	}

	@When("preencher cpf {string}")
	public void preencher_cpf(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cpf = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cpf']")));
		cpf.sendKeys(string);
	}

	@When("preencher telefone {string}")
	public void preencher_telefone(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		telefone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='phone']")));
		telefone.sendKeys(string);
	}

	@When("preencher data {string}")
	public void preencher_data(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		data = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='dob']")));
		data.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("retorna a mensagem {string}")
	public void retorna_a_mensagem(String string) {
		if (nome.getAttribute("data-maska-value") == null) {
			String errorMessageNome = nome.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageNome);
		} else if (email.getAttribute("data-maska-value") == null) {
			String errorMessageEmail = email.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageEmail);
		} else if (sexo == null) {
			String errorMessageSexo = sexo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageSexo);
		} else if (medico == null) {
			String errorMessageMedico = medico.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageMedico);
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

	// CONSULTAR PACIENTE
	private WebElement buscar;

	@When("rolar a pagina")
	public void rolar_a_pagina() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o paciente pelo {string}")
	public void buscar_o_paciente_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
			   By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
			  .click();
	}

	@Then("o retorna o nome do paciente {string}")
	public void o_retorna_o_nome_do_paciente(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String nomeCampo = nomeRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, nomeCampo);
	}

	@Then("o retorna o email dopaciente {string}")
	public void o_retorna_o_email_dopaciente(String string) {
		emailRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String emailCampo = emailRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, emailCampo);
	}

	@Then("o retorna o cpf paciente {string}")
	public void o_retorna_o_cpf_paciente(String string) {
		cpfRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String cpfCampo = cpfRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, cpfCampo);
	}

	@Then("o retorna o telefone paciente {string}")
	public void o_retorna_o_telefone_paciente(String string) {
		WebElement telRetorno = driver.findElement(By.cssSelector("td[data-col='3']"));
		String telCampo = telRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, telCampo);
	}

	// ALTERAR PACIENTE
	@When("role a pagina")
	public void role_a_pagina() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar paciente")
	public void inserir_para_buscar_paciente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do paciente com {string} retornar")
	public void o_registro_do_paciente_com_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao")
	public void clicar_no_icone_de_edicao() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do paciente serao apresentados")
	public void os_dados_do_paciente_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o {string}")
	public void altere_o(String string) {
		nomeNovo = driver.findElement(By.cssSelector("input[name='name']"));
		nomeNovo.clear();
		nomeNovo.sendKeys(string);

		driver.findElement(By.cssSelector("input[name='email']")).click();
	}

	@Then("clique em Alterar")
	public void clique_em_alterar() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem {string}")
	public void mensagem(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// DESABILITAR PACIENTE

	@When("role pagina")
	public void role_pagina() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca")
	public void insera_no_campo_de_busca(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
			   By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
			  .click();
	}

	@When("o registro do paciente do {string} retornar")
	public void o_registro_do_paciente_do_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		nomeCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = nomeCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão")
	public void clicar_no_icone_de_exclusão() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}
	
	@When("clicar em SIM para desabilitar paciente")
	public void clicar_em_sim_para_desabilitar_paciente() throws InterruptedException {
		Thread.sleep(2000);
		WebElement caixa = driver.findElement(By.cssSelector("div[name='content']"));
		botaoDesabilitar = caixa.findElement(By.xpath("//button[contains(text(), 'Sim')]"));
		botaoDesabilitar.click();
	}

	@Then("mensagem {string} para paciente")
	public void mensagem_para_paciente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}
	
	//EMAIL INVALIDO
	@When("preencher o campo email invalido do paciente {string}")
	public void preencher_o_campo_email_invalido_do_paciente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys(string);
		
		driver.findElement(By.cssSelector("input[name='name']")).click();
	}

	@Then("mensagem {string} de email invalido paciente")
	public void mensagem_de_email_invalido_paciente(String string) {
		String errorMessageEmail = email.getAttribute("errormessage");
		Assert.assertEquals(string, errorMessageEmail);
	}
	
	@After
	public void fecharPacienteRC() {
		driver.quit();
	}

}
