package br.com.banrisul.page;

import static br.com.banrisul.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public LoginPage open() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
		return this;
	}
	
	public LoginPage inputEmail(String email) {
		WebElement tfEmail = getDriver().findElement(By.id("email"));
		tfEmail.sendKeys(email);
		return this;
	}
	
	public LoginPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.id("senha"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public HomePage submitLogin() {
		WebElement btnEntrar = getDriver().findElement(By.xpath("//button[.='Entrar']"));
		btnEntrar.click();
		return new HomePage();
	}
	
	public LoginPage submitLoginInvalid() {
		WebElement btnEntrar = getDriver().findElement(By.xpath("//button[.='Entrar']"));
		btnEntrar.click();
		return this;
	}
	
	public String getMessageError() {
		WebElement divError = getDriver().findElement(By.xpath("//div[@class='alert alert-danger']"));
		return divError.getText();
	}

}
