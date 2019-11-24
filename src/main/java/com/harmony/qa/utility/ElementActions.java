package com.harmony.qa.utility;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.harmony.qa.base.TestBase;

public class ElementActions extends TestBase
{
	//Method will switch to Alert
	public static Alert getAlert()
	{
		return driver.switchTo().alert();
	}

	//This method will simply Accept alert
	public static void AcceptAlert()
	{
		getAlert().accept();
	}

	//This Method will Simply Dismiss Alert
	public static void DismissAlert()
	{
		getAlert().dismiss();
	}

	//This method will get Text from Alert
	public static String getAlertText()
	{
		String text = getAlert().getText();
		log.info("Alert text is : " + text);
		return text;
	}

	//This will return if alert is present or not
	public static boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			log.info("true");
			return true;
		} catch (NoAlertPresentException e)
		{
			log.info("false");
			return false;
		}
	}

	//This method will accept alert if it is present
	public static void AcceptAlertIfPresent()
	{
		if (!isAlertPresent())
			return;
		AcceptAlert();
		log.info("");
	}

	//This method will dismiss alert if it is present
	public static void DismissAlertIfPresent()
	{
		if (!isAlertPresent())
			return;
		DismissAlert();
		log.info("");
	}

	//This method will pass text message and then accept alert if it is present
	public static void AcceptPrompt(String text)
	{
		if (!isAlertPresent())
			return;
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		log.info(text);
	}


	//This Method will accept one By locator Argument and click on given Locator
	public static void click(By locator)
	{
		click(driver.findElement(locator));
		log.info(locator);
	}

	//This Method will accept one WebElement Argument and click on given Locator
	public static void click(WebElement element)
	{
		element.click();
		log.info(element);
	}

	//This Method will accept one LinkText Argument and click on given Link Text
	public static void clickLink(String linkText)
	{
		log.info(linkText);
		getElement(By.linkText(linkText)).click();
	}

	//This Method will accept one Partial LinkText Argument and click on given Link Text
	public static void clickPartialLink(String partialLinkText)
	{
		log.info(partialLinkText);
		getElement(By.partialLinkText(partialLinkText)).click();
	}

	//This Method will accept one By Locator Argument and click on given Locator
	public static String getHyperLink(By locator)
	{
		log.info(locator);
		return getHyperLink(getElement(locator));
	}

	//This Method will accept one WebElement Argument and click on given Argument
	public static String getHyperLink(WebElement element)
	{
		String link = element.getAttribute("hreg");
		log.info("Element : " + element + " Value : " + link);
		return link;
	}

	
	//This Method will accept one By locator and then click on given ele to select checkbox.
	public static void selectCheckBox(By locator)
	{
		log.info(locator);
		selectCheckBox(driver.findElement(locator));
	}

	//This Method will accept one By locator and then click on given ele to Unselect checkbox.
	public static void unSelectCheckBox(By locator)
	{
		log.info(locator);
		unSelectCheckBox(driver.findElement(locator));
	}

	//This Method will accept one By locator and then return true if ele is selected.
	public static boolean isIselected(By locator)
	{
		log.info(locator);
		return isIselected(driver.findElement(locator));
	}

	//This Method will accept one WebELement and then return true if ele is selected.
	public static boolean isIselected(WebElement element)
	{
		boolean flag = element.isSelected();
		log.info(flag);
		return flag;
	}

	//This Method will accept one WebElement and then click on given ele to select checkbox.
	public static void selectCheckBox(WebElement element)
	{
		if (!isIselected(element))
			element.click();
		log.info(element);
	}

	//This Method will accept one By locator and then click on given ele to Unselect checkbox.
	public static void unSelectCheckBox(WebElement element)
	{
		if (isIselected(element))
			element.click();
		log.info(element);
	}


	//This Method will used to go back to last window
	public static void goBack()
	{
		driver.navigate().back();
		log.info("succesfully Navigated to Back");
	}

	//This Method will used to go forward to new window
	public static void goForward()
	{
		driver.navigate().forward();
		log.info("succesfully Navigated to Forward");
	}

	//This Method will used to refresh current window
	public static void refresh()
	{
		driver.navigate().refresh();
		log.info("succesfully Refreshed to Current Page");
	}

	//This Method will get all window ID and return
	public static Set<String> getWindowHandlens()
	{
		log.info("Get all the windows");
		return driver.getWindowHandles();
	}

	//This Method will accept one index argument as window ID and switch to window.
	public static void SwitchToWindow(int index)
	{
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);
		driver.switchTo().window(windowsId.get(index));
		log.info("Window has been switched to given index : " + index);
	}

	//This Method will switch to parent window.
	public static void switchToParentWindow()
	{
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		log.info("Window has been switched to default");
	}

	//This Method will switch to parent window and also close all the child windows.
	public static void switchToParentWithChildClose()
	{
		switchToParentWindow();
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		for (int i = 1; i < windowsId.size(); i++)
		{
			log.info(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
			log.info("Child Window has been closed");
		}
		switchToParentWindow();
		log.info("Child Window has been closed and Window has been switched to default");
	}
	
	//This Method will switch to Frame accept locators.
	 public static void switchToFrame(By locator) 
	  { 
		 driver.switchTo().frame(driver.findElement(locator));
		 log.info(locator); 
	  }
	 
	//This Method will switch to Frame accept Name or ID.
	public static void switchToFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
		log.info(nameOrId);
	}

	//This Method will accept String Type URL and Navigate to given URL.
	public void navigateTo(String url)
	{
		log.info(url);
		driver.get(url);
	}
	//This Method will accept URL type Url and Navigate to given URL.
	public void naviagteTo(URL url)
	{
		log.info(url.getPath());
		driver.get(url.getPath());
	}

	//This method will get Title of page
	public String getTitle()
	{
		String title = driver.getTitle();
		log.info(title);
		return driver.getTitle();
	}

	//This method will get Current URL of page
	public String getCurrentUrl()
	{
		String url = driver.getCurrentUrl();
		log.info(url);
		return driver.getCurrentUrl();
	}

	

	//This Method will get element if element is present.
	public static WebElement getElement(By locator)
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

	public static WebElement getElementWithNull(By locator)
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

	//This Method checks if element is present or not
	public static boolean IsElementPresentQuick(By locator)
	{
		boolean flag = driver.findElements(locator).size() >= 1;
		log.info(flag);
		return flag;
	}

	
	//This method accepts locator and String visible value and select ele on Dropdown using visibleValue.
	public static void SelectUsingVisibleValue(By locator, String visibleValue)
	{
		SelectUsingVisibleValue(getElement(locator), visibleValue);
	}

	//This method accepts WebElement and String visible value and select ele on Dropdown using visibleValue.
	public static void SelectUsingVisibleValue(WebElement element, String visibleValue)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		log.info("Locator : " + element + " Value : " + visibleValue);
	}

	//This method accepts locator and String visible value and select ele on Dropdown using visibleValue.
	public static void SelectUsingValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		log.info("Locator : " + locator + " Value : " + value);
	}

	//This method accepts locator and int index and select ele on Dropdown using visibleValue.
	public static void SelectUsingIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		log.info("Locator : " + locator + " Index : " + index);
	}

	//This will accept one By locator and pass it on getSelectedValue method and return value
	public static String getSelectedValue(By locator)
	{
		log.info(locator);
		return getSelectedValue(getElement(locator));
	}

	//This will accept one WebElement and pass it will getfirst option selected text and return value
	public static String getSelectedValue(WebElement element)
	{
		String value = new Select(element).getFirstSelectedOption().getText();
		log.info("WebELement : " + element + " Value : " + value);
		return value;
	}

	//This will get all the valus of dropdown and return in List.
	public static List<String> getAllDropDownValues(By locator)
	{
		Select select = new Select(getElement(locator));
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
