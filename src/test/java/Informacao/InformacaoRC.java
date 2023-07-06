package Informacao;

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

public class InformacaoRC {
	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement email;
	private WebElement informacao;
	private WebElement titulo;
	private WebElement subtitulo;
	private WebElement texto;
	private WebElement mensagem;
	private WebElement tituloRetorno;
	private WebElement subRetorno;
	private WebElement dataRetorno;
	private WebElement tituloNovo;
	private WebElement botaoAlterar;
	private WebElement buscar;
	private WebElement tituloCampo;
	private WebElement botaoDesabilitar;

	// BACKGROUND
	@Given("login informacao")
	public void login_informacao() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em informacao")
	public void clicar_em_informacao() throws InterruptedException {
		Thread.sleep(2000);
		informacao = driver.findElement(By.cssSelector("a[href='/info']"));
		informacao.click();
	}

	@When("abrir a tela de cadastro de informacao")
	public void abrir_a_tela_de_cadastro_de_informacao() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/info"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/info", urlAtual);
	}

	
	//REGISTRAR INFOMACAO COM SUCESSO
	@When("preencher campo com titulo {string} informacao")
	public void preencher_campo_com_titulo_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher campo com subtitulo {string} informacao")
	public void preencher_campo_com_subtitulo_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		subtitulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='subtitle']")));
		subtitulo.sendKeys(string);
	}

	@When("preencher campo com texto {string} informacao")
	public void preencher_campo_com_texto_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		texto = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='text']")));
		texto.sendKeys(string);
	}

	@When("clicar no botao Cadastrar informacao")
	public void clicar_no_botao_cadastrar_informacao() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retorna a mensagem {string} para informacao")
	public void retorna_a_mensagem_para_informacao(String string) throws InterruptedException {

		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}

		Thread.sleep(3000);
		mensagem = driver.findElement(By.cssSelector(
				"p[class='flex items-center justify-between rounded-md border px-4 py-3 text-left border-green-800 bg-green-100 text-green-800']"));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	
	//REGISTRAR INFORMACAO COM CAMPOS VAZIOS
	@When("preencher titulo {string} do informacao")
	public void preencher_titulo_do_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher subtitulo {string} do informacao")
	public void preencher_subtitulo_do_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		subtitulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='subtitle']")));
		subtitulo.sendKeys(string);
	}

	@When("preencher texto {string} do informacao")
	public void preencher_texto_do_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		texto = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='text']")));
		texto.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='subtitle']")).click();
	}

	@Then("retorna a mensagem {string} na tela de informacao")
	public void retorna_a_mensagem_na_tela_de_informacao(String string) {
		if (titulo.getAttribute("data-maska-value") == null) {
			String errorMessageTitulo = titulo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTitulo);
		} else if (subtitulo.getAttribute("data-maska-value") == null) {
			String errorMessageSubtitulo = subtitulo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageSubtitulo);
		} else if (texto.getAttribute("textarea") == null) {
			String errorMessageTexto = texto.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTexto);
		} 
	}

	
	//CONSULTAR INFORMACAO
	@When("rolar pagina de informacao")
	public void rolar_pagina_de_informacao() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o informacao pelo {string}")
	public void buscar_o_informacao_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']")).click();
	}

	@Then("o retorna o titulo da informacao {string}")
	public void o_retorna_o_titulo_da_informacao(String string) throws InterruptedException{
		Thread.sleep(2000);
		tituloRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String tituloCampo = tituloRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, tituloCampo);
	}

	@Then("o retorna o subtitulo da informacao {string}")
	public void o_retorna_o_subtitulo_da_informacao(String string) {
		subRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String subCampo = subRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, subCampo);
	}

	@Then("o retorna o data de cadastro do informacao {string}")
	public void o_retorna_o_data_de_cadastro_do_informacao(String string) {
		dataRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String dataCampo = dataRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, dataCampo);
	}

	
	//ALTERAR INFORMACAO
	@When("role pagina de informacao")
	public void role_pagina_de_informacao() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar informacao")
	public void inserir_para_buscar_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do informacao com {string} retornar")
	public void o_registro_do_informacao_com_retornar(String string) throws InterruptedException{
		Thread.sleep(2000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='1'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao de informacao")
	public void clicar_no_icone_de_edicao_de_informacao() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do informacao serao apresentados")
	public void os_dados_do_informacao_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o titulo do informacao {string}")
	public void altere_o_titulo_do_informacao(String string) {
		tituloNovo = driver.findElement(By.cssSelector("select[name='title']"));
		tituloNovo.sendKeys(string);

		driver.findElement(By.cssSelector("input[name='subtitle']")).click();
	}

	@Then("clique em Alterar informacao")
	public void clique_em_alterar_informacao() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem de alteracao do cadastro da informacao {string}")
	public void mensagem_de_alteracao_do_cadastro_da_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	//DELETAR INFORMACAO
	@When("role pagina de informacao para baixo")
	public void role_pagina_de_informacao_para_baixo() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca de informacao")
	public void insera_no_campo_de_busca_de_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do informacao do {string} retornar")
	public void o_registro_do_informacao_do_retornar(String string) throws InterruptedException{
		Thread.sleep(2000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='1'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão do informacao")
	public void clicar_no_icone_de_exclusão_do_informacao() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}
	
	@When("clicar em SIM para deletar informacao")
	public void clicar_em_sim_para_deletar_informacao() throws InterruptedException {
		Thread.sleep(2000);
		WebElement caixa = driver.findElement(By.cssSelector("div[name='content']"));
		botaoDesabilitar = caixa.findElement(By.xpath("//button[contains(text(), 'Sim')]"));
		botaoDesabilitar.click();
	}

	@Then("mensagem {string} de desabilitar informacao")
	public void mensagem_de_desabilitar_informacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}
	
	@After
	public void fecharInformacaoRC() {
		driver.quit();
	}
}
