package com.tech.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebdriverManager 
{
	public static WebDriver chromeSetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Innovation Project\\JavaTasks\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	public static WebDriver firefoxSetup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Innovation Project\\JavaTasks\\drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		//options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		return driver;
	}
}
