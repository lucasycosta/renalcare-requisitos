package Arquivo;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArquivoRC {

	private WebDriver driver;
	private String url = "http://44.201.232.138:3000/auth/login";

	private WebElement cadastrar;
	private WebElement email;
	private WebElement equipe;
	private WebElement buscar;
	private WebElement nomeRetorno;
	private WebElement emailRetorno;
	private WebElement cpfRetorno;
	private WebElement dataRetorno;
	private WebElement perfilRetorno;
	
	// BACKGROUN
	@Given("login listagem")
	public void login_listagem() {
		driver = new ChromeDriver();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='email']")));
		email.sendKeys("costaylucas@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Given("clicar em Arquivo")
	public void clicar_em_arquivo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		cadastrar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Arquivo')]")));
		cadastrar.click();
	}

	// PACIENTE DESABILITADO
	@Given("clicar em Paciente dentro de Arquivo")
	public void clicar_em_paciente_dentro_de_arquivo() throws InterruptedException {
		Thread.sleep(1000);
		equipe = driver.findElement(By.cssSelector("a[href='/archive/patient']"));
		equipe.click();
	}

	@When("abrir a {string} dos pacientes")
	public void abrir_a_dos_pacientes(String string) {
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(string, urlAtual);
	}
	@When("buscar o {string} do paciente")
	public void buscar_o_do_paciente(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']")).click();
	}

	@Then("o registro do paciente retorna com {string}, {string}, {string} e {string}")
	public void o_registro_do_paciente_retorna_com_e(String string, String string2, String string3, String string4)throws InterruptedException{
		Thread.sleep(3000);
		nomeRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String nomeCampo = nomeRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, nomeCampo);
		
		emailRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String emailCampo = emailRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string2, emailCampo);
		
		cpfRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String cpfCAmpo = cpfRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string3, cpfCAmpo);
		
		dataRetorno = driver.findElement(By.cssSelector("td[data-col='3']"));
		String dataCampo = dataRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string4, dataCampo);
	}

	// ESQUIPE DESABILITADA
	@Given("clicar em Equipe dentro de Arquivo")
	public void clicar_em_equipe_dentro_de_arquivo() throws InterruptedException{
			Thread.sleep(1000);
			equipe = driver.findElement(By.cssSelector("a[href='/archive/staff']"));
			equipe.click();
		}

	@When("abrir a {string} da equipe")
	public void abrir_a_da_equipe(String string) {
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(string, urlAtual);
	}
	
	@When("buscar o {string} da equipe")
	public void buscar_o_da_equipe(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		buscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='search']")));
		buscar.click();
		buscar.sendKeys(string);

		driver.findElement(By.cssSelector("button[class='absolute right-0 px-3 py-2 text-neutral-400 hover:text-neutral-600']")).click();
	}

	@Then("o registro da equipe retorna {string}, {string}, {string}, {string} e {string}")
	public void o_registro_da_equipe_retorna_e(String string, String string2, String string3, String string4, String string5) throws InterruptedException{
		Thread.sleep(3000);
		nomeRetorno = driver.findElement(By.cssSelector("td[data-col='0']"));
		String nomeCampo = nomeRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string, nomeCampo);
		
		emailRetorno = driver.findElement(By.cssSelector("td[data-col='1']"));
		String emailCampo = emailRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string2, emailCampo);
		
		cpfRetorno = driver.findElement(By.cssSelector("td[data-col='2']"));
		String cpfCAmpo = cpfRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string3, cpfCAmpo);
		
		dataRetorno = driver.findElement(By.cssSelector("td[data-col='3']"));
		String dataCampo = dataRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string4, dataCampo);
		
		perfilRetorno = driver.findElement(By.cssSelector("td[data-col='4']"));
		String perfilCampo = perfilRetorno.findElement(By.cssSelector("span")).getText();
		Assert.assertEquals(string5, perfilCampo);
	}


	// PACIENTE EXTERNO
	@Given("clicar em Paciente Externo dentro de Arquivo")
	public void clicar_em_paciente_externo_dentro_de_arquivo() throws InterruptedException {
		Thread.sleep(1000);
		equipe = driver.findElement(By.cssSelector("a[href='/archive/patient?external=true']"));
		equipe.click();
	}

	@Then("abrir a {string} dos pacientes externos")
	public void abrir_a_dos_pacientes_externos(String string) {
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(string, urlAtual);
	}

}
