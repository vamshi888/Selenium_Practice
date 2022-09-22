package com.bridzelabz.selenium;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Launch_Chrome_Edge_Browser_Test {
	static{
		System.setProperty("webdriver.edge.driver","C:\\Users\\hp\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		}
		WebDriver driver;
		@Test
		@Parameters("browser")
		public void login_Edge_and_Chrome(String browser) throws InterruptedException, IOException{
		Reporter.log(browser, true);
		if (browser.equals("Edge")) {
		driver = new EdgeDriver();
		} else {
		driver = new ChromeDriver();
		}
		FileInputStream configPath = new FileInputStream(".\\config.properties");
		Properties prop = new Properties();
		prop.load(configPath);
		String url = prop.getProperty("URL");
		driver.get(url);
		WebElement un = driver.findElement(By.id("username"));
		for (int i = 0; i < 10; i++) {
		un.sendKeys("admin" + i);
		Thread.sleep(2000);
		un.clear();
		}
		driver.close();
		}

}
