package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiTime_Test {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
    @Test(priority=1)
    public void actiTime_Online_Login() throws InterruptedException { 
    	driver.get("https://demo.actitime.com/login.do");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
    	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@name='remember']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//td[@id='logoContainer']")).click(); 
    	driver.findElement(By.xpath("//div[text()='Login ']")).sendKeys(Keys.ENTER);   	   	 
    	//driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
    	//driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
}
    @Test(priority=3)
    public void actiTime_Offline_Login() throws InterruptedException { 
    	driver.get("file:///C:/Users/hp/Desktop/actitime.html");
    	driver.manage().window().maximize();
    	driver.findElement(By.id("username")).clear();
    	Thread.sleep(3000);
    	driver.findElement(By.id("username")).sendKeys("admin");
    	driver.findElement(By.id("password")).clear();
    	driver.findElement(By.id("password")).sendKeys("manager");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[text()=' Click ActiTIME Link']")).click(); 
    	Thread.sleep(3000);
    
}
    @Test(priority=2)
    public void actiTime_Display_Tooltip_Text() throws InterruptedException { 
    	driver.get("https://demo.actitime.com/login.do");
    	driver.manage().window().maximize();
    	//find the Keep me Logged in Checkbox
    	WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox"));
    	//get the tooltip text using getAttribute() method and store in a variable
    	String tooltipText = Checkbox.getAttribute("title");
    	System.out.println("tooltip text is "+tooltipText);
    	driver.close();
    	}

}