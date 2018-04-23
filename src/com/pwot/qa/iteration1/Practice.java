package com.pwot.qa.iteration1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {
	
	static WebDriver driver;
	
	@Test
	public static void Test() throws IOException
	{  
	driver =new FirefoxDriver();
	
	driver.manage().window().maximize();
		
    driver.get("http://www.popuptest.com/goodpopups.html");
    
    driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
    
    Set<String> windows = driver.getWindowHandles();
    
    Iterator<String> it =windows.iterator();
    
    String parent = it.next();
    
    String child =it.next();
    
    driver.switchTo().window(child);
    
    driver.manage().window().maximize();
    
    
 
   
	}
}
