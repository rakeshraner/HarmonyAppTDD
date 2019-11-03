package com.harmony.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harmony.qa.base.TestBase;

public class TextBoxHelper extends TestBase
{
	GenericHelper helper = new GenericHelper();

	public void sendKeys(By locator, String value)
	{
		log.info("Locator : " + locator + " Value : " + value);
		helper.getElement(locator).sendKeys(value);
	}

	public void clear(By locator)
	{
		log.info("Locator : " + locator);
		helper.getElement(locator).clear();
	}

	public String getText(By locator)
	{
		log.info("Locator : " + locator);
		return helper.getElement(locator).getText();
	}

	public void clearAndSendKeys(By locator, String value)
	{
		WebElement element = helper.getElement(locator);
		element.clear();
		element.sendKeys(value);
		log.info("Locator : " + locator + " Value : " + value);
	}

}
