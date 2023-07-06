package Noticia;

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

public class NoticiaRC {
	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement email;
	private WebElement noticia;
	private WebElement titulo;
	private WebElement dataPubli;
	private WebElement imagem;
	private WebElement texto;
	private WebElement mensagem;
	private WebElement tituloRetorno;
	private WebElement dataRetorno;
	private WebElement publiRetorno;
	private WebElement tituloCampo;
	private WebElement tituloNovo;
	private WebElement botaoAlterar;
	private WebElement buscar;
	private WebElement botaoDesabilitar;

	// BACKGROUND
	@Given("login noticia")
	public void login_noticia() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Noticia no menu")
	public void clicar_em_noticia_no_menu() throws InterruptedException {
		Thread.sleep(2000);
		noticia = driver.findElement(By.cssSelector("a[href='/news']"));
		noticia.click();
	}

	@When("abrir a tela de cadastro de Noticia")
	public void abrir_a_tela_de_cadastro_de_noticia() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/news"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/news", urlAtual);
	}

	// CADASTRAR COM SUCESSO
	@When("preencher campo com titulo {string}")
	public void preencher_campo_com_titulo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher campo com data da publicacao {string}")
	public void preencher_campo_com_data_da_publicacao(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		dataPubli = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='publishDate']")));
		dataPubli.sendKeys(string);
	}

	@When("preencher campo com imagem {string}")
	public void preencher_campo_com_imagem(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		imagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
		imagem.sendKeys(string);
	}

	@When("preencher campo com texto da noticia {string}")
	public void preencher_campo_com_texto_da_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		texto = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='text']")));
		texto.sendKeys(string);
	}

	@When("clicar no botao Cadastrar noticia")
	public void clicar_no_botao_cadastrar_noticia() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retorna a mensagem {string} para noticia")
	public void retorna_a_mensagem_para_noticia(String string) throws InterruptedException {

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

	// REGISTRAR NOTICIA COM CAMPOS VAZIOS
	@When("preencher tiulo {string} da noticia")
	public void preencher_tiulo_da_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher data da publicacao {string} da noticia")
	public void preencher_data_da_publicacao_da_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		dataPubli = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='publishDate']")));
		dataPubli.sendKeys(string);
	}

	@When("preencher imagem {string} da noticia")
	public void preencher_imagem_da_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		imagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
		imagem.sendKeys(string);
	}

	@When("preencher texto da noticia {string} noticia")
	public void preencher_texto_da_noticia_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		texto = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='text']")));
		texto.sendKeys(string);
	}

	@Then("retorna a mensagem {string} na tela de noticia")
	public void retorna_a_mensagem_na_tela_de_noticia(String string) {
		if (titulo.getAttribute("data-maska-value") == null) {
			String errorMessageTitulo = titulo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTitulo);
		} else if (dataPubli.getAttribute("data-maska-value") == null) {
			String errorMessageData = dataPubli.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageData);
		} else if (texto.getAttribute("textarea") == null) {
			String errorMessageTexto = texto.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTexto);
		}
	}

	// CONSULTAR NOTICIA
	@When("rolar pagina de noticia")
	public void rolar_pagina_de_noticia() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o noticia pelo {string}")
	public void buscar_o_noticia_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@Then("o retorna o titulo da noticia {string}")
	public void o_retorna_o_titulo_da_noticia(String string) throws InterruptedException {
		Thread.sleep(2000);
		tituloRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String tituloCampo = tituloRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, tituloCampo);
	}

	@Then("o retorna a data de cadastro da noticia {string}")
	public void o_retorna_a_data_de_cadastro_da_noticia(String string) {
		dataRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String dataCampo = dataRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, dataCampo);
	}

	@Then("o retorna a data de publicacao da noticia {string}")
	public void o_retorna_a_data_de_publicacao_da_noticia(String string) {
		publiRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String dataPublCampo = publiRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, dataPublCampo);
	}

	// ALTERAR NOTICIA
	@When("role pagina de noticia")
	public void role_pagina_de_noticia() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar noticia")
	public void inserir_para_buscar_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do noticia com {string} retorna")
	public void o_registro_do_noticia_com_retorna(String string) throws InterruptedException {
		Thread.sleep(2000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao de noticia")
	public void clicar_no_icone_de_edicao_de_noticia() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do noticia serao apresentados")
	public void os_dados_do_noticia_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o nome do noticia {string}")
	public void altere_o_nome_do_noticia(String string) {
		tituloNovo = driver.findElement(By.cssSelector("input[name='title']"));
		tituloNovo.clear();
		tituloNovo.sendKeys(string);

		driver.findElement(By.cssSelector("textarea[name='text']")).click();
	}

	@Then("clique em Alterar noticia")
	public void clique_em_alterar_noticia() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem de alteracao do cadastro da noticia {string}")
	public void mensagem_de_alteracao_do_cadastro_da_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	// DELETAR NOTICIA
	@When("role pagina de noticia para baixo")
	public void role_pagina_de_noticia_para_baixo() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca de noticia")
	public void insera_no_campo_de_busca_de_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do noticia do {string} retornar")
	public void o_registro_do_noticia_do_retornar(String string) throws InterruptedException {
		Thread.sleep(2000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão do noticia")
	public void clicar_no_icone_de_exclusão_do_noticia() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}

	@When("clicar em SIM para deletar noticia")
	public void clicar_em_sim_para_deletar_noticia() throws InterruptedException {
		Thread.sleep(2000);
		WebElement caixa = driver.findElement(By.cssSelector("div[name='content']"));
		botaoDesabilitar = caixa.findElement(By.xpath("//button[contains(text(), 'Sim')]"));
		botaoDesabilitar.click();
	}

	@Then("mensagem {string} de deletado noticia")
	public void mensagem_de_deletado_noticia(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	@After
	public void fecharNoticiaRC() {
		driver.quit();
	}
}
