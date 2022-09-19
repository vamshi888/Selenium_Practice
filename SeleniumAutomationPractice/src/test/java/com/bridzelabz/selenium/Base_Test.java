package com.bridzelabz.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Test {
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
	}
	@AfterTest
	public void tearDown() throws IOException {
        driver.close();
}
	}