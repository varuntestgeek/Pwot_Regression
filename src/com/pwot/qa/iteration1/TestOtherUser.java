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

	public class TestOtherUser extends CommonMethods {

	     static WebDriver driver;
	     
	     @BeforeClass
	     public static void LoginToPwot()
	     {
	    	 CommonMethods.initialization();
	    	 CommonMethods.Login();
	     }
	  
	     @Test(priority = 1 )
	     
	     public static void TestUserSelectionForOthr()
	     {
	    		CommonMethods.SelectUser("SampleOther1");
	     }
	    
	     @Test(priority=2)
	     public static void ValidateLogoForOthr()
	     {
	    		CommonMethods.ValidateATTLogo();
	     }
	     
	     @Test(priority = 3)
	     
	     public static void ValidateMessageDisplayedForOthr()
	     {
	    	 CommonMethods.ValidateMessage("SampleOther1");
	     }
	     @Test(priority = 4)
	     public static void ValidateMenuDisplayedForAEManagerForOthr()
	     {
	 		CommonMethods.ValidateLinkDisplayed("SampleOther1-Manager"); 
	     }
	     @Test(priority = 5 )
		
	     public static void AE_ManagerInsertFunctionForOthr() throws InvalidFormatException, IOException
	     {
			CommonMethods.ClickOnManageLink("Other");
			
			CommonMethods.ValidateInsertFunctionality("Other","Wholesale");	
			
			
			
		}
	     @Test(priority = 6)
	     public static void ModifyFuctionalityForOthr() throws InterruptedException
	     {
	    	 ValidateModifyFunctionality("Other Manager");
	     }
		
		@Test(priority = 7)
		
		public static void CopyFunctionalityForOthr() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("Other Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionalityForOthr() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("Other Manager");
		}
		@Test(priority =9)
		public static void OutBoundMartrixForOthr()
		{
			CommonMethods.ValidateManageOMatrixInsert();
		}
		@Test(priority= 10)
		public static void UpdateAccount() throws InterruptedException
		{
			CommonMethods.UpdateLink("Othr");
		}
		@Test(priority=11)
		public static void LoggedAsInfo()
		{
			CommonMethods.loggedAs("OTHER Manager");
		}
		@AfterClass
		public static void aftertest()
		{
		CommonMethods.close();
		}
	}


