package com.bridzelabz.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

		public class Frame_Demo_Test {	
		public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
        @Test(priority=1)
        public void Frame_Demo() throws InterruptedException { 
        	driver.get("C:\\Users\\hp\\Desktop\\page2.html");
        	//using index of the frame - [ int value] [ index of frames starts with zero]
        	driver.switchTo().frame(0);
        	driver.findElement(By.id("t1")).sendKeys("a");
        	driver.switchTo().defaultContent();
        	driver.findElement(By.id("t2")).sendKeys("a");
        	//using id attribute of the frame -string
        	driver.switchTo().frame("f1");
        	driver.findElement(By.id("t1")).sendKeys("b");
        	driver.switchTo().defaultContent();
        	driver.findElement(By.id("t2")).sendKeys("b");
        	//using name attribute of the frame -string
        	driver.switchTo().frame("n1");
        	driver.findElement(By.id("t1")).sendKeys("c");
        	driver.switchTo().defaultContent();
        	driver.findElement(By.id("t2")).sendKeys("c");
        	//using address of the frame -webelement
        	WebElement f = driver.findElement(By.className("c1"));
        	driver.switchTo().frame(f);
        	driver.findElement(By.id("t1")).sendKeys("d");
        	driver.switchTo().defaultContent();
        	driver.findElement(By.id("t2")).sendKeys("d");
        	driver.close();
        	}
}
