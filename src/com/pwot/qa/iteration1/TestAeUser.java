package com.pwot.qa.iteration1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAeUser extends CommonMethods {

     static WebDriver driver;
     
     @BeforeClass
     public static void LoginToPwot()
     {
    	 CommonMethods.initialization();
    	 CommonMethods.Login();
     }
  
     @Test(priority = 1 )
     
     public static void TestUserSelection()
     {
    		CommonMethods.SelectUser("AEuser1");
     }
    
     @Test(priority=2)
     public static void ValidateLogo()
     {
    		CommonMethods.ValidateATTLogo();
     }
     
     @Test(priority = 3)
     
     public static void ValidateMessageDisplayed()
     {
    	 CommonMethods.ValidateMessage("AEuser1");
     }
     @Test(priority = 4)
     public static void ValidateMenuDisplayedForAEManager()
     {
 		CommonMethods.ValidateLinkDisplayed("AEuser1-Manager"); 
     }
     @Test(priority = 5 )
	
     public static void AE_ManagerInsertFunction() throws InvalidFormatException, IOException
     {
		CommonMethods.ClickOnManageLink("AE");
		
		CommonMethods.ValidateInsertFunctionality("AEUser","Wholesale");	
		
		
		
	}
     @Test(priority = 6)
     public static void ModifyFuctionality()
     {
    	 ValidateModifyFunctionality("AE Manager");
     }
	
	@Test(priority = 7)
	
	public static void CopyFunctionality() throws InvalidFormatException, IOException, InterruptedException
	{
		ValidateCopyFunctionality("AE Manager");
	}

	@Test(priority= 8)
	public static void NewButtonFunctionality() throws IOException, InterruptedException
	{
		CommonMethods.ValidateNewFunctionality("AE Manager");
	}
	@AfterClass
	public static void aftertest()
	{
	CommonMethods.aftcls();
	}
}
