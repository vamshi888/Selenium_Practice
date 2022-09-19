package com.bridzelabz.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_Homepage_Validation_Test { 
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test 
	 public void validating_Facebook_Homepage_Url() throws InterruptedException { 
     	driver.get("https://www.facebook.com/");
     	driver.manage().window().maximize();
     	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
     	Thread.sleep(3000);
     	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
     	driver.findElement(By.name("login")).submit();
     	Thread.sleep(10000);
     	String exceptedurl = "https://www.facebook.com/";
     	String actualurl = driver.getCurrentUrl();
     	if(actualurl.equals(exceptedurl)) {
     		System.out.println("expected page is displayed");
     	}
     	else
     	{
     		System.out.println("expected page is not displayed");
}
     	}
	@Test 
	 public void validating_Facebook_Homepage_Title() throws InterruptedException { 
    	driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
    	Thread.sleep(3000);
    	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
    	driver.findElement(By.name("login")).click();
    	Thread.sleep(10000);
    	String exceptedtitle = "Facebook";
    	String actualtitle = driver.getTitle();
    	
    	if(actualtitle.equals(exceptedtitle)) {
    		System.out.println("expected title is displayed");
    	}
    	else
    	{
    		System.out.println("expected title is not displayed");
}
    	}
	
	@Test 
	 public void validating_Facebook_Homepage_Using_UniqueElement() throws InterruptedException { 
   	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
   	driver.manage().window().maximize();
   	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
   	Thread.sleep(3000);
   	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
   	driver.findElement(By.name("login")).sendKeys(Keys.ENTER); 
   	Thread.sleep(3000);
   	WebElement Stories = driver.findElement(By.xpath("//span[text()='Stories']"));
   	if (Stories.isDisplayed()) {
   	System.out.println("Home page is displayed");
   	} else{
   	System.out.println("Home page is NOT displayed");
   	}
   	}
   		
	@Test 
	 public void validating_Error_Facebook_Password() throws InterruptedException { 
   	driver.get("https://www.facebook.com/");
   	driver.manage().window().maximize();
   	driver.findElement(By.name("email")).sendKeys("vamshi@gmail.com");
   	Thread.sleep(3000);
   	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
   	driver.findElement(By.name("login")).click();
   	Thread.sleep(6000);
    driver.findElement(By.xpath("//a[text()='Not you?']")).click();
   	WebElement errormsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
   	String error = errormsg.getText();
   	System.out.println("error is :" +error);
   	Thread.sleep(2000);
   	if (error.contains("The email address you entered")) {
   		System.out.println("validation is succesful");
   	} else {
   		System.out.println("validation is failed");
}
   	}
	@Test 
	 public void validating_Error_Facebook_Email() throws InterruptedException { 
  	driver.get("https://www.facebook.com/");
  	driver.manage().window().maximize();
  	driver.findElement(By.name("email")).sendKeys("vam@gmail.com");
  	Thread.sleep(3000);
  	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
  	driver.findElement(By.name("login")).click();
  	Thread.sleep(6000);
    driver.findElement(By.xpath("//a[text()='Not you?']")).click();
  	WebElement errormsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
  	String error = errormsg.getText();
  	System.out.println("error is :" +error);
  	Thread.sleep(2000);
	if (error.equals("The email address you entered isn't connected to an account. Find your account and log in.")) {
   		System.out.println("validation is succesful");
   	} else {
   		System.out.println("validation is failed");
   	}
}
	@Test 
	 public void validating_Error_Facebook_Blankpassword() throws InterruptedException { 
 	driver.get("https://www.facebook.com/");
 	driver.manage().window().maximize();
 	driver.findElement(By.name("email")).sendKeys("");
 	Thread.sleep(3000);
 	driver.findElement(By.id("pass")).sendKeys("vam123");
 	driver.findElement(By.name("login")).click();
 	Thread.sleep(6000);
   driver.findElement(By.xpath("//a[text()='Not you?']")).click();
 	WebElement errormsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
 	String error = errormsg.getText();
 	System.out.println("error is :" +error);
 	Thread.sleep(2000);
 	if (error.contains(" isn't connected to an account. Find your account and log in."))
 	{
   		System.out.println("validation is succesful");
   	} 
 	else {
   		System.out.println("validation is failed");
}
}
}
