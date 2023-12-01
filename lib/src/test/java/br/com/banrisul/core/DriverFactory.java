package br.com.banrisul.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				
		}
		
		return driver;		
	}
	
	public static void killDriver() {
		
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		
	}

}
