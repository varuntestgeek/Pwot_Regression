package com.pwot.qa.iteration1;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSdmUser extends CommonMethods {
	
	static WebDriver driver;
    
    @BeforeClass
    public static void LoginToPwot()
    {
    	CommonMethods.initialization();
    	CommonMethods.Login();
    }
 
    @Test(priority = 9 )
    
    public static void TestUserSelection()
    {
   		CommonMethods.SelectUser("SampeSDM1");
    }
   
    @Test(priority=10)
    public static void ValidateLogo()
    {
   		CommonMethods.ValidateATTLogo();
    }
    
    @Test(priority = 11)
    
    public static void ValidateMessageDisplayed()
    {
   	 CommonMethods.ValidateMessage("SampeSDM1");
    }
    @Test(priority = 12)
    public static void ValidateMenuDisplayedForAEManager()
    {
		CommonMethods.ValidateLinkDisplayed("SampleSDM-Manager"); 
    }
    @Test(priority = 13 )
	
    public static void TC__ManagerInsertFunction() throws InvalidFormatException, IOException
    {
		CommonMethods.ClickOnManageLink("SDM");
		
		CommonMethods.ValidateInsertFunctionality("SampleSDM","Wholesale");	
		
	}
    @Test(priority = 14)
    public static void ModifyFuctionality()
    {
   	 ValidateModifyFunctionality("SDM Manager");
    }
	
	@Test(priority = 15)
	
	public static void CopyFunctionality() throws InvalidFormatException, IOException, InterruptedException
	{
		ValidateCopyFunctionality("SDM Manager");
	}

	@Test(priority= 16)
	public static void NewButtonFunctionality() throws IOException, InterruptedException
	{
		CommonMethods.ValidateNewFunctionality("SDM Manager");
		
	}

}
