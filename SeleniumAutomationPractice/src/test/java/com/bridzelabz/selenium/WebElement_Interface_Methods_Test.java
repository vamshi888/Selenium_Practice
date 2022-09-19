package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Interface_Methods_Test {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test 
	 public void get_Attribute() throws InterruptedException { 
     	driver.get("https://www.facebook.com/");
     	driver.manage().window().maximize();
     	String expectedvalue = "Email";
     	WebElement email = driver.findElement(By.id("email"));
     	String actualvalue = email.getAttribute("Aria-label");
     	System.out.println("actual value is: " +actualvalue);
     	if(actualvalue.contains(expectedvalue)) {
     		System.out.println("expected value is correct");
     	}
     	else { 
     		System.out.println("expected value is not correct");
}
     	}   
	@Test 
	 public void get_Tagname() throws InterruptedException { 
    	driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    	String expectedname = "input";
    	WebElement email = driver.findElement(By.id("email"));
    	String actualname = email.getTagName();
    	System.out.println("actual tagname is: " +actualname);
    	if(actualname.contains(expectedname)) {
    		System.out.println("expected value is correct");
    	}
    	else { 
    		System.out.println("expected value is not correct");
    	}
    	}
	
	@Test 
	 public void get_Cssvalue() throws InterruptedException { 
    	driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    	WebElement errormsg = driver.findElement(By.partialLinkText("Forgotten"));
    	String error = errormsg.getText();
    	String fontsize = errormsg.getCssValue("font-size");
    	String color = errormsg.getCssValue("color");
    	System.out.println(" error is: " +error);  	
    	System.out.println("color is  " +color);
    	System.out.println("font size is  " +fontsize);
    	}
	@Test 
	 public void get_Size() throws InterruptedException { 
   	driver.get("https://www.facebook.com/");
   	driver.manage().window().maximize();
   	WebElement errormsg = driver.findElement(By.partialLinkText("Forgotten"));   
   	Point loc = errormsg.getLocation();
   	Dimension size = errormsg.getSize();
   	System.out.println("size is  " +size);
   	System.out.println("loc is  " +loc);
   	}
		
	@Test 
	 public void IsDisplayed() throws InterruptedException { 
		driver.get("https://www.facebook.com/");
     	driver.manage().window().maximize();
     	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
     	Thread.sleep(3000);
     	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
     	driver.findElement(By.name("login")).click();
     	Thread.sleep(3000);   	
    	WebElement stories = driver.findElement(By.xpath("//span[text()='Stories']"));  
    	boolean actualvalue = stories.isDisplayed(); 		 
 	    System.out.println("actual value is present:" +actualvalue);
}
	 @Test 
	    public void actiTime_Username_textbox_isEnabled() throws InterruptedException { 
	    	driver.get("https://demo.actitime.com/login.do");
	    	driver.manage().window().maximize();
	    	WebElement checkbox = driver.findElement(By.xpath("//input[@name='remember']"));
	    	WebElement UN = driver.findElement(By.id("username"));
	    	if (UN.isEnabled()) {
	    	System.out.println("Username text box is enabled");
	    	}else {
	    	System.out.println("Username text box is disabled");
	    	}
	    }
	 @Test 
	    public void actiTime_checkbox_isSelected() throws InterruptedException { 
	    	driver.get("https://demo.actitime.com/login.do");
	    	driver.manage().window().maximize();
	    	WebElement checkbox = driver.findElement(By.xpath("//input[@name='remember']"));
	    	checkbox.click();
	    	Thread.sleep(4000);
	    	if (checkbox.isSelected()) {
	    	System.out.println("Checkbox is selected");
	    	}else{
	    	System.out.println("Checkbox is NOT selected");
	    	}
	   	}

}
