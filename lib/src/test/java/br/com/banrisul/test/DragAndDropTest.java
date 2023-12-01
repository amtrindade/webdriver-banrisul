package br.com.banrisul.test;

import static br.com.banrisul.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.banrisul.core.BaseTest;

public class DragAndDropTest extends BaseTest {
	
	@BeforeEach
	void setUp() throws Exception {
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");
	}
	
	
	@Test 
	public void testDragAndDrop() throws InterruptedException, IOException { 
		WebElement drag = getDriver().findElement(By.id("draggable")); 
		WebElement drop = getDriver().findElement(By.id("droppable")); 
		
		//realiza o screenshot
		File scrnShotBefore =	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShotBefore , new File("screen/image01.jpg"));
		
		new Actions(getDriver()).dragAndDrop(drag, drop).perform(); 
		
		File scrnShotAfter =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShotAfter , new File("screen/image02.jpg"));
		
		assertEquals("Dropped!",drop.getText()); 				
		 
	}
}
