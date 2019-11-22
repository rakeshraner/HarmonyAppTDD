package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.NavigationHelper;
import com.harmony.qa.utility.TextBoxHelper;

public class OrganizationPage extends TestBase
{
	NavigationHelper navigate=new NavigationHelper();
	TextBoxHelper text=new TextBoxHelper();
	ButtonHelper button=new ButtonHelper();
	private By searchOrgInput=By.xpath("//input[contains(@id,'txtSearch')]");
	private By searchButton=By.xpath("//input[contains(@id,'imgBtnSearch')]");
	
	
	public String orgnizationPageUrl()
	{
		return navigate.getCurrentUrl();
	}

	public void clickOnEditOrgButton(String orgName)
	{
		driver.findElement(By.xpath("//table[@class='MasterTable_Default']//td[text()='"+orgName+"']/parent::tr//td[@style='white-space:nowrap;']//input[contains(@id,'imgbtnEdit')]")).click();
	}
	
	public void seachOrgAndClickOnEditOrgButton(String orgName)
	{
		text.clearAndSendKeys(searchOrgInput, orgName);
		button.click(searchButton);
		driver.findElement(By.xpath("//table[@class='MasterTable_Default']//td[text()='"+orgName+"']/parent::tr//td[@style='white-space:nowrap;']//input[contains(@id,'imgbtnEdit')]")).click();
	}


}
