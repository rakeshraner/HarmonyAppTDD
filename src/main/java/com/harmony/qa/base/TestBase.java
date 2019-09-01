package com.harmony.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

public class TestBase
{
	protected static Properties prop;
	protected static WebDriver driver;
	protected static Logger log= Logger.getLogger(TestBase.class);

	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("//Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//com//harmony//qa//data//config.properties");
			prop.load(fis);
		} catch (FileNotFoundException ex)
		{
			log.info("File Not found exception "+ ex.getMessage().toString());
		} catch (IOException e)
		{
			log.info("IO exception " + e.getMessage().toString());
		}
	}

	protected static void launchApp()
	{
		if (prop.getProperty("browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/rakeshrane/Tools/chromedriver");
			driver = new ChromeDriver();
			log.info("Chrome Driver launched ");
		} else if (prop.getProperty("browser").contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/rakeshrane/Tools/geckodriver");
			driver = new FirefoxDriver();
			log.info("Firefox Driver launched ");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get(prop.getProperty("appURL"));
	}

	protected void closeBrowserWindow()
	{
		if (driver != null)
		{
			driver.close();
			log.info("Browser current tab closed");
		}
	}

	protected void quiteBrowser()
	{
		if (driver != null)
		{
			driver.quit();
			log.info("Browser Quite");
		}
	}

}
