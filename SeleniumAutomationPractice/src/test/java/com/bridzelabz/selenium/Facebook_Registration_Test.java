package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_Registration_Test { 
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
        @Test(priority=1)
        public void facebook_registration() throws InterruptedException { 
        	driver.get("https://www.facebook.com/");
        	driver.manage().window().maximize();
        	driver.findElement(By.linkText("Create New Account")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.name("firstname")).sendKeys("vamshi");
        	Thread.sleep(3000);
        	driver.findElement(By.name("lastname")).sendKeys("krishna");
        	Thread.sleep(3000);
        	driver.findElement(By.name("reg_email__")).sendKeys("vamshik484@gmail.com");
        	Thread.sleep(3000);
        	driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vamshik484@gmail.com");
        	Thread.sleep(3000);
        	driver.findElement(By.id("password_step_input")).sendKeys("Vamshi@123");
        	driver.findElement(By.id("day")).sendKeys("23");
        	driver.findElement(By.id("month")).sendKeys("Oct");
        	driver.findElement(By.id("year")).sendKeys("1996");  
        	driver.findElements(By.name("sex")).get(1).click();
        	driver.findElement(By.name("websubmit")).click();
        	Thread.sleep(3000);
        	//driver.close();
        
        }
        
        @Test(priority=2)
        public void facebook_login() throws InterruptedException { 
        	driver.get("https://www.facebook.com/");
        	driver.manage().window().maximize();
        	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
        	Thread.sleep(3000);
        	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
        	driver.findElement(By.name("login")).click();
        	Thread.sleep(10000);
        	String url = driver.getCurrentUrl();
        	System.out.println("The page url is : " +url);
        	Assert.assertEquals(url, "https://www.facebook.com/");
        	driver.close();
        	//driver.findElement(By.linkText("Forgotten password?")).click();
}
}
