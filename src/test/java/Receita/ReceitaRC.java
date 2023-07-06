package Receita;

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

public class ReceitaRC {
	
	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement email;
	private WebElement receita;
	private WebElement titulo;
	private WebElement imagem;
	private WebElement ingredientes;
	private WebElement preparo;
	private WebElement obs;
	private WebElement mensagem;
	private WebElement tituloRetorno;
	private WebElement dataRetorno;
	private WebElement tituloCampo;
	private WebElement tituloNovo;
	private WebElement botaoAlterar;
	private WebElement buscar;
	private WebElement botaoDesabilitar;
	
	//BACKGROUND
	@Given("login receita")
	public void login_receita() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait	.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Receita")
	public void clicar_em_receita()  throws InterruptedException {
		Thread.sleep(2000);
		receita = driver.findElement(By.cssSelector("a[href='/recipe']"));
		receita.click();
	}

	@When("abrir a tela de cadastro de receita")
	public void abrir_a_tela_de_cadastro_de_receita() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.urlToBe("http://44.201.232.138:3000/recipe"));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals("http://44.201.232.138:3000/recipe", urlAtual);
	}

	//CADASTRAR COM SUCESSO
	@When("preencher campo com titulo {string} receita")
	public void preencher_campo_com_titulo_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher campo com imagem {string} receita")
	public void preencher_campo_com_imagem_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		imagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
		imagem.sendKeys(string);
	}

	@When("preencher campo com ingredientes {string} receita")
	public void preencher_campo_com_ingredientes_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		ingredientes = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='ingredients']")));
		ingredientes.sendKeys(string);
	}

	@When("preencher campo com preparo {string} receita")
	public void preencher_campo_com_preparo_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		preparo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='instructions']")));
		preparo.sendKeys(string);
	}

	@When("preencher campo com observacao {string} receita")
	public void preencher_campo_com_observacao_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		obs = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='extra']")));
		obs.sendKeys(string);
	}

	@When("clicar no botao Cadastrar receita")
	public void clicar_no_botao_cadastrar_receita() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("retorna a mensagem {string} para receita")
	public void retorna_a_mensagem_para_receita(String string) throws InterruptedException {
		
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
		
		Thread.sleep(3000);
		mensagem = driver.findElement(By.cssSelector("p[class='flex items-center justify-between rounded-md border px-4 py-3 text-left border-green-800 bg-green-100 text-green-800']"));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);	
	}

	//REGISTRAR RECEITA COM CAMPOS VAZIOS
	@When("preencher titulo {string} do receita")
	public void preencher_titulo_do_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		titulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='title']")));
		titulo.sendKeys(string);
	}

	@When("preencher imagem {string} do receita")
	public void preencher_imagem_do_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		imagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
		imagem.sendKeys(string);
	}

	@When("preencher ingredientes {string} do receita")
	public void preencher_ingredientes_do_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		ingredientes = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='ingredients']")));
		ingredientes.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='title']")).click();
	}

	@When("preencher preparo {string} receita")
	public void preencher_preparo_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		preparo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='instructions']")));
		preparo.sendKeys(string);
		driver.findElement(By.cssSelector("input[name='title']")).click();
	}

	@When("preencher observacao {string} do receita")
	public void preencher_observacao_do_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		obs = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='extra']")));
		obs.sendKeys(string);
	}

	@Then("retorna a mensagem {string} na tela de receita")
	public void retorna_a_mensagem_na_tela_de_receita(String string) {
		
		if (titulo.getAttribute("data-maska-value") == null) {
			String errorMessageTitulo = titulo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageTitulo);
		} else if (ingredientes.getAttribute("textarea") == null) {
			String errorMessageIngrediente = ingredientes.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessageIngrediente);
		} else if (preparo.getAttribute("textarea") == null) {
			String errorMessagePreparo = preparo.getAttribute("errormessage");
			Assert.assertEquals(string, errorMessagePreparo);
		} 
	}

	//CONSULTAR INFORMACAO
	@When("rolar pagina de receita")
	public void rolar_pagina_de_receita() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("buscar o receita pelo {string}")
	public void buscar_o_receita_pelo(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']")).click();
	}

	@Then("o retorna o titulo da receita {string}")
	public void o_retorna_o_titulo_da_receita(String string) throws InterruptedException{
		Thread.sleep(2000);
		tituloRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String tituloCampo = tituloRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, tituloCampo);
	}

	@Then("o retorna o data de cadastro do receita {string}")
	public void o_retorna_o_data_de_cadastro_do_receita(String string) {
		dataRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String dataCampo = dataRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, dataCampo);
	}

	//ALTERAR NOTICIA
	@When("role pagina de receita")
	public void role_pagina_de_receita() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("inserir {string} para buscar receita")
	public void inserir_para_buscar_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do receita com {string} retornar")
	public void o_registro_do_receita_com_retornar(String string) throws InterruptedException{
		Thread.sleep(2000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de edicao de receita")
	public void clicar_no_icone_de_edicao_de_receita() {
		driver.findElement(By.cssSelector("div[data-tip='Editar']")).click();
	}

	@When("os dados do receita serao apresentados")
	public void os_dados_do_receita_serao_apresentados() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
		}
	}

	@Then("altere o titulo do receita {string}")
	public void altere_o_titulo_do_receita(String string) {
		tituloNovo = driver.findElement(By.cssSelector("input[name='title']"));
		tituloNovo.clear();
		tituloNovo.sendKeys(string);

		driver.findElement(By.cssSelector("textarea[name='ingredients']")).click();
	}

	@Then("clique em Alterar receita")
	public void clique_em_alterar_receita() {
		botaoAlterar = driver.findElement(By.cssSelector("button[type='submit']"));
		botaoAlterar.click();
	}

	@Then("mensagem de alteracao do cadastro da receita {string}")
	public void mensagem_de_alteracao_do_cadastro_da_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}

	//DELETAR NOTICIA
	@When("role pagina de receita para baixo")
	public void role_pagina_de_receita_para_baixo() {
		int qtdScrolls = 10;
		for (int i = 0; i < qtdScrolls; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}
	}

	@When("insera {string} no campo de busca de receita")
	public void insera_no_campo_de_busca_de_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(
				By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']"))
				.click();
	}

	@When("o registro do receita do {string} retornar")
	public void o_registro_do_receita_do_retornar(String string) throws InterruptedException{
		Thread.sleep(1000);
		tituloCampo = driver.findElement(By.cssSelector("td[data-col='0'] span"));
		String retorno = tituloCampo.getText();
		Assert.assertEquals(string, retorno);
	}

	@When("clicar no icone de exclusão do receita")
	public void clicar_no_icone_de_exclusão_do_receita() {
		driver.findElement(By.cssSelector("div[data-tip='Deletar']")).click();
	}

	@When("clicar em SIM para deletar receita")
	public void clicar_em_sim_para_deletar_receita() throws InterruptedException {
		Thread.sleep(2000);
		WebElement caixa = driver.findElement(By.cssSelector("div[name='content']"));
		botaoDesabilitar = caixa.findElement(By.xpath("//button[contains(text(), 'Sim')]"));
		botaoDesabilitar.click();
	}

	@Then("mensagem {string} de deletar receita")
	public void mensagem_de_deletar_receita(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		mensagem = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.text-green-800")));
		String texto = mensagem.getText();
		Assert.assertEquals(string, texto);
	}
	
	@After
	public void fecharReceitaRC() {
		driver.quit();
	}
}
