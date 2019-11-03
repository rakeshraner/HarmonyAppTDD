package com.harmony.qa.pages;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.NavigationHelper;

public class NewsPage extends TestBase
{

	NavigationHelper navigate=new NavigationHelper();

	public String newsPageUrl()
	{
		return navigate.getCurrentUrl();
	}
}
