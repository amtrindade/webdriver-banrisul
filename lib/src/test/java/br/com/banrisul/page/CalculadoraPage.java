package br.com.banrisul.page;

import static br.com.banrisul.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraPage {
	
	public CalculadoraPage open() {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		return this;
	}
	
	public CalculadoraPage inputValue1(String value1) {
		WebElement tfValor1 = getDriver().findElement(By.id("number1"));
		tfValor1.sendKeys(value1);		
		return this;
	}
	
	public CalculadoraPage inputValue2(String value2) {
		WebElement tfValor2 = getDriver().findElement(By.id("number2"));
		tfValor2.sendKeys(value2);
		return this;
	}
	
	public CalculadoraPage clickSoma() {
		WebElement btnSomar = getDriver().findElement(By.id("somar"));
		btnSomar.click();
		return this;
	}
	
	public CalculadoraPage esperaTotal(String total) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("total"), total));
		return this;
	}
	
	public String getTotal(String total) {
		esperaTotal(total);
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getAttribute("value");				
	}
}
