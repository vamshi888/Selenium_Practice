package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fb_Registration_XPath_Test {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	

    @Test(priority=1)
    public void facebook_Registration() throws InterruptedException { 
    	driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("vamshi");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("krishna");
    	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("krishna@gmail.com");
    	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("krishna@gmail.com");
    	driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("krishna123");
    	driver.findElement(By.xpath("//select[@id='day']")).sendKeys("23");
    	driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Oct");
    	driver.findElement(By.xpath("//select[@id='year']")).sendKeys("1996");
    	driver.findElement(By.xpath("//input[@value='2']")).click();
    	driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
    	Thread.sleep(3000);
    }
        @Test(priority=2)
        public void facebook_login() throws InterruptedException { 
        	driver.get("https://www.facebook.com/");
        	driver.manage().window().maximize();
        	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vamshik484@gmail.com");
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Vamshi@123");
        	driver.findElement(By.xpath("//button[@name='login']")).click();
        	Thread.sleep(8000);
        	driver.close();
        	//driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
        }
}
