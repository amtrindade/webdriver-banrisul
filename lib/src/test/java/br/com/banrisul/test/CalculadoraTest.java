package br.com.banrisul.test;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.banrisul.core.BaseTest;
import br.com.banrisul.page.CalculadoraPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest extends BaseTest {

	Random random = new Random();
	CalculadoraPage calcPage;
	Integer valor1;
	Integer valor2;
	
	@BeforeEach
	public void setUp() {
		valor1 = random.nextInt(999);
		valor2 = random.nextInt(999);
	}

	@Test
	public void testSoma() throws InterruptedException {
		Integer total = valor1 + valor2;

		calcPage = new CalculadoraPage();

		calcPage.open()
			.inputValue1(Integer.toString(valor1))
			.inputValue2(Integer.toString(valor2))
			.clickSoma();

		assertEquals(Integer.toString(total), calcPage.getTotal(Integer.toString(total)));
	}
}
