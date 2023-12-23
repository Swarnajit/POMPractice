package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch 
{
	WebDriver driver;
	public GoogleSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By searchBox = By.xpath("//textarea[@name='q']");
	
	public void searchGoogle(String searchInput)
	{
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).sendKeys(searchInput);
		
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
}
