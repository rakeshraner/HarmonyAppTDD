package com.harmony.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.harmony.qa.base.TestBase;

public class ButtonHelper extends TestBase
{
	public void click(By locator)
	{
		click(driver.findElement(locator));
		log.info(locator);
	}

	public void click(WebElement element)
	{
		element.click();
		log.info(element);
	}
}
