package br.com.banrisul.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		String browser = GlobalProperty.getProperty("banrisul.browser");
		
		if (driver == null) {
			
			if (browser.equals("chrome")) {
			
				System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			else if (browser.equals("chrome-headless")) {
				System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--windows-size(1200,960)");
								
				driver = new ChromeDriver(options);			
			} 						
			else{
				System.out.println("Driver não especificado");
			}
			
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
