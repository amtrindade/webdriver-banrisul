package br.com.banrisul.test;

import static br.com.banrisul.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.banrisul.core.BaseTest;

public class NavegacaoMultiJanelasTest extends BaseTest{
		

	@BeforeEach
	void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao");
	}

	@Test
	public void testNavegacaoMultiAbas() throws InterruptedException {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkCpf = getDriver().findElement(By.linkText("Gerador de CPF"));
		linkCpf.click();
		
		WebElement linkJquery = getDriver().findElement(By.linkText("Drag and Drop JQuery"));
		linkJquery.click();
		
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		//Direciona o getDriver() para a primeira janela
		getDriver().switchTo().window(tabs.get(2));
		
		assertEquals("Gerador de CPF", getDriver().getTitle());
		//direciona o getDriver() para a segunda janela
		getDriver().switchTo().window(tabs.get(1));
		
		assertEquals("jQuery UI Droppable - Default functionality", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		//fecha a janela ativa
		getDriver().close();
		
		tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("jQuery UI Droppable - Default functionality", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(1));
		assertEquals("Gerador de CPF", getDriver().getTitle());		
		
	}
}
