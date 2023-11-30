package br.com.banrisul.test;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavegacaoMultiJanelasTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
		// no windows é assim "C:\\driver\\chromedriver.exe"
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://antoniotrindade.com.br/treinoautomacao");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testNavegacaoMultiAbas() throws InterruptedException {
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkCpf = driver.findElement(By.linkText("Gerador de CPF"));
		linkCpf.click();
		
		WebElement linkJquery = driver.findElement(By.linkText("Drag and Drop JQuery"));
		linkJquery.click();
		
		Thread.sleep(3000);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//Direciona o driver para a primeira janela
		driver.switchTo().window(tabs.get(2));
		
		assertEquals("Gerador de CPF", driver.getTitle());
		//direciona o driver para a segunda janela
		driver.switchTo().window(tabs.get(1));
		
		assertEquals("jQuery UI Droppable - Default functionality", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		//fecha a janela ativa
		driver.close();
		
		Thread.sleep(3000);
		
		tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("jQuery UI Droppable - Default functionality", driver.getTitle());
		
		driver.switchTo().window(tabs.get(1));
		assertEquals("Gerador de CPF", driver.getTitle());		
		
	}
}
