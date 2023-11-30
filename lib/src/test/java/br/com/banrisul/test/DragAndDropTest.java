package br.com.banrisul.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

public class DragAndDropTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
		// no windows é assim "C:\\driver\\chromedriver.exe"
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test 
	public void testDragAndDrop() throws InterruptedException, IOException { 
		WebElement drag = driver.findElement(By.id("draggable")); 
		WebElement drop = driver.findElement(By.id("droppable")); 
		
		//realiza o screenshot
		File scrnShotBefore =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShotBefore , new File("screen/image01.jpg"));
		
		new Actions(driver).dragAndDrop(drag, drop).perform(); 
		
		File scrnShotAfter =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShotAfter , new File("screen/image02.jpg"));
		
		assertEquals("Dropped!",drop.getText()); 				
		 
	}
}
