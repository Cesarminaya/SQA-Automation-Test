package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class FactorialTest {

	private WebDriver driver;
	By buttonfactorial = By.id("getFactorial");
	By textdisplayed = By.id("resultDiv");
	By textboxfactorial = By.id("number"); 	
	String cadena1 = new String("120");
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qainterview.pythonanywhere.com/");
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testvalidation() {
		WebElement textbox = driver.findElement(By.id("number")); 	
		textbox.clear();
		driver.findElement(buttonfactorial).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* Si el label est� habilitado dar� un true, de lo contrario false*/
		if(driver.findElement(textdisplayed).isEnabled()) {
			System.out.print(true);
			Assert.assertEquals("Please enter an integer", textdisplayed);
		
		}else {
			System.out.print("No est� funcionando la validaci�n del textbox.");
			fail("Captura de excepci�n");
		}

	}
	
	/*Estaba intentando validar el resultado tomando lo que esta en el texbox comparandolo con el resultado final */
	@Test 
	public void testfactorials() {
		driver.findElement(textboxfactorial).clear();
		driver.findElement(textboxfactorial).sendKeys("5");
		
		driver.findElement(buttonfactorial).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(textdisplayed.toString() == cadena1.toString()){
			
			System.out.println("Correcto");
		}
		else {
			System.out.println("Est� dando resultados �rroneos.");
			fail("Captura de excepci�n");
		}
	}
}
