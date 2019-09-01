package com.harmony.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.harmony.qa.base.TestBase;

public class AfterTestActions extends TestBase
{
	public static void captureScreenShot(ITestResult result)
	{
		if (ITestResult.FAILURE == result.getStatus())
		{
			try
			{
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + result.getName()+ ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e)
			{
				System.out.println("Exception while taking screenshot "+ e.getMessage());
			}
		}
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + System.currentTimeMillis() + ".png"));
	}
}