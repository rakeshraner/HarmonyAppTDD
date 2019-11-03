package com.harmony.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.harmony.qa.base.TestBase;

public class GenericHelper extends TestBase
{
	public WebElement getElement(By locator)
	{
		log.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);
		try
		{
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re)
		{
			log.error(re);
			throw re;
		}
	}

	public WebElement getElementWithNull(By locator)
	{
		log.info(locator);
		try
		{
			return driver.findElement(locator);
		} catch (NoSuchElementException e)
		{
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator)
	{
		boolean flag = driver.findElements(locator).size() >= 1;
		log.info(flag);
		return flag;
	}

	public static void captureScreenShot(ITestResult result)
	{
		if (prop.getProperty("browser").equalsIgnoreCase("HtmlUnitBrowser"))
		{
			log.fatal("HtmlUnitDriver Cannot take the ScreenShot");
			return;
		}
		if (ITestResult.FAILURE == result.getStatus())
		{
			try
			{
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + result.getName() + ".png"));
				log.info("Successfully captured a screenshot");
			} catch (Exception e)
			{
				log.info("Exception while taking screenshot " + e.getMessage());
			}
		}
	}

	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + System.currentTimeMillis() + ".png"));
	}
}
