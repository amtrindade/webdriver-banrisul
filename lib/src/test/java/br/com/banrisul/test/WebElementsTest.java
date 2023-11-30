package br.com.banrisul.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


class WebElementsTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
		// no windows é assim "C:\\driver\\chromedriver.exe"
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	void testValidaTextField() throws InterruptedException {
		String nome = "Hello world";
		
		//1 - Localiza o elemento na tela
		WebElement textFieldEnable = driver.findElement(By.name("txtbox1"));
				
		//2 - Faz a interação com o elemento
		textFieldEnable.sendKeys(nome);
		
		Thread.sleep(3000);
		
		//3 - Validar o resultado
		assertEquals(nome, textFieldEnable.getAttribute("value"));
	}
	
	@Disabled("Bug registrado id 45612313")
	@Test
	public void testValidaDisableTextField() throws InterruptedException {
		WebElement tfDisable = driver.findElement(By.name("txtbox2"));
		WebElement tfEnable = driver.findElement(By.name("txtbox1"));
		
		assertFalse(tfDisable.isEnabled());
		assertTrue(tfEnable.isEnabled());
	}
	
	@Test
	public void testValidaRadioButton() throws InterruptedException {
		List<WebElement> radios = driver.findElements(By.name("radioGroup1"));
		
		for (WebElement e: radios) {
			System.out.println(e.getAttribute("value"));
			if (e.getAttribute("value").equals("Radio 3")){
				e.click();
			}
		}
		
		assertTrue(radios.get(2).isSelected());
		
		assertFalse(radios.get(0).isSelected());
		assertFalse(radios.get(1).isSelected());
		assertFalse(radios.get(3).isSelected());
	}
	
	@Test
	public void testValidaCheckBox() {
		List<WebElement> checks = driver.findElements(By.name("chkbox"));
		
		assertEquals(4, checks.size());
		
//		checks.get(2).click();
//		checks.get(3).click();
		
		for (WebElement e: checks) {
			if ((e.getAttribute("value").equals("Check 3")) ||
					(e.getAttribute("value").equals("Check 4"))){
				e.click();
			}
		}
		
		assertTrue(checks.get(2).isSelected());
		assertTrue(checks.get(3).isSelected());
		
		assertFalse(checks.get(0).isSelected());
		assertFalse(checks.get(1).isSelected());		
	}
	
	@Test
	public void testValidaDropDownSingle() throws InterruptedException {
		WebElement ddSingle = driver.findElement(By.name("dropdownlist"));
		
		Select selectSingle = new Select(ddSingle);
		
		selectSingle.selectByValue("item3");
		Thread.sleep(3000);
		selectSingle.selectByVisibleText("Item 7");
		
		Thread.sleep(3000);
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testValidaDropDownMultiple() {
		WebElement ddMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(ddMulti);
		
		selectMulti.selectByVisibleText("Item 8");
		selectMulti.selectByVisibleText("Item 9");
		selectMulti.selectByVisibleText("Item 5");
		
		List<WebElement> optionsSelect = selectMulti.getAllSelectedOptions();
		
		assertEquals(3, optionsSelect.size());
		
		assertEquals("Item 5", optionsSelect.get(0).getText());
		assertEquals("Item 8", optionsSelect.get(1).getText());
		assertEquals("Item 9", optionsSelect.get(2).getText());
		
		selectMulti.selectByIndex(9);
		
		optionsSelect = selectMulti.getAllSelectedOptions();
		assertEquals(4, optionsSelect.size());
	
		assertEquals("Item 5", optionsSelect.get(0).getText());
		assertEquals("Item 8", optionsSelect.get(1).getText());
		assertEquals("Item 9", optionsSelect.get(2).getText());
		assertEquals("Item 10", optionsSelect.get(3).getText());
	}
	
	@Test
	public void testValidaiFrame() throws InterruptedException {
		//entra no iframe
		driver.switchTo().frame("frame1");
		
		WebElement tfIframe = driver.findElement(By.id("tfiframe"));
		tfIframe.sendKeys("entrou no iframe");
		Thread.sleep(3000);
		
		assertEquals("entrou no iframe", tfIframe.getAttribute("value"));
		
		//volta para o frame de origem
		driver.switchTo().defaultContent();
		
		WebElement h3Title = driver.findElement(By.xpath("//*[@id='elementos'][6]/h3"));
		
		assertEquals("iFrame:", h3Title.getText());
	}
	
	@Test
	public void testValidaAlert() throws InterruptedException {
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals("Eu sou um alerta!", alert.getText());
		alert.accept();
	}
	
	@Test
	public void testPrompt() throws InterruptedException {
		WebElement btnPrompt = driver.findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("2023");
		Thread.sleep(3000);
		prompt.accept();
		
		Alert promptDois = driver.switchTo().alert();
		Thread.sleep(3000);
		assertEquals("O ano é 2023?", promptDois.getText());
		
 		
	}
}
