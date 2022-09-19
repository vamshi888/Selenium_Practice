package com.bridzelabz.selenium;

import java.util.Scanner; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

		public class User_Input_Browser_Testing {
		public static void main(String[] args) {
			System.out.println("Choose below available different browsers for testing");
			Options();
}
		public static void Options() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.Test with firefoxdriver");
			System.out.println("2.Test with chromedriver");
			System.out.println("3.Test with msedgedriver");
			System.out.println("4.Exit");
			System.out.println("Enter Your choice:");
			// int input;
			int choice = scanner.nextInt();
			scanner.nextLine();
			while (choice != 0 && choice <= 4)
				switch (choice) {
				case 1:
					while (choice == 1) {
						try {
							geckodriver();

						} catch (InterruptedException e) {

							e.printStackTrace();
   }
					}
					break;
				case 2:
					while (choice == 2) {
						try {
							chromedriver();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
}
					break;
				case 3:
					while (choice == 3) {
						try {
							msedgedriver();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
}
					break;
}
}
		public static void geckodriver() throws InterruptedException {

			System.setProperty("webdriver.gecko.driver","C:\\Users\\hp\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			email.sendKeys("vamshik484@gmail.com");
			Thread.sleep(3000);
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys("Vamshi@123");
			Thread.sleep(3000);
			driver.findElement(By.linkText("Log In")).click();
			Thread.sleep(2000);
			driver.close();
}

		public static void chromedriver() throws InterruptedException {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			email.sendKeys("vamshik484@gmail.com");
			Thread.sleep(3000);
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys("Vamshi@123");
			Thread.sleep(3000);
			driver.findElement(By.name("login")).click();
			Thread.sleep(2000);
			driver.close();
}

		public static void msedgedriver() throws InterruptedException {
			System.setProperty("webdriver.edge.driver","C:\\Users\\hp\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.facebook.com/");
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			email.sendKeys("vamshik484@gmail.com");
			Thread.sleep(3000);
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys("Vamshi@123");
			Thread.sleep(3000);
			driver.findElement(By.name("login")).click();
			Thread.sleep(2000);
			driver.close();

}
}
