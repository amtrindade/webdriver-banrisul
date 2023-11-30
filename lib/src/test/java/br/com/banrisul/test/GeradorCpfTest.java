package br.com.banrisul.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeradorCpfTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://www.geradordecpf.org/");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testValidaCpfComMascara() {
		WebElement chkPontuacao = driver.findElement(By.id("cbPontos"));
		chkPontuacao.click();
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = driver.findElement(By.id("numero"));
		String cpf = tfCpf.getAttribute("value");
		
		System.out.println("Cpf gerado é: "+ cpf);
		
		assertTrue(cpf.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));
	}

}
