package com.harmony.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.AddUserPage;
import com.harmony.qa.pages.ExportUserPage;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LicenseSummaryPage;
import com.harmony.qa.pages.LoginPage;
import com.harmony.qa.pages.OrganizationPage;
import com.harmony.qa.pages.UserListPage;
import com.harmony.qa.pages.UserReportPage;

public class UserListPageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();
	OrganizationPage orgPage=new OrganizationPage();
	UserListPage userPage=new UserListPage();
	AddUserPage addUserPage=new AddUserPage();
	ExportUserPage exportUserPage=new ExportUserPage();
	UserReportPage userReportPage=new UserReportPage();
	LicenseSummaryPage licenseReportPage=new LicenseSummaryPage();

	
	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successfully into application");	
		homePage.clickOnUserLink();
	}
	
	@Test
	public void clickOnAddUserWhenOrgIsNotSelected()
	{
		userPage.clickOnAddNewUserButton("Select");
		Assert.assertTrue(userPage.isOrgNotPresentErrorMessageDisplayed());
	}
	
	@Test
	public void clickOnAddUserWhenOrgIsSelected()
	{
		userPage.clickOnAddNewUserButton("AD 4 RC");
		Assert.assertTrue(addUserPage.isAddNewUserHeaderDisplayed());
	}
	
	@Test
	public void clickOnImportUserWhenOrgIsNotSelected()
	{
		userPage.clickOnImportUserButton("Select");
		Assert.assertTrue(userPage.isOrgNotPresentErrorMessageDisplayed());
	}
	
	@Test
	public void clickOnImportUserWhenOrgIsSelected()
	{
		userPage.clickOnImportUserButton("AD 4 RC");
		Assert.assertTrue(exportUserPage.isExportUserHeaderDisplayed());
	}
	
	@Test
	public void clickOnUserReportWhenOrgIsNotSelected()
	{
		userPage.clickOnUserReportButton("Select");
		Assert.assertTrue(userReportPage.isUserReportHeaderDisplayed());
	}
	
	@Test
	public void clickOnUserReportWhenOrgIsSelected()
	{
		userPage.clickOnUserReportButton("AD 4 RC");
		Assert.assertTrue(userReportPage.isUserReportHeaderDisplayed());
	}

	@Test
	public void clickOnLicenseReportWhenOrgIsNotSelected()
	{
		userPage.clickOnLicenseReportButton("Select");
		Assert.assertTrue(userPage.isOrgNotPresentErrorMessageDisplayed());
	}
	
	@Test
	public void clickOnLicenseReportWhenOrgIsSelected()
	{
		userPage.clickOnLicenseReportButton("AD 4 RC");
		Assert.assertTrue(licenseReportPage.isLicenseReportHeaderDisplayed());
	}
	
	@Test
	public void clickOnEditUserButton() 
	{
		userPage.clickOnEditUserButton("AD 4 RC", "QARC1");
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.sharepoint.harmonyis.net/sites/admin/SitePages/ManageUsers.aspx?orgName=agingnetwork.com/ClientTest/Harmony/AD4RC/Groups/HAAD4RCUsers&uName=QARC1");
	}

	@Test
	public void searchUserNameAndClickOnEditUserButton() throws InterruptedException 
	{
		userPage.searchUserAndClickOnEditButton("AD 4 RC", "QARC1");
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev.sharepoint.harmonyis.net/sites/admin/SitePages/ManageUsers.aspx?orgName=agingnetwork.com/ClientTest/Harmony/AD4RC/Groups/HAAD4RCUsers&uName=QARC1");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		TestBase.quiteBrowser();
	}
	

}
