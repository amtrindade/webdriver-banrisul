package br.com.banrisul.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
		// no windows é assim "C:\\driver\\chromedriver.exe"
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testCheckBox() throws InterruptedException {
		String nome = "Antônio";
		
		WebElement check = driver.findElement(By.xpath("//td[contains(text(),'"+nome+"')]/../td[3]/input"));
		check.click();
		
		assertTrue(check.isSelected());
		
		Thread.sleep(5000);
		
		
	}
	
	

}
