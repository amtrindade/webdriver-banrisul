package br.com.banrisul.test;

import org.junit.jupiter.api.Test;

import br.com.banrisul.core.BaseTest;
import br.com.banrisul.page.HomePage;
import br.com.banrisul.page.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest{

	private LoginPage loginPage;
	private HomePage homePage;
		
	@Test
	public void testLoginSucesso() throws InterruptedException {
		
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.inputEmail("bozo@mail.com");
		loginPage.inputPassword("a");
		homePage = loginPage.submitLogin();
		assertEquals("Bem vindo, bozo!", homePage.getTextWelcome());
		
	}
	
	@Test
	public void testLoginSenhaInvalida() {
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.inputEmail("bozo@mail.com");
		loginPage.inputPassword("senhainvalida");
		loginPage.submitLoginInvalid();
		assertEquals("Problemas com o login do usuário", loginPage.getMessageError());
		
		
	}
	
}
