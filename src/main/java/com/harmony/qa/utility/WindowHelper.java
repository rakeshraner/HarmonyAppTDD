package com.harmony.qa.utility;

import java.util.LinkedList;
import java.util.Set;
import com.harmony.qa.base.TestBase;

public class WindowHelper extends TestBase
{
	public void goBack()
	{
		driver.navigate().back();
		log.info("succesfully Navigated to Back");
	}

	public void goForward()
	{
		driver.navigate().forward();
		log.info("succesfully Navigated to Forward");
	}

	public void refresh()
	{
		driver.navigate().refresh();
		log.info("succesfully Refreshed to Current Page");
	}

	public Set<String> getWindowHandlens()
	{
		log.info("Get all the windows");
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index)
	{

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());
		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);
		driver.switchTo().window(windowsId.get(index));
		log.info("Window has been switched to given index : " + index);
	}

	public void switchToParentWindow()
	{
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		log.info("Window has been switched to default");
	}

	public void switchToParentWithChildClose()
	{
		switchToParentWindow();
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());
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

	/*
	 * public void switchToFrame(By locator) 
	 * { 
	 * driver.switchTo().frame(locator);
	 * log.info(locator); 
	 * }
	 */

	public void switchToFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
		log.info(nameOrId);
	}
}
