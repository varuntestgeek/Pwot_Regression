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

	public class TestCustomerUser extends CommonMethods {

	     static WebDriver driver;
	     
	     @BeforeClass
	     public static void LoginToPwot()
	     {
	    	 CommonMethods.initialization();
	    	 CommonMethods.Login();
	     }
	  
	     @Test(priority = 1 )
	     
	     public static void TestUserSelectionForCu()
	     {
	    		CommonMethods.SelectUser("SampleCustomerUser1");
	     }
	    
	     @Test(priority=2)
	     public static void ValidateLogoForCu()
	     {
	    		CommonMethods.ValidateATTLogo();
	     }
	     
	     @Test(priority = 3)
	     
	     public static void ValidateMessageDisplayedForCu()
	     {
	    	 CommonMethods.ValidateMessage("SampleCustomerUser1");
	     }
	     @Test(priority = 4)
	     public static void ValidateMenuDisplayedForCuManager()
	     {
	 		CommonMethods.ValidateLinkDisplayed("SampleCustomerUser1-Manager"); 
	     }
	     @Test(priority = 5 )
		
	     public static void Customer_ManagerInsertFunctionalityForCu() throws InvalidFormatException, IOException
	     {
			CommonMethods.ClickOnManageLink("Customer");
			
			CommonMethods.ValidateInsertFunctionality("CustomerUser","Wholesale");	
		 }
	     @Test(priority = 6)
	     public static void ModifyFuctionalityForCu() throws InterruptedException
	     {
	    	 ValidateModifyFunctionality("Customer Manager");
	     }
		
		@Test(priority = 7)
		
		public static void CopyFunctionalityForCu() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("Customer Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionalityForCu() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("Customer Manager");
		}
		@Test(priority= 9)
		public static void UpdateAccount() throws InterruptedException
		{
			CommonMethods.UpdateLink("Cu");
		}
		@Test(priority=10)
		public static void LoggedAsInfo()
		{
			CommonMethods.loggedAs("Customer Manager");
		}
		@AfterClass
		public static void aftertest()
		{
		CommonMethods.close();
		}
	}


