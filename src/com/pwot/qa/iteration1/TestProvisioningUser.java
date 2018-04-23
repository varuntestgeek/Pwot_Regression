package com.pwot.qa.iteration1;

	import java.io.IOException;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class TestProvisioningUser extends CommonMethods {
		
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
	   		CommonMethods.SelectUser("SampleProvisioningAccount");
	    }
	   
	    @Test(priority=2)
	    public static void ValidateLogo()
	    {
	   		CommonMethods.ValidateATTLogo();
	    }
	    
	    @Test(priority = 3)
	    
	    public static void ValidateMessageDisplayed()
	    {
	   	 CommonMethods.ValidateMessage("SampleProvisioningAccount");
	    }
	    @Test(priority = 4)
	    public static void ValidateMenuDisplayedForAEManager()
	    {
			CommonMethods.ValidateLinkDisplayed("SampleProvisioningAccount-Manager"); 
	    }
	    @Test(priority = 5 )
		
	    public static void TC__ManagerInsertFunction() throws InvalidFormatException, IOException
	    {
			CommonMethods.ClickOnManageLink("Provisioning");
			
			CommonMethods.ValidateInsertFunctionality("SampleProvisioningAccount","Wholesale");	
			
		}
	    @Test(priority = 6)
	    public static void ModifyFuctionality()
	    {
	   	 ValidateModifyFunctionality("Provisioning Manager");
	    }
		
		@Test(priority = 7)
		
		public static void CopyFunctionality() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("Provisioning Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionality() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("Provisioning Manager");
			
		}

	}


