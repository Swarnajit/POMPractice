package com.tech.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.objects.GoogleSearch;

public class TestMethods_GoogleSearch 
{
	WebDriver dr=WebdriverManager.chromeSetup();
	
	@BeforeTest
	public void beforeTest()
	{		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.get("https://www.google.com");
	}
	
	@Test
	public void searchOperation() throws InterruptedException
	{
		GoogleSearch page = new GoogleSearch(dr);
		dr.manage().window().maximize();
		
		Thread.sleep(1000);
		//WebElement iframe = dr.findElement(By.className("iframe"));
		
		dr.switchTo().frame(0);
		
		dr.findElement(By.xpath("//button[text()='Stay signed out']")).click();
				
		dr.switchTo().defaultContent();
		page.searchGoogle("Real Madrid");
		
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void afterTest()
	{
		dr.quit();
	}

}
