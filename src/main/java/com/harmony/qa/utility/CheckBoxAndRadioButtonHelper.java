package com.harmony.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harmony.qa.base.TestBase;

public class CheckBoxAndRadioButtonHelper extends TestBase
{

	public void selectCheckBox(By locator)
	{
		log.info(locator);
		selectCheckBox(driver.findElement(locator));
	}

	public void unSelectCheckBox(By locator)
	{
		log.info(locator);
		unSelectCheckBox(driver.findElement(locator));
	}

	public boolean isIselected(By locator)
	{
		log.info(locator);
		return isIselected(driver.findElement(locator));
	}

	public boolean isIselected(WebElement element)
	{
		boolean flag = element.isSelected();
		log.info(flag);
		return flag;
	}

	public void selectCheckBox(WebElement element)
	{
		if (!isIselected(element))
			element.click();
		log.info(element);
	}

	public void unSelectCheckBox(WebElement element)
	{
		if (isIselected(element))
			element.click();
		log.info(element);
	}
}
