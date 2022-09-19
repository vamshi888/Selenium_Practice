package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Test {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
        @Test(priority=1)
        public void Using_Scrool_By() throws InterruptedException { 
        	driver.get("https://www.facebook.com/");
        	driver.manage().window().maximize();
        	driver.findElement(By.name("email")).sendKeys("vamshik484@gmail.com");
        	Thread.sleep(3000);
        	driver.findElement(By.id("pass")).sendKeys("Vamshi@123");
        	driver.findElement(By.name("login")).click();
        	Thread.sleep(7000);
        	JavascriptExecutor jse = (JavascriptExecutor) driver;
        	jse.executeScript("window.scrollBy(0,1000)");
        	Thread.sleep(7000);
        	jse.executeScript("window.scrollBy(0,-1000)");
        	Thread.sleep(7000);
        	driver.close();
}
        @Test
        public void Enter_Text_In_Disabled_Textbox() throws InterruptedException { 
        	driver.get("file:///C:/Users/hp/Desktop/demo.html");
        	driver.manage().window().maximize();
        	//Typecast the driver object to JavascriptExecutor interface type
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	Thread.sleep(2000);
        	//enter "admin" in first textbox using javascript
        	js.executeScript("document.getElementById('t1').value='admin'");
        	Thread.sleep(2000);
        	//clear the value in second textbox using javascript
        	js.executeScript("document.getElementById('t2').value=''");
        	//enter "manager" in second textbox using javascript
        	js.executeScript("document.getElementById('t2').value='manager'");
        	//change the second text box to button type using Javascript
        	js.executeScript("document.getElementById('t2').type='button'");
        	}
        @Test(priority=2)
        public void Scroll_Upto_Specific_Element() throws InterruptedException { 
        	driver.get("https://www.instagram.com/");
        	driver.manage().window().maximize();
        	WebElement ele = driver.findElement(By.xpath("//div[text()='© 2022 Instagram from Meta']"));
        	// get the X-coordinate and store in a variable
        	int x = ele.getLocation().getX();
        	// get the Y-coordinate and store in a variable
        	int y = ele.getLocation().getY();
        	Thread.sleep(3000);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	//Scroll to Applitools element’s x and y coordinate
        	js.executeScript("window.scrollBy("+x+", "+y+")");
        	Thread.sleep(3000);

}
	
	@Test(priority=3)
	public void Scroll_Upto_Bottom_Of_Page() throws InterruptedException { 
		driver.get("http://www.seleniumhq.org/download/");
		driver.findElement(By.id("close")).click();
		//select an element which is present at the bottom of the page
		WebElement element = driver.findElement(By.id("footerLogo"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is :"+x + " and Y coordinate is :"+ y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		Thread.sleep(3000);
		element.click();
		}
	
    }
