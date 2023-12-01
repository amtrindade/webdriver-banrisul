package br.com.banrisul.test;

import static br.com.banrisul.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.banrisul.core.BaseTest;

public class GeradorCpfTest extends BaseTest{
		
	@BeforeEach
	void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");
	}	
	
	@Test
	public void testValidaCpfComMascara() {
		WebElement chkPontuacao = getDriver().findElement(By.id("cbPontos"));
		chkPontuacao.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = getDriver().findElement(By.id("numero"));
		String cpf = tfCpf.getAttribute("value");
		
		System.out.println("Cpf gerado é: "+ cpf);
		
		assertTrue(cpf.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));
	}

}
