package com.tech.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objects.GoogleSearch;

@Listeners(com.TestNGListener.TestNGListeners.class)
public class TestMethods_GoogleSearch 
{
	WebDriver dr;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser)
	{	
		if(browser.equalsIgnoreCase("firefox"))
		{
			dr = WebdriverManager.firefoxSetup();
		}
		else
			dr = WebdriverManager.chromeSetup();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void searchOperation() throws InterruptedException
	{
		dr.get("https://www.google.com");
		//GoogleSearch page = new GoogleSearch(dr);
		dr.manage().window().maximize();
		
		Thread.sleep(1000);
		//WebElement iframe = dr.findElement(By.className("iframe"));
		try
		{
			dr.switchTo().frame(0);
			
			dr.findElement(By.xpath("//button[text()='Stay signed out']")).click();
					
			dr.switchTo().defaultContent();
		}
		finally
		{
			//page.searchGoogle("Real Madrid");
			dr.findElement(By.xpath("//textarea[@name='q']")).click();
			dr.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Real Madrid");
			
			dr.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		}
		
		Thread.sleep(1000);
	}
	
	@Test
	public void githubLogin()
	{
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		//GoogleSearch page = new GoogleSearch(dr);
		dr.manage().window().maximize();
		
		dr.get("https://github.com/login");
		dr.manage().window().maximize();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		dr.findElement(By.cssSelector("input#login_field")).click();
		dr.findElement(By.cssSelector("input#login_field")).sendKeys("swarnajit.adhikary@yahoo.in");
		
		dr.findElement(By.cssSelector("input#password")).sendKeys("Jhilam@1992");
		
		dr.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement dashBoard = dr.findElement(By.xpath("//span[@class='AppHeader-context-item-label  ' and contains(text(),'Dashboard')]"));
	
		wait.until(ExpectedConditions.visibilityOf(dashBoard));
	
	}
	
	@AfterClass
	public void afterTest()
	{
		dr.quit();
	}

}
