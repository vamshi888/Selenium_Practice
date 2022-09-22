package com.bridzelabz.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webtable {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
        @Test
        public void Web_Table_Example() throws InterruptedException { 
        	driver.get("C:\\Users\\hp\\Desktop\\WebTable.html");
        	//Count Total number of rows present in the table
        	List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        	int totalRows = allRows.size();
        	System.out.println("total number of rows present in the table is :"+ totalRows);
        	//count total number of columns
        	List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        	int totalColumns = allColumns.size();
        	System.out.println("Total number of columns in the table is :" + totalColumns);
        	//Count number of cells present in the table
        	List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        	int totalCells = allCells.size();
        	System.out.println("Total number of cells present in the table is :" + totalCells);
        	//Print ONLY the numbers
        	int countNumberValue = 0;
        	int sum=0;
        	for (WebElement cell : allCells) {
        	String cellValue = cell.getText();
        	try{
        	int number = Integer.parseInt(cellValue);
        	System.out.print(""+number);
        	countNumberValue++;
        	sum = sum+number;
        	}catch (Exception e) {
        	}
        	}
        	System.out.println("Total count of numeric values is :"+countNumberValue);
        	System.out.println("Total sum of all the numeric values is :"+sum);
        	//close the browser
        	driver.close();
        }
        @Test
        public void Web_Table_Assignment() throws InterruptedException { 
        	driver.get("C:\\Users\\hp\\Desktop\\webtableAssignment.html");
        	WebElement physics = driver.findElement(By.xpath("//td[text()='10']"));
        	WebElement maths = driver.findElement(By.xpath("//td[text()='40']"));
        	WebElement chemistry = driver.findElement(By.xpath("//td[text()='50']"));
        	
        	//int sum = ((physics)+(maths)+(chemistry));
        //	System.out.println("sum is +( physics + maths + chemistry));
        
        }
        @Test
        public void No_Of_Auto_Suggestions() throws InterruptedException {     	
             driver.get("https://www.google.com/");
        	//Enter Selenium in google search text box
        	driver.findElement(By.id("lst-ib")).sendKeys("selenium");
        	Thread.sleep(2000);
        	List<WebElement> allOptions = 
        	driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        	int count = allOptions.size();
        	System.out.println("Number of values present in the dropdown is : " + count);
        	String expectedValue="selenium interview questions";
        	//Print all the auto suggestion values
        	for (WebElement option : allOptions) {
        	String text = option.getText();
        	System.out.println(" "+text);
        	//Click on Java Interview Questions
        	if (text.equalsIgnoreCase(expectedValue)) {
        	option.click();
        	break;
        	}
        	}}
        @Test
        public void Select_Few_Elements_In_Listbox() throws InterruptedException {     	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement list = driver.findElement(By.id("mtr"));
           //Create an object of Select class and pass the address of list box as an argument
           Select s = new Select(list);
           //getOptions() method returns a list of all the elements of the list box
           List<WebElement> options = s.getOptions();
           int size = options.size();
           System.out.println("Number of elements present inside the listbox is : "+ size);
           //Print all the elements present in the list box
           for (WebElement webElement : options) {
           String text = webElement.getText();
           System.out.println(text);
           }
           //selectByIndex() selects an element based on the Index, here index starts with 0
           s.selectByIndex(0);
           //selectByValue() method selects an element based on its value attribute.
           s.selectByValue("v");
           /*selectByVisibleText() method selects an element based on the actual text that is visible to the 
           user. For instance, if there are multiple Poori present inside the listbox , it will select all the 
           Poori elements.*/
           s.selectByVisibleText("Poori");
           System.out.println("************Print all selected options***********");
           List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
           int size2 = allSelectedOptions.size();
           System.out.println("Number of items that is selected in the list box is : "+size2);
           System.out.println(" Selected items are printed below ");
           for (WebElement webElement : allSelectedOptions) {
           System.out.println(webElement.getText());
           }
           System.out.println("check whether it is a multiple select listbox or not");
           boolean multiple = s.isMultiple();
           System.out.println(multiple +" yes , it is multi select");
           if (multiple) {
           //Print the first selected option in the list box
           WebElement firstSelectedOption = s.getFirstSelectedOption();
           System.out.println(firstSelectedOption.getText()+" is the first selected item in the list box");
           //deselect the item present in 0th index.
           s.deselectByIndex(0);
           //Print the first selected option in the list box
           WebElement firstSelectedOption1 = s.getFirstSelectedOption();
           System.out.println(firstSelectedOption1.getText()+" is the first selected item");
           //deselect an item which has an attribute called value and its value is "v"
           s.deselectByValue("v");
           //Print the first selected option in the list box
           WebElement firstSelectedOption2 = s.getFirstSelectedOption();
           System.out.println(firstSelectedOption2.getText()+" is the first selected item");
           s.deselectByVisibleText("Poori");
           }
           }
        @Test
        public void Print_Listbox_Values_InSorted_Order() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement listElement = driver.findElement(By.id("mtr"));
             Select s = new Select(listElement);
             List<WebElement> allOptions = s.getOptions();
             int count = allOptions.size();
             System.out.println(count);
             System.out.println("-----print the values in the list ----");
             ArrayList<String> list = new ArrayList<String>();
             for (WebElement option : allOptions) {
             String text = option.getText();
             System.out.println(text);
             list.add(text);
             }
             Collections.sort(list);
             System.out.println("-----print the value in sorted order----");
             for (String value : list) {
             System.out.println(value); 
             }}
        @Test
        public void Print_Unique_Element_In_Listbox() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement listElement = driver.findElement(By.id("mtr"));
             Select s = new Select(listElement);
             List<WebElement> allOptions = s.getOptions();
             int count = allOptions.size();
             System.out.println(count);
             System.out.println("-----print the values in the list ----");
             HashSet<String> allElements = new HashSet<String>();
             for (WebElement option : allOptions) {
             String text = option.getText();
             System.out.println(text);
             allElements.add(text);
             }
             System.out.println(allElements);
             }
        @Test
        public void Print_Unique_Element_In_Sorted_Order_Listbox() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement listElement = driver.findElement(By.id("mtr"));
             Select s = new Select(listElement);
             List<WebElement> allOptions = s.getOptions();
             int count = allOptions.size();
             System.out.println(count);
             System.out.println("-----print the values in the list ----");
             TreeSet<String> allElements = new TreeSet<String>();
             for (WebElement option : allOptions) {
             String text = option.getText();
             System.out.println(text);
             allElements.add(text);
             }
             System.out.println(allElements);
        
   }
        @Test
        public void Check_Listbox_Has_Duplicate_Values() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement listbox = driver.findElement(By.id("mtr"));
             Select s = new Select(listbox);
             List<WebElement> allOptions = s.getOptions();
             int count1 = allOptions.size();
             System.out.println("Number of elements in the list is :" +count1);
             HashSet<String> allElementText = new HashSet<String>();
             for (int i = 0; i < count1; i++) {
             String text = allOptions.get(i).getText();
             System.out.println(text);
             allElementText.add(text);
             }
             int count2 = allElementText.size();
             System.out.println("Number of elements in the hashset is :" +count2);
             if (count1==count2) {
             System.out.println("list box has NO duplicate values");
             }
             else{
             System.out.println("list box has duplicate values");
             }
             System.out.println(allElementText);
             driver.close();
             }
        @Test
        public void Print_Duplicate_Values() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement listbox = driver.findElement(By.id("mtr"));
             Select s = new Select(listbox);
             List<WebElement> allOptions = s.getOptions();
             int count1 = allOptions.size();
             System.out.println("Number of elements in the list is :" +count1);
             HashSet<String> allElementText = new HashSet<String>();
             for (int i = 0; i < count1; i++) {
             String text = allOptions.get(i).getText();
            /*allElementText.add(text) returns true if the element is not already 
            added, and it returns false if the same element is trying to be added 
            twice. */
             if (!allElementText.add(text)) {
             System.out.println(text +" is the duplicate item in the list box");
             }
             }
             System.out.println(allElementText.size());
             // it will print all the unique values in the HashSet object
             System.out.println(allElementText);
             driver.close();
             }
        @Test
        public void Occurance_Of_Poori() throws InterruptedException {      	
             driver.get("C:\\Users\\hp\\Desktop\\breakfastdropdown.html");
             WebElement list = driver.findElement(By.id("mtr"));
             Select s = new Select(list);
             List<WebElement> allElements = s.getOptions();
             HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();
             for (WebElement element : allElements) {
             String text = element.getText();
             if (hashMapObj.containsKey(text)) {
             Integer value = hashMapObj.get(text);
             value++;
             hashMapObj.put(text, value);
             }else{
             hashMapObj.put(text, 1);
             }
             }
             Set<String> allKeys = hashMapObj.keySet();
             for (String key : allKeys) {
             Integer value = hashMapObj.get(key);
             System.out.println(key +" -->"+ value);
             if (value>1) {
             System.out.println("Occurance of " + key + " is :" + value);
             }}}
          
        }