package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.GenericHelper;

public class ExportUserPage extends TestBase
{
	GenericHelper generic=new GenericHelper();

	private By exportUserHeader=By.xpath("//td[@title='Import User - Import User']");

	
	public boolean isExportUserHeaderDisplayed()
	{
		return generic.IsElementPresentQuick(exportUserHeader);
	}


}
