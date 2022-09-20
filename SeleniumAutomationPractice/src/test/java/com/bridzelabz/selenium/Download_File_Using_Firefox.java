package com.bridzelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Download_File_Using_Firefox {
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\hp\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new ChromeDriver();
	}
	@Test 
	 public void Download_File_Using_Firefox_Browser() throws InterruptedException { 
		//Create an object of FirefoxProfile class
		FirefoxProfile profile = new FirefoxProfile();
		//Set the Key so that it will not show the file download pop up on the screen
		String key = "browser.helperApps.neverAsk.saveToDisk";
		//Set the type of file which you want to download
		String value = "application/zip";
		//using setPreference() method, change the setting
		profile.setPreference(key, value);
		// 0 - save to desktop, 1 - save to download folder( default), 2 - save to any other //location 
		profile.setPreference("browser.download.folderList", 2);
		//save the file to the given folder location
		profile.setPreference("browser.download.dir", "C:\\Users\\hp\\Downloads");
		//Use DesiredCapabilities class to modify the firefox settings as shown below
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		//Launch the firefox browser with the above modified settings
		WebDriver driver = new FirefoxDriver(cap);
		//Enter selenium official website url
		driver.get("http://www.seleniumhq.org/download/");
		//Use following-sibling axes in Xpath to find the download link for selenium java
		driver.findElement(By.linkText("4.4.0")).click();
		Thread.sleep(3000);
		}

}
