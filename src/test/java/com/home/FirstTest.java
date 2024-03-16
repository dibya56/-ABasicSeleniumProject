package com.home;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FirstTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void startUp() throws IOException {
		Properties prop = PropertyManager.readPropertiesFile("Resources.properties");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(3000);
		String header = driver.findElement(By.xpath("//h1[@class='heading']")).getText();
		Assert.assertEquals("Header Mismatch", "Welcome to the-internet", header);
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

}
