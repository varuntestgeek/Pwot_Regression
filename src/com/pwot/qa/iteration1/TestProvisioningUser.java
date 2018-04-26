package com.pwot.qa.iteration1;

	import java.io.IOException;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class TestProvisioningUser extends CommonMethods {
		
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
	    
	    public static void TestUserSelectionForPro()
	    {
	   		CommonMethods.SelectUser("SampleProvisioningAccount");
	    }
	   
	    @Test(priority=2)
	    public static void ValidateLogoForPro()
	    {
	   		CommonMethods.ValidateATTLogo();
	    }
	    
	    @Test(priority = 3)
	    
	    public static void ValidateMessageDisplayedForPro()
	    {
	   	 CommonMethods.ValidateMessage("SampleProvisioningAccount");
	    }
	    @Test(priority = 4)
	    public static void ValidateMenuDisplayedForAEManagerForPro()
	    {
			CommonMethods.ValidateLinkDisplayed("SampleProvisioningAccount-Manager"); 
	    }
	    @Test(priority = 5 )
		
	    public static void TC__ManagerInsertFunctionForPro() throws InvalidFormatException, IOException
	    {
			CommonMethods.ClickOnManageLink("Provisioning");
			
			CommonMethods.ValidateInsertFunctionality("SampleProvisioningAccount","Wholesale");	
			
		}
	    @Test(priority = 6)
	    public static void ModifyFuctionalityForPro() throws InterruptedException
	    {
	   	 ValidateModifyFunctionality("Provisioning Manager");
	    }
		
		@Test(priority = 7)
		
		public static void CopyFunctionalityForPro() throws InvalidFormatException, IOException, InterruptedException
		{
			ValidateCopyFunctionality("Provisioning Manager");
		}

		@Test(priority= 8)
		public static void NewButtonFunctionalityForPro() throws IOException, InterruptedException
		{
			CommonMethods.ValidateNewFunctionality("Provisioning Manager");
			
		}
		@Test(priority =9)
		public static void OutBoundMartrixForPro()
		{
			CommonMethods.ValidateManageOMatrixInsert();
		}
		@Test(priority= 10)
		public static void UpdateAccount() throws InterruptedException
		{
			CommonMethods.UpdateLink("Pro");
		}
		@Test(priority=11)
		public static void LoggedAsInfo()
		{
			CommonMethods.loggedAs("Provisioning Manager");
		}
	}


