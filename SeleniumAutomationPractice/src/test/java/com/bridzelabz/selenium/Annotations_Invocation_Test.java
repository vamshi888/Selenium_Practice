package com.bridzelabz.selenium;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Annotations_Invocation_Test {
	
	@Test(priority=1, groups={"user", "smoke"})
	public void CreateUser(){
	Reporter.log("CreateUser", true);
	}
	@Test(priority=2, invocationCount=1, enabled=true, groups={"user"})
	public void editUser(){
	Reporter.log("editUser", true);
	}
	@Test(priority=3, groups={"user"})
	public void deleteUser(){
	Reporter.log("deleteUser", true);
	}
	@Test(priority=1, groups={"product", "smoke"})
	public void createProduct(){
	Reporter.log("createProduct", true);
	}
	@Test(priority=2, invocationCount=1, enabled=true, groups={"product"})
	public void editProduct(){
	Reporter.log("editProduct", true);
	}
	@Test(priority=3, groups={"product"})
	public void deleteProduct(){
	Reporter.log("deleteProduct", true);
	}

}
