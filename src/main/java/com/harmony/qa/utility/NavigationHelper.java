package com.harmony.qa.utility;

import java.net.URL;

import com.harmony.qa.base.TestBase;

public class NavigationHelper extends TestBase
{

	public void navigateTo(String url)
	{
		log.info(url);
		driver.get(url);
	}

	public void naviagteTo(URL url)
	{
		log.info(url.getPath());
		driver.get(url.getPath());
	}

	public String getTitle()
	{
		String title = driver.getTitle();
		log.info(title);
		return driver.getTitle();
	}

	public String getCurrentUrl()
	{
		String url = driver.getCurrentUrl();
		log.info(url);
		return driver.getCurrentUrl();
	}

}
