package br.com.banrisul.test;

import static br.com.banrisul.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.banrisul.core.BaseTest;

public class NavegacaoCacheTest extends BaseTest{
	

	@BeforeEach
	void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao");
	}
	
	@Test
	public void testNavigation() {
		WebElement linkCalculadora = getDriver().findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement linkValidarTable = getDriver().findElement(By.linkText("Localizar Table"));
		linkValidarTable.click();
		
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
	}

}
