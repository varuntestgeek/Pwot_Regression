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
    @AfterClass
	public static void aftertest()
	{
	CommonMethods.close();
	}
 
    @Test(priority = 1 )
    
    public static void TestUserSelectionForSdm()
    {
   		CommonMethods.SelectUser("SampeSDM1");
    }
   
    @Test(priority=2)
    public static void ValidateLogoForSdm()
    {
   		CommonMethods.ValidateATTLogo();
    }
    
    @Test(priority = 3)
    
    public static void ValidateMessageDisplayedForSdm()
    {
   	 CommonMethods.ValidateMessage("SampeSDM1");
    }
    @Test(priority = 4)
    public static void ValidateMenuDisplayedForSdmManager()
    {
		CommonMethods.ValidateLinkDisplayed("SampleSDM-Manager"); 
    }
    @Test(priority = 5 )
	
    public static void TC__ManagerInsertFunctionForSdm() throws InvalidFormatException, IOException
    {
		CommonMethods.ClickOnManageLink("SDM");
		
		CommonMethods.ValidateInsertFunctionality("SampleSDM","Wholesale");	
		
	}
    @Test(priority = 6)
    public static void ModifyFuctionalityForSdm() throws InterruptedException
    {
   	 ValidateModifyFunctionality("SDM Manager");
    }
	
	@Test(priority = 7)
	
	public static void CopyFunctionalityForSdm() throws InvalidFormatException, IOException, InterruptedException
	{
		ValidateCopyFunctionality("SDM Manager");
	}

	@Test(priority= 8)
	public static void NewButtonFunctionalityForSdm() throws IOException, InterruptedException
	{
		CommonMethods.ValidateNewFunctionality("SDM Manager");
		
	}
	@Test(priority =9)
	public static void OutBoundMartrixForSdm()
	{
		CommonMethods.ValidateManageOMatrixInsert();
	}
	@Test(priority= 10)
	public static void UpdateAccount() throws InterruptedException
	{
		CommonMethods.UpdateLink("Sdm");
	}
	@Test(priority=11)
	public static void LoggedAsInfo()
	{
		CommonMethods.loggedAs("GSM Manager");
	}

}
