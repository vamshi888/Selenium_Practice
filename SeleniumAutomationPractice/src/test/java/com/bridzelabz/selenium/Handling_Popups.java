package com.bridzelabz.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_Popups {
	public static WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
        @Test
        public void Upload_File_Using_Auto_It() throws InterruptedException { 
        	driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	driver.findElement(By.xpath("//input[@multiple='']")).sendKeys("C:\\Users\\hp\\Desktop\\Agileupdated.pdf");
        	driver.findElement(By.xpath("//button[@ng-click='item.upload()']")).click();
        	
        }   
        @Test
        public void Upload_File() throws InterruptedException, IOException { //e
        	driver.get("https://www.freepdfconvert.com/pdf-to-word");
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	driver.findElement(By.linkText("Choose PDF file")).click();
        	Runtime.getRuntime().exec("C:\\Users\\hp\\Desktop\\hi.exe");
        	} 
      	        
        @Test
        public void Alert_Prompt_Popup() throws InterruptedException { 
        	driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	//find this button : "Say my name"
        	driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
        	//Switch to alert pop up 
        	Alert alert = driver.switchTo().alert();
        	//print the text present on the alert pop up
        	System.out.println(alert.getText());
        	//enter your name in the text box present on the alert pop up
        	alert.sendKeys("vamshi");
        	//click on OK button
        	alert.accept();
        	//print the text present on the second alert pop up
        	System.out.println(alert.getText());
        	//click on Cancel button
        	alert.dismiss();
        	}
        @Test
        public void Alert_Prompt_Popup_Tools_Qa() throws InterruptedException { 
        	driver.get("https://demoqa.com/alerts");
        	driver.manage().window().maximize();
        	JavascriptExecutor jse = (JavascriptExecutor) driver;
        	jse.executeScript("window.scrollBy(0,400)");
        	Thread.sleep(3000);
        	//find this button : "Say my name"
        	driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	//Switch to alert pop up 
        	Alert alert = driver.switchTo().alert();
        	//print the text present on the alert pop up
        	System.out.println(alert.getText());
        	//enter your name in the text box present on the alert pop up
        	alert.sendKeys("vamshi");
        	Thread.sleep(3000);
        	//click on OK button
        	alert.accept();
        	//print the text present on the second alert pop up
        	//System.out.println(alert.getText());
        	//click on Cancel button
        	//alert.dismiss();
        	}
        
        @Test
        public void Select_Date_In_Calender() throws InterruptedException { 
        	ChromeOptions option = new ChromeOptions();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	option.addArguments("--disable-notifications");
        	option.addArguments("--disable-geolocation");
        	option.addArguments("--ignore-certificate-errors");  
        	WebDriver driver = new ChromeDriver(option);
        	driver.get("https://www.cleartrip.com/");
        	driver.findElement(By.xpath("//*[@class=' c-pointer c-neutral-900']")).click();
        	driver.findElement(By.xpath("//div[@aria-label='Sun Sep 25 2022']")).click();
        	//driver.findElement(By.xpath("(//input[@placeholder='Pick a date'])[10]")).click();
        	//driver.findElement(By.linkText("14")).click();
        	}
        @Test
        public void Pick_Date_In_Calender() throws InterruptedException { 
        	ChromeOptions option = new ChromeOptions();
        	 driver.get("https://www.irctc.co.in/nget/train-search");
    		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		 driver.findElement(By.xpath("//button[text()='OK']")).click();
    		driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/input")).click();
    		driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/a[2]/span")).click();
    		driver.findElement(By.xpath("//a[text()='23']")).click();
        }
        
        @Test
        public void Print_Window_Handle_Id_Of_Browser() throws InterruptedException { 
        	driver.get("https://www.freepdfconvert.com/pdf-to-word");
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	//get the window handle id of the browser 
        	String windowHandle = driver.getWindowHandle();
        	System.out.println(windowHandle);
        	
}
        @Test
        public void No_Of_Windows_opened_title_And_Id() throws InterruptedException { 
        	//driver.get("https://www.freepdfconvert.com/pdf-to-word");
        	driver.get("https://www.naukri.com/");
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	//using getWindowHandles(), get a set of window handle IDs
        	Set<String> allWindowHandles = driver.getWindowHandles();
        	//using size(), get the count of total number of browser windows
        	int count = allWindowHandles.size();
        	System.out.println("Number of browser windows opened on the system is : "+ count);
        	for (String windowHandle : allWindowHandles) {
        	//switch to each browser window
        	driver.switchTo().window(windowHandle);
        	String title = driver.getTitle();
        	//print the window handle id of each browser window
        	System.out.println("Window handle id of page is --> "+windowHandle);
        	System.out.println("title of page is "+title);
        	//close all the browsers one by one
        	driver.close();
        	}}

        	 @Test(priority=1)
             public void Close_Main_Browser_window() throws InterruptedException { 
             	//driver.get("https://www.freepdfconvert.com/pdf-to-word");
             	driver.get("https://www.naukri.com/");
             	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             	//get the window handle id of the parent browser window
             	String parentWindowhandleID = driver.getWindowHandle();
             	Set<String> allWindowHandles = driver.getWindowHandles();
             	int count = allWindowHandles.size();
             	System.out.println("Number of browser windows opened on the system is : "+ count);
             	for (String windowHandle : allWindowHandles) {
             	//switch to each browser window
             	driver.switchTo().window(windowHandle);
             	/* compare the window id with the Parent browser window id, if both are equal, then 
             	only close the main browser window.*/
             	if (windowHandle.equals(parentWindowhandleID)) {
             	driver.close();
             	System.out.println("Main Browser window is closed");
             	

}}}
        	 @Test
             public void File_Download_Chrome_Browser() throws InterruptedException {
        		//Create Hashmap object and assign the profile settings
        		 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        		 chromePrefs.put("profile.default_content_settings.popups", 0);
        		 chromePrefs.put("download.default_directory", "C:\\Users\\hp\\Downloads");
        		 //Assign this chromePrefs object with ChromeOptions object 
        		 ChromeOptions options = new ChromeOptions();
        		 options.setExperimentalOption("prefs", chromePrefs);
        		 //Create Capability object and assign the option object
        		 DesiredCapabilities cap = new DesiredCapabilities();
        		 cap.setCapability(ChromeOptions.CAPABILITY, options);
        		 WebDriver driver = new ChromeDriver(cap); 
        		 driver.get("http://www.seleniumhq.org/download/");
        		 Thread.sleep(3000);
        		 String xp = "4.4.0";
        		 Thread.sleep(3000);
        		 driver.findElement(By.linkText(xp)).click();
        		 }
        	
        	 @Test
             public void Close_All_Child_Browser_windows() throws InterruptedException { 
        		 driver.get("https://www.irctc.co.in/nget/train-search");
        		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		 driver.findElement(By.xpath("//button[text()='OK']")).click();
        		 driver.findElement(By.xpath("//*[@id=\"flight\"]/a/label")).click();
        		// driver.findElement(By.xpath("//span[text()='Hotels']")).click();
        		//get the window handle id of the parent browser window
        		 String parentWindowhandleID = driver.getWindowHandle();
        		 Set<String> allWindowHandles = driver.getWindowHandles();
        		 int count = allWindowHandles.size();
        		 System.out.println("Number of browser windows opened on the system is : "+ count);
        		 for (String windowHandle : allWindowHandles) {
        		 //switch to each browser window
        		 driver.switchTo().window(windowHandle);
        		 String title = driver.getTitle();
        		 /* compare the window id of all the browsers with the Parent browser window id, if it 
        		 is not equal, then only close the browser windows.*/
        		 if (!windowHandle.equals(parentWindowhandleID)) {
        		 driver.close();
        		 System.out.println("Child Browser window with title -->"+ title +" --> is	 closed");
        		 }}}

        	 @Test
             public void Close_Specified_Browser_window() throws InterruptedException { 
        		 driver.get("https://www.irctc.co.in/nget/train-search");
        		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		 driver.findElement(By.xpath("//button[text()='OK']")).click();
        		 driver.findElement(By.xpath("//*[@id=\"flight\"]/a/label")).click();
        		//Set the expected title of the browser window which you want to close
        		 String expected_title = "IRCTC Next Generation eTicketing System";
        		 Set<String> allWindowHandles = driver.getWindowHandles();
        		 int count = allWindowHandles.size();
        		 System.out.println("Number of browser windows opened on the system is : "+ count);
        		 for (String windowHandle : allWindowHandles) {
        		 //switch to each browser window
        		 driver.switchTo().window(windowHandle);
        		 String actual_title = driver.getTitle();
        		 //Checks whether the actual title contains the specified expected title
        		 if (actual_title.contains(expected_title)) {
        		 driver.close();
        		 System.out.println("Specified Browser window with title -->"+ actual_title +" --> is  closed");
        		 }
    }}
        	 @Test
             public void Handling_Tabs_Using_Get_WindowHandles() throws InterruptedException { 
        		driver.get("https://demo.actitime.com/login.do");
        		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		//get the window handle id of the parent browser window
        		 String parentwindowHandle = driver.getWindowHandle();
        		 //enter username
        		 driver.findElement(By.id("username")).sendKeys("admin");
        		 //enter password
        		 driver.findElement(By.name("pwd")).sendKeys("manager");
        		 //click on actiTIME INC link
        		 driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
        		 //get the number of windows currently opened on the system 
        		 Set<String> allwhs = driver.getWindowHandles();
        		 //switch to all the browser windows
        		 for (String wh : allwhs) {
        		 driver.switchTo().window(wh);
        		 }
        		 //get the title of the tab
        		 String childtitle = driver.getTitle();
        		 System.out.println("Title of the child tab is :"+ childtitle);
        		 //close the child tab
        		 driver.close();
        		 //switch back to the main browser window
        		 driver.switchTo().window(parentwindowHandle);
        		 //close the main browser window
        		 driver.findElement(By.xpath("//div[text()='Login ']")).click();
        		 //closing the parent window
        		 driver.close();
        		 }
        	
        	 @Test
             public void To_Find_Total_Links() throws InterruptedException { 
        		 //to find the total number of links, number of visible links and number of hidden links
        			driver.get("https://demo.actitime.com/login.do");
        			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        			//get the total number of link elements
        			int totalLinks = allLinks.size();
        			System.out.println("total number of links present on the web page is : "+totalLinks);
        			int visibleLinkCount = 0;
        			int hiddenLinkCount = 0;
        			//using foreach loop, iterate through all the links
        			for (WebElement link : allLinks) {
        			//if the link is displayed, then print the text of the link
        			if (link.isDisplayed()) {
        			visibleLinkCount++;
        			System.out.println(visibleLinkCount+" --> "+link.getText());
        			}else{
        			hiddenLinkCount++;
        			}
        			}
        			System.out.println("Total number of visible links :" + visibleLinkCount);
        			System.out.println("Total number of hidden links :" + hiddenLinkCount);
        			driver.close();
       }
        	
}
