package com.pwot.qa.iteration1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
	
		WebElement source = driver.findElement(By.xpath(".//*[@id='draggable']"));
		
		WebElement destination = driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(source).build().perform();
		
		action.moveToElement(destination).build().perform();
		
		action.release(source).build().perform();
		
		
		
		
		
		
	}

}
