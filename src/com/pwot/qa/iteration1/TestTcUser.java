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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTcUser extends CommonMethods {

     static WebDriver driver;
     
     @BeforeClass
     public static void LoginToPwot()
     {
    	 CommonMethods.initialization();
    	 CommonMethods.Login();
     }
  
     @Test(priority = 1 )
     
     public static void TestUserSelectionForTc()
     {
    		CommonMethods.SelectUser("SampleTC");
     }
    
     @Test(priority=2)
     public static void ValidateLogoForTc()
     {
    		CommonMethods.ValidateATTLogo();
     }
     
     @Test(priority = 3)
     
     public static void ValidateMessageDisplayedForTc()
     {
    	 CommonMethods.ValidateMessage("SampleTC");
     }
     @Test(priority = 4)
     public static void ValidateMenuDisplayedForTcManager()
     {
 		CommonMethods.ValidateLinkDisplayed("SampleTC-Manager"); 
     }
     @Test(priority = 5 )
	
     public static void TC__ManagerInsertFunctionForTc() throws InvalidFormatException, IOException
     {
		CommonMethods.ClickOnManageLink("TC");
		
		CommonMethods.ValidateInsertFunctionality("SampleTC","Wholesale");	
		
		
		
	}
     @Test(priority = 6)
     public static void ModifyFuctionalityForTc() throws InterruptedException
     {
    	 ValidateModifyFunctionality("TC Manager");
     }
	
	@Test(priority = 7)
	
	public static void CopyFunctionalityForTc() throws InvalidFormatException, IOException, InterruptedException
	{
		ValidateCopyFunctionality("TC Manager");
	}

	@Test(priority= 8)
	public static void NewButtonFunctionalityForTc() throws IOException, InterruptedException
	{
		CommonMethods.ValidateNewFunctionality("TC Manager");
	}
	@Test(priority =9)
	public static void OutBoundMartrixForTc()
	{
		CommonMethods.ValidateManageOMatrixInsert();
	}
	@Test(priority= 10)
	public static void UpdateAccount() throws InterruptedException
	{
		CommonMethods.UpdateLink("Tc");
	}
	@Test(priority=11)
	public static void LoggedAsInfo()
	{
		CommonMethods.loggedAs("TC Manager");
	}
	@AfterClass
	public static void aftertest()
	{
	CommonMethods.close();
	}
}

