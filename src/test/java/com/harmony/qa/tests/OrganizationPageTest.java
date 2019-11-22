package com.harmony.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LoginPage;
import com.harmony.qa.pages.OrganizationPage;

public class OrganizationPageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();
	OrganizationPage orgPage=new OrganizationPage();

	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successfully into application");	
		homePage.clickOnOrganizationLink();
	}

	@AfterMethod
	public void teardown()
	{
		TestBase.quiteBrowser();
	}

	@Test
	public void clickOnOrgEditButtonTest()
	{
		orgPage.clickOnEditOrgButton("A&D 4 RC");
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.sharepoint.harmonyis.net/sites/admin/SitePages/ManageCustomerOrganization.aspx?OrgId=31667");
	}
	
	@Test
	public void searchOrgAndClickOnOrgEditButton()
	{
		orgPage.seachOrgAndClickOnEditOrgButton("AD 4 RC");
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.sharepoint.harmonyis.net/sites/admin/SitePages/ManageCustomerOrganization.aspx?OrgId=31668");
	}

	
	
}
