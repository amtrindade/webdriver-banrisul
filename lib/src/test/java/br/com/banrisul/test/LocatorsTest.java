package br.com.banrisul.test;

import static br.com.banrisul.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.banrisul.core.BaseTest;

public class LocatorsTest extends BaseTest {
	
	@BeforeEach
	void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}

	@Test
	public void testCheckBox() throws InterruptedException {
		String nome = "Antônio";
		
		WebElement check = getDriver().findElement(By.xpath("//td[contains(text(),'"+nome+"')]/../td[3]/input"));
		check.click();
		
		assertTrue(check.isSelected());
		
		Thread.sleep(5000);
		
		
	}
	
	

}
