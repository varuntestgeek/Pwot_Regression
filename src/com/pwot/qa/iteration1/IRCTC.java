package com.pwot.qa.iteration1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IRCTC {
	
	static WebDriver driver;
	
	@Test
	public static void Test()
	{  
	driver =new FirefoxDriver();
	
	driver.manage().window().maximize();
		
    driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
    
    driver.findElement(By.xpath("//input[@id='usernameId']")).sendKeys("ARU_SHAIKH");
    
    driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("Abcd@1234");
    
    Scanner reader = new Scanner(System.in);  
    
    System.out.println("Enter a captcha: ");
    
    String n = reader.nextLine();
    
    driver.findElement(By.xpath("//input[@id='nlpAnswer']")).sendKeys(n);
    
    driver.findElement(By.xpath(".//*[@id='loginbutton']")).submit();
    
    driver.findElement(By.xpath(".//*[@id='jpform:fromStation']")).sendKeys("JL");
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.findElement(By.xpath("//a[text()='JALGAON JN - JL']")).click();
    
    
    
    
    
    

    
    
   
	}
}
