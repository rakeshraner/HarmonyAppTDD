package com.harmony.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.AddNewLicensePage;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LoginPage;
import com.harmony.qa.pages.OrganizationPage;

public class AddNewLicenseTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();
	OrganizationPage orgPage=new OrganizationPage();
	AddNewLicensePage licensePage=new AddNewLicensePage();

	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successfully into application");	
		homePage.clickOnOrganizationLink();
		orgPage.seachOrgAndClickOnEditOrgButton("AD 4 RC");
	}

	@AfterMethod
	public void teardown()
	{
		TestBase.quiteBrowser();
	}


	@Test
	public void addNewLicenseTest()  
	{
		licensePage.addNewLicense("Harmony IR", "IR", "1183", "Production and Non-Production", "sql10", "samsdataaccess", "samsdataaccess", "//root/sdrive2/synergy/synergyshared", "SAMS2K_QA_RC", "Unknown Payee", "10", "11/30/2019");
		Assert.assertTrue(licensePage.isLicenseAddedSucessfully("IR"));
	}
	
	@Test
	public void editExistingLicenseTest()  
	{
		licensePage.clickOnEditLicenseButton("A&D3 HFA RC");
		Assert.assertTrue(licensePage.isLicenseAddedSucessfully("IR"));
	}
	
	/*@Test
	public void deleteExistingLicenseTest()  
	{
		licensePage.addNewLicense("Harmony IR", "IR", "1183", "Production and Non-Production", "sql10", "samsdataaccess", "samsdataaccess", "//root/sdrive2/synergy/synergyshared", "SAMS2K_QA_RC", "Unknown Payee", "10", "11/30/2019");
		Assert.assertTrue(licensePage.isLicenseAddedSucessfully("IR"));
	}*/


}
