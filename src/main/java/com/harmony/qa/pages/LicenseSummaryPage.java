package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.GenericHelper;

public class LicenseSummaryPage extends TestBase
{
		GenericHelper generic=new GenericHelper();

		private By licenseReportHeader=By.xpath("//td[@title='License Summary Report - AD 4 RC - My Visual WebPart']");

		
		public boolean isLicenseReportHeaderDisplayed()
		{
			return generic.IsElementPresentQuick(licenseReportHeader);
		}

}
