package com.harmony.qa.utility;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.harmony.qa.base.TestBase;


public class ElementVerify extends TestBase
{

	public static boolean isElementPresent(WebElement ele)
	{
		return ele.isDisplayed();
	}
	
	public static void verifyURL(String actualURL, String expectedURL)
	{
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	public static String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public static String getCurrentPageTitle()
	{
		return driver.getTitle();
	}

}