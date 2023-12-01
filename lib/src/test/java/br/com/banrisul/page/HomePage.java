package br.com.banrisul.page;

import static br.com.banrisul.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public String getTextWelcome() {
		WebElement divWelcome = getDriver()
				.findElement(By.xpath("//div[@class='alert alert-success']"));
		return divWelcome.getText();
	}

}
