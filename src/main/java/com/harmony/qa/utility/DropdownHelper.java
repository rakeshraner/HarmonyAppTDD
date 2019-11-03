package com.harmony.qa.utility;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.harmony.qa.base.TestBase;

public class DropdownHelper extends TestBase
{
	GenericHelper helper=new GenericHelper();

	public void SelectUsingVisibleValue(By locator, String visibleValue)
	{
		SelectUsingVisibleValue(helper.getElement(locator), visibleValue);
	}

	public void SelectUsingVisibleValue(WebElement element, String visibleValue)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		log.info("Locator : " + element + " Value : " + visibleValue);
	}

	public void SelectUsingValue(By locator, String value)
	{
		Select select = new Select(helper.getElement(locator));
		select.selectByValue(value);
		log.info("Locator : " + locator + " Value : " + value);
	}

	public void SelectUsingIndex(By locator, int index)
	{
		Select select = new Select(helper.getElement(locator));
		select.selectByIndex(index);
		log.info("Locator : " + locator + " Index : " + index);
	}

	public String getSelectedValue(By locator)
	{
		log.info(locator);
		return getSelectedValue(helper.getElement(locator));
	}

	public String getSelectedValue(WebElement element)
	{
		String value = new Select(element).getFirstSelectedOption().getText();
		log.info("WebELement : " + element + " Value : " + value);
		return value;
	}

	public List<String> getAllDropDownValues(By locator)
	{
		Select select = new Select(helper.getElement(locator));
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();

		for (WebElement element : elementList)
		{
			log.info(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}
}
