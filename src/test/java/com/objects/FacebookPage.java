package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage 
{
	WebDriver driver;
	public FacebookPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By searchBox = By.xpath("//input[@name='q')");
}
