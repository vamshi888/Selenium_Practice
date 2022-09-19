package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Clear_Text_Without_Using_Clear_Method_Test {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test 
	 public void Clear_Username_Field_Without_Using_Clear_Method() throws InterruptedException { 
    driver.get("https://www.facebook.com/");	
	driver.findElement(By.id("email")).sendKeys("vamshi");
	Thread.sleep(2000);
	String value = driver.findElement(By.id("email")).getAttribute("value");
	System.out.println("Value present inside the text box is : "+value);
	driver.findElement(By.id("email")).clear();
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys("againEnteredvamshi");
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
	Thread.sleep(2000);
	}
	@Test 
	 public void Enter_Text_Into_Focussed_Element() throws InterruptedException { 
   driver.get("https://www.facebook.com/");	
   driver.switchTo().activeElement().sendKeys("admin"); 
	}
	@Test 
	 public void PrintTooltip_Actitime_RememberCheckbox() throws InterruptedException { 
		driver.get("https://demo.actitime.com/login.do");
		//find the Keep me Logged in Checkbox
		WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox"));
		Thread.sleep(2000);
		//get the tooltip text using getAttribute() method and store in a variable
		String tooltipText = Checkbox.getAttribute("title");
		Thread.sleep(2000);
		System.out.println(tooltipText);
		Thread.sleep(2000);
		driver.close();

	}
	@Test 
	 public void Print_Version_Actitime_LoginPage() throws InterruptedException { 
		driver.get("https://demo.actitime.com/login.do");
		String xpathforVersion = "//nobr[contains(text(),'actiTIME')]";
		String version = driver.findElement(By.xpath(xpathforVersion)).getText();
		System.out.println("Version of actitime on login page is : " + version);
		}
	
}
