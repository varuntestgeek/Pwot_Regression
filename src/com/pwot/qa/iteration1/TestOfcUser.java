package com.pwot.qa.iteration1;

	import java.io.IOException;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class TestOfcUser extends CommonMethods {
		
		static WebDriver driver;
	    
	    @BeforeClass
	    public static void LoginToPwot()
	    {
	     CommonMethods.initialization();
	   	 CommonMethods.Login();
	    }
	    @AfterClass
		public static void aftertest()
		{
		CommonMethods.close();
		}
	    @Test(priority = 1 )
	    
	    public static void TestUserSelectionForOfc()
	    {
	   		CommonMethods.SelectUser("SampleSFC/CSSS");
	    }
	   
	    @Test(priority=2)
	    public static void ValidateLogoForOfc()
	    {
	   		CommonMethods.ValidateATTLogo();
	    }
	    
	    @Test(priority = 3)
	    
	    public static void ValidateMessageDisplayedForOfc()
	    {
	   	 CommonMethods.ValidateMessage("SampleSFC/CSSS");
	    }
	    @Test(priority = 4)
	    public static void ValidateMenuDisplayedForAEManagerForOfc()
	    {
			CommonMethods.ValidateLinkDisplayed("SampleSFC/CSSS-Manager"); 
	    }
	    @Test(priority = 5 )
		
	    public static void OFC__ManagerInsertFunctionForOfc() throws InvalidFormatException, IOException
	    {
			CommonMethods.ClickOnManageLink("OFC/CSSS");
			
			CommonMethods.ValidateInsertFunctionality("SampleSFC/CSSS","Wholesale");	
			
		}
	    @Test(priority = 6)
	    public static void ModifyFuctionalityForOfc() throws InterruptedException
	    {
	   	 ValidateModifyFunctionality("OFC/CSSS Manager");
	    }
		
		@Test(priority = 7)
		
		public static void CopyFunctionalityForOfc() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("OFC/CSSS Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionalityForOfc() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("OFC/CSSS Manager");
			
		}
		@Test(priority =9)
		public static void OutBoundMartrixForOfc()
		{
			CommonMethods.ValidateManageOMatrixInsert();
		}
		@Test(priority= 10)
		public static void UpdateAccount() throws InterruptedException
		{
			CommonMethods.UpdateLink("Ofc");
		}
		@Test(priority=11)
		public static void LoggedAsInfo()
		{
			CommonMethods.loggedAs("OFC Manager");
		}

	}



