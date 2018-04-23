package com.pwot.qa.iteration1;

	import java.io.IOException;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class TestOfcUser extends CommonMethods {
		
		static WebDriver driver;
	    
	    @BeforeTest
	    public static void LoginToPwot()
	    {
	     CommonMethods.initialization();
	   	 CommonMethods.Login();
	    }
	 
	    @Test(priority = 1 )
	    
	    public static void TestUserSelection()
	    {
	   		CommonMethods.SelectUser("SampleSFC/CSSS");
	    }
	   
	    @Test(priority=2)
	    public static void ValidateLogo()
	    {
	   		CommonMethods.ValidateATTLogo();
	    }
	    
	    @Test(priority = 3)
	    
	    public static void ValidateMessageDisplayed()
	    {
	   	 CommonMethods.ValidateMessage("SampleSFC/CSSS");
	    }
	    @Test(priority = 4)
	    public static void ValidateMenuDisplayedForAEManager()
	    {
			CommonMethods.ValidateLinkDisplayed("SampleSFC/CSSS-Manager"); 
	    }
	    @Test(priority = 5 )
		
	    public static void OFC__ManagerInsertFunction() throws InvalidFormatException, IOException
	    {
			CommonMethods.ClickOnManageLink("OFC/CSSS");
			
			CommonMethods.ValidateInsertFunctionality("SampleSFC/CSSS","Wholesale");	
			
		}
	    @Test(priority = 6)
	    public static void ModifyFuctionality()
	    {
	   	 ValidateModifyFunctionality("OFC/CSSS Manager");
	    }
		
		@Test(priority = 7)
		
		public static void CopyFunctionality() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("OFC/CSSS Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionality() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("OFC/CSSS Manager");
			
		}

	}



