package com.bridzelabz.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_Keyboard_Operations_Test {

public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test	
	public void robot_Class() throws InterruptedException, AWTException {
		driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    	Thread.sleep(3000);
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_ALT);
    	robot.keyPress(KeyEvent.VK_F);
    	robot.keyRelease(KeyEvent.VK_F);
    	robot.keyRelease(KeyEvent.VK_ALT);
    	Thread.sleep(3000);
    	robot.mouseMove(500, 400);
    	Thread.sleep(3000);
    	robot.mouseWheel(500);
    	Thread.sleep(3000);
    	driver.close();
		/*
		 * robot.keyPress(KeyEvent.VK_CONTROL);
		 *  robot.keyPress(KeyEvent.VK_K);
		 * robot.keyRelease(KeyEvent.VK_K); 
		 * robot.keyRelease(KeyEvent.VK_CONTROL);
		 * Thread.sleep(3000);
		 */
	}
}
