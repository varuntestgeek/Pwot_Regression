package com.pwot.qa.iteration1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Verify;

public class CommonMethods {
    
	static WebDriver driver;
	
	static String methodName;

	public static DateFormat date;
	
	public static Date dateobj;
	
	public static String DateTime;
	
	public static String LoginName;
	
	public static void initialization(){
   
	date = new SimpleDateFormat("hh/mm/ss");
	
	dateobj = new Date();
	
	DateTime =date.format(dateobj);
	
	LoginName = DateTime;
	}
	public static void Login()
	
	{			  
		  driver = new FirefoxDriver();
		  
		  driver.manage().window().maximize();
		  
		  driver.get(DataFile.Pwot_ST_URL);
		  
		  driver.findElement(By.linkText(PropertyFile.lPrimeProductLink)).click();
		  
		  driver.findElement(By.name(PropertyFile.nUsername)).sendKeys(DataFile.username);
		 
		  driver.findElement(By.name(PropertyFile.nPassword)).sendKeys(DataFile.password);
		  
		  driver.findElement(By.name(PropertyFile.nLoginSubmit)).click();
		  
		  driver.findElement(By.name(PropertyFile.nSuccessOk)).click();
		  
		  
		  
	}
	
	public static void SelectUser(String Username)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement dropdown = driver.findElement(By.xpath(PropertyFile.xUserDropdown));
		
		Select UserDropdown = new Select(dropdown);
		
		UserDropdown.selectByVisibleText(Username);
		
		driver.findElement(By.xpath(PropertyFile.xUserSubmit)).click();;
	}
	
	public static void ValidateATTLogo()
	{
		WebElement ATTLogo = driver.findElement(By.xpath(PropertyFile.xATTLogo));
		
		Verify.verify(ATTLogo.isDisplayed());
	}
	
	public static void ValidateMessage(String UserType)
	{
		if(UserType == "AEUser1")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForAE));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}

		else if(UserType == "SampleTC")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForTC));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "SampeSDM1")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForSDM));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "SampleProvisioningAccount")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForProvisioning));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "SampleSFC/CSSS")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForOfc));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "SampleCustomerUser1")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForCustomer));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "SampleOther1")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForOther));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
		else if(UserType == "Admin133")
		{
		WebElement Message = driver.findElement(By.xpath(PropertyFile.xMessageForAdmin));
		
		System.out.println(Message.getText());
	
		Verify.verify(Message.isDisplayed());
		
		}
	}
	
	public static void ValidateLinkDisplayed(String UserType)
	{
		if (UserType =="AEuser1-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","Manage AE Account","View TC Account","View SDM Account","View Provisioning Account","View OFC/CSSS Account","View Others Account","Update Your Account");	  
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		else if (UserType =="Admin")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","Manage Customer User Account","Manage AE Account","Manage TC Account","Manage SDM Account","Manage Provisioning Account","Manage OFC/CSSS Account","Manage Others Account","Manage Admin Account","Update Your Account","Change Message");			  
			
			List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		
		else if (UserType =="AEuser1-Operator")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","View NCOS Tables","View Branch Account","View Customer User Account","View AE Account","View TC Account","View SDM Account","View Provisioning Account","View OFC/CSSS Account","View Others Account","Update Your Account");
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		
		else if (UserType =="SampleTC-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","View AE Account","Manage TC Account","View SDM Account","View Provisioning Account","View OFC/CSSS Account","View Others Account","Update Your Account");	  				  
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		
		else if (UserType =="SampleSDM-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","View AE Account","View TC Account","Manage SDM Account","View Provisioning Account","View OFC/CSSS Account","View Others Account","Update Your Account");	  				  
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		else if (UserType =="SampleProvisioningAccount-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","View AE Account","View TC Account","View SDM Account","Manage Provisioning Account","View OFC/CSSS Account","View Others Account","Update Your Account");	  				  
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		else if (UserType =="SampleSFC/CSSS-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","View AE Account","View TC Account","View SDM Account","View Provisioning Account","Manage OFC/CSSS Account","View Others Account","Update Your Account");	  				  
			  
			  List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		else if (UserType =="SampleCustomerUser1-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Reports","Manage Customer User Account","Update Your Account");			  
			 
			List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
		else if (UserType =="SampleOther1-Manager")
		{
			List<String> ExpectedMainList = Arrays.asList("Customer Information", "Find Order", "Unparsed CSR Request", "Lec Address Validation", "Reports","Manage OutBound Matrix Table","Manage Branch Account","View Customer User Account","View AE Account","View TC Account","View SDM Account","View Provisioning Account","View OFC/CSSS Account","Manage Others Account","Update Your Account");			 
			
			List<WebElement> optionCount = driver.findElements(By.tagName("a"));
			  
			  for (int a=0;a<=ExpectedMainList.size()-1;a++)
			  
			  {
				  String ExpectedMenu = ExpectedMainList.get(a);		
				  
				  String ActualMenu = (optionCount.get(a).getText());			
				
				  //Compare each menu with expected menu  			  
				  
				  Assert.assertEquals(ExpectedMenu, ActualMenu);			  

				  //System.out.println("Above Menu is present in main page:"+ActualMenu +" and it is displayed with Sr No."+a);
			  }
		}
	}
	
	public static void ClickOnManageLink(String UserType)
	{
		
		if(UserType.equals("AE"))
		{
			driver.findElement(By.xpath(PropertyFile.xManageAE)).click();
		}
		else if(UserType.equals("Admin"))
		{
			driver.findElement(By.xpath(PropertyFile.xManageAdmin)).click();
		}
		else if(UserType.equals("TC"))
		{
			driver.findElement(By.xpath(PropertyFile.xManageTC)).click();
		}
		else if(UserType.equals("SDM"))
		{
			driver.findElement(By.xpath(PropertyFile.xManageSDM)).click();
		}
		else if(UserType.equals("Provisioning"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageProvisioning)).click();	
		}
		else if(UserType.equals("OFC/CSSS"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageOfc)).click();	
		}
		else if(UserType.equals("Customer"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageCustomer)).click();	
		}
		else if(UserType.equals("Other"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageOther)).click();	
		}
	
	}
	public static void ValidateAdminCreate(String UserType)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println(LoginName);
		
		driver.findElement(By.xpath(PropertyFile.xNameField1)).sendKeys(LoginName);
	
		driver.findElement(By.xpath(PropertyFile.xHRIDField1)).sendKeys(DateTime);
		
		driver.findElement(By.xpath(PropertyFile.xTelephoneNumber1)).sendKeys(DataFile.PhoneNumber);
		
		driver.findElement(By.xpath(PropertyFile.xEmailField1)).sendKeys(DataFile.EmailAdress);
		
		driver.findElement(By.xpath(PropertyFile.xFaxNumber1)).sendKeys(DataFile.FaxNumber);
		
		driver.findElement(By.xpath(PropertyFile.xPagerNumber1)).sendKeys(DataFile.PagerNumber);
		
		driver.findElement(By.xpath(PropertyFile.xLoginName1)).sendKeys("TestLoginName"+DateTime);
		
		driver.findElement(By.xpath(PropertyFile.xATTID1)).sendKeys(DataFile.ATTId);
		
		driver.findElement(By.xpath(PropertyFile.xInsertButton)).click();
		
		Alert alert = driver.switchTo().alert();
		
		String al = alert.getText();
		
		if(al.equals("Data Inserted Successfully"))
		{
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
			
			driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
			 
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			boolean displayed = driver.findElement(By.linkText(LoginName)).isDisplayed();
			
			if(displayed == true)
			{
				System.out.println("User "+LoginName+" has been inserted in database successfully");
				
				driver.findElement(By.xpath(PropertyFile.xMainButton)).click();	
			}
			
			else
				
			{
				System.out.println("failed to insert data successfully");
			}
		}
		
		else
		{
			System.out.println(al);
			
			alert.accept();
		}
		
	}
	
	public static void ValidateInsertFunctionality(String UserType,String WholesaleValue)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println(LoginName);
		
		driver.findElement(By.xpath(PropertyFile.xNameField)).sendKeys(LoginName);
		
		if(UserType!="CustomerUser")
		{
		driver.findElement(By.xpath(PropertyFile.xHRIDField)).sendKeys(DateTime);
		}
		else{}
		driver.findElement(By.xpath(PropertyFile.xTelephoneNumber)).sendKeys(DataFile.PhoneNumber);
		
		driver.findElement(By.xpath(PropertyFile.xEmailField)).sendKeys(DataFile.EmailAdress);
		
		driver.findElement(By.xpath(PropertyFile.xFaxNumber)).sendKeys(DataFile.FaxNumber);
		
		driver.findElement(By.xpath(PropertyFile.xPagerNumber)).sendKeys(DataFile.PagerNumber);
		
		//driver.findElement(By.xpath(PropertyFile.xSalesCode)).sendKeys(DataFile.SalesCode);
		
		if(UserType =="AEUser")
		{
		WebElement Strata =driver.findElement(By.xpath(PropertyFile.xStrata));
			
		Select StrataDropdown = new Select(Strata);
		
		StrataDropdown.selectByVisibleText(WholesaleValue);
		}
		else
		{
			
		}
		driver.findElement(By.xpath(PropertyFile.xLoginName)).sendKeys("TestLoginName"+DateTime);
		
		driver.findElement(By.xpath(PropertyFile.xATTID)).sendKeys(DataFile.ATTId);
		
		driver.findElement(By.xpath(PropertyFile.xUserTypeOpr)).click();
		
		driver.findElement(By.xpath(PropertyFile.xInsertButton)).click();
		
		Alert alert = driver.switchTo().alert();
		
		String al = alert.getText();
		
		if(al.equals("Data sucessfully Inserted"))
		{
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
			
			driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
			 
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			boolean displayed = driver.findElement(By.linkText(LoginName)).isDisplayed();
			
			if(displayed == true)
			{
				System.out.println("User "+LoginName+" has been inserted in database successfully");
				
				driver.findElement(By.xpath(PropertyFile.xMainButton)).click();	
			}
			
			else
				
			{
				System.out.println("failed to insert data successfully");
			}
		}
		
		else
		{
			System.out.println(al);
			
			alert.accept();
		}
		
	}
	
	public static void ValidateModifyFunctionality(String UserType) throws InterruptedException
	{	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		if(UserType == "AE Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageAE)).click();
		}
		else if(UserType =="TC Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageTC)).click();
		}
		else if(UserType=="SDM Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageSDM)).click();
		}
		else if(UserType=="Provisioning Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageProvisioning)).click();
		}
		else if(UserType.equals("OFC/CSSS Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageOfc)).click();	
		}
		else if(UserType.equals("Customer Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageCustomer)).click();	
		}
		else if(UserType.equals("Other Manager"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageOther)).click();	
		}
		if(UserType.equals("Admin"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageAdmin)).click();	
		
		driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
		
		driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
		
		driver.findElement(By.linkText(LoginName)).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(PropertyFile.xLoginName1)).clear();
			
		driver.findElement(By.xpath(PropertyFile.xModifyButton)).click();
			
		Alert al = driver.switchTo().alert();
			
		Verify.verify(al.getText().contains("Please enter a value for the \"LoginName\" field"));
			
		al.accept();
			
		String Md = LoginName+"Md";
			
		driver.findElement(By.xpath(PropertyFile.xLoginName1)).sendKeys(Md);
		}
		
		else
		{	
			driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
			
			driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
			
			driver.findElement(By.linkText(LoginName)).click();
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(PropertyFile.xLoginName)).clear();
				
			driver.findElement(By.xpath(PropertyFile.xModifyButton)).click();
				
			Alert al = driver.switchTo().alert();
				
			Verify.verify(al.getText().contains("Please enter a value for the \"LoginName\" field"));
				
			al.accept();
				
			String Md = LoginName+"Md";
				
			driver.findElement(By.xpath(PropertyFile.xLoginName)).sendKeys(Md);
		}
		
		driver.findElement(By.xpath(PropertyFile.xModifyButton)).click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		
		//Verify.verify(alertText =="Data sucessfully Modified");
		
		alert.accept();
		
		if(alertText == "Data sucessfully Modified")
		{
				driver.findElement(By.xpath(PropertyFile.xMainButton)).click();
		}
		else
		{
			System.out.println(alertText);
			
			driver.findElement(By.xpath(PropertyFile.xMainButton)).click();
		}
	}
	public static void ValidateCopyFunctionality(String UserType) throws IOException, InterruptedException
	{
		if(UserType == "AE Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageAE)).click();
		}
		else if(UserType =="TC Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageTC)).click();
		}
		else if(UserType == "SDM Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageSDM)).click();
		}
		else if(UserType == "Provisioning Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageProvisioning)).click();
		}
		else if(UserType.equals("OFC/CSSS Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageOfc)).click();	
		}
		else if(UserType.equals("Customer Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageCustomer)).click();	
		}
		else if(UserType.equals("Other Manager"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageOther)).click();	
		}
		else if(UserType == "Admin")
		{
		driver.findElement(By.xpath(PropertyFile.xManageAdmin)).click();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
		
		driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
		
		driver.findElement(By.linkText(LoginName)).click();
		
		driver.findElement(By.xpath(PropertyFile.xCopyButton)).click();
		
		if(UserType=="Admin")
		{
			Thread.sleep(2000);
			
			Verify.verify(driver.findElement(By.xpath(PropertyFile.xNameField1)).getAttribute("value").equals(LoginName));	
		}
		else
		{
			Verify.verify(driver.findElement(By.xpath(PropertyFile.xNameField)).getAttribute("value").equals(LoginName));
		}
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		screenshot();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(PropertyFile.xMainButton)).click();
		
		
	}
	
	public static void ValidateNewFunctionality(String UserType) throws IOException, InterruptedException
	{
		if(UserType == "AE Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageAE)).click();
		}
		else if(UserType =="TC Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageTC)).click();
		}
		else if(UserType =="SDM Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageSDM)).click();
		}
		else if(UserType =="Provisioning Manager")
		{
		driver.findElement(By.xpath(PropertyFile.xManageProvisioning)).click();
		}
		else if(UserType.equals("OFC/CSSS Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageOfc)).click();	
		}
		else if(UserType.equals("Customer Manager"))
		{	
		driver.findElement(By.xpath(PropertyFile.xManageCustomer)).click();	
		}
		else if(UserType.equals("Other Manager"))
		{	
			driver.findElement(By.xpath(PropertyFile.xManageOther)).click();	
		}
		else if(UserType=="Admin")
		{
			driver.findElement(By.xpath(PropertyFile.xManageAdmin)).click();
		}
		driver.findElement(By.xpath(PropertyFile.xSearchField)).sendKeys(LoginName);
		
		driver.findElement(By.xpath(PropertyFile.xSearchButton)).click();
		
		driver.findElement(By.linkText(LoginName)).click();
		
		driver.findElement(By.xpath(PropertyFile.xNewButton)).click();
		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		screenshot();
		
		driver.findElement(By.xpath(PropertyFile.xMainButton)).click();
		}
		public static void close()
		{
			driver.close();
		}
		public static void ValidateManageOMatrixInsert()
		{
		driver.findElement(By.xpath(PropertyFile.xManageOutboundMatrix)).click();
		
		List<WebElement> list1 =driver.findElements(By.xpath(PropertyFile.xTitle));
		
		for(int j=0;j<list1.size();j++)
		{
			list1.get(j).sendKeys(DataFile.Title);
		}
		
		driver.findElement(By.xpath(PropertyFile.xBusinessLine)).sendKeys(DataFile.BusinessLine);
		
		List<WebElement> list =driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0;i<list.size();i++)
		{
			list.get(i).click();	
		}
		
		driver.findElement(By.xpath(PropertyFile.xInsertButton)).click();
		
		Alert al = driver.switchTo().alert();
		
		if(al.getText().contains("Please enter a value to the "))
			
		{
			al.accept();
			
			driver.findElement(By.xpath(PropertyFile.xDMS)).sendKeys(DataFile.DMS);
			
			driver.findElement(By.xpath(PropertyFile.xLucent)).sendKeys(DataFile.Lucent);
			
			driver.findElement(By.xpath(PropertyFile.xInsertButton)).click();
			
			Alert al1 =driver.switchTo().alert();
			
			if(al1.getText().equals("Data Inserted Successfully"))
			{
				al1.accept();
				
				driver.findElement(By.xpath(PropertyFile.xMainButton)).click();
			}
			else
			{
				System.out.println(al1.getText());
			}
		
		}
		else
		{
			System.out.println(al.getText());
		}
		
		}
		public static void UpdateLink(String UserType) throws InterruptedException
		{
			if(UserType=="Cu")
			{
			driver.findElement(By.xpath(PropertyFile.xUpdateAccount1)).click();
			}
			else if(UserType =="Admin")
			{
			driver.findElement(By.xpath(PropertyFile.xUpdateAccount2)).click();
			}
			else
			{
			driver.findElement(By.xpath(PropertyFile.xUpdateAccount)).click();
			}
			
			if(UserType=="Admin")
			{
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).clear();
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).sendKeys(DataFile.EmailAdress+"Md");

				driver.findElement(By.xpath(PropertyFile.xSubmitUpdate)).submit();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(PropertyFile.xMainButton1)).click();
				
				driver.findElement(By.xpath(PropertyFile.xUpdateAccount2)).click();
				
				Verify.verify(driver.findElement(By.xpath(PropertyFile.xEmailField1)).getAttribute("value").equals(DataFile.EmailAdress+"Md"));
				
			}
			else if(UserType=="Cu")
			{   Thread.sleep(2000);
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).clear();
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).sendKeys(DataFile.EmailAdress+"Md");

				driver.findElement(By.xpath(PropertyFile.xSubmitUpdate)).submit();
				
				driver.findElement(By.xpath(PropertyFile.xMainButton1)).click();
				
				driver.findElement(By.xpath(PropertyFile.xUpdateAccount1)).click();
				
				Verify.verify(driver.findElement(By.xpath(PropertyFile.xEmailField1)).getAttribute("value").equals(DataFile.EmailAdress+"Md"));
			}
			else
			{
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).clear();
				
				driver.findElement(By.xpath(PropertyFile.xEmailField1)).sendKeys(DataFile.EmailAdress+"Md");

				driver.findElement(By.xpath(PropertyFile.xSubmitUpdate)).submit();
				
				driver.findElement(By.xpath(PropertyFile.xMainButton1)).click();
				
				driver.findElement(By.xpath(PropertyFile.xUpdateAccount)).click();
				
				Verify.verify(driver.findElement(By.xpath(PropertyFile.xEmailField1)).getAttribute("value").equals(DataFile.EmailAdress+"Md"));
			}
			
			driver.findElement(By.xpath(PropertyFile.xMainButton1)).click();
		}
		
		public static void loggedAs(String UserType)
		{
			boolean result =driver.findElement(By.tagName("p")).isDisplayed();
			
			Assert.assertEquals(result, true);
			
			String actualText = (driver.findElement(By.tagName("p")).getText());
			
			String ExpectedText = "You are logged in as: "+UserType;
			
			Assert.assertEquals(actualText, ExpectedText);
			
		}
		
		public static void screenshot() throws IOException, InterruptedException
		{
		  	
		  	Thread.sleep(5000);
			
			String output = "ScreenShot_";
			
			DateFormat dateFormatObj = new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
			
			Date dateObj = new Date();
			
			String timeDate = dateFormatObj.format(dateObj);
					
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(scrFile, new File("C:\\Arif\\Automation\\Screenshot\\"+output+methodName+"_"+timeDate+".png"));			
		}
		}
