package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.GenericHelper;

public class UserReportPage extends TestBase
{
	GenericHelper generic=new GenericHelper();

	private By userReportHeader=By.xpath("//td[@title='User Detail Report - AD 4 RC - My Visual WebPart']");

	
	public boolean isUserReportHeaderDisplayed()
	{
		return generic.IsElementPresentQuick(userReportHeader);
	}

}
