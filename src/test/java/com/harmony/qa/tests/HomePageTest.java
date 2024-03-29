package com.harmony.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LoginPage;
import com.harmony.qa.pages.NewsPage;
import com.harmony.qa.pages.OrganizationPage;
import com.harmony.qa.pages.PanelPage;
import com.harmony.qa.pages.TrainingPage;
import com.harmony.qa.pages.UserListPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();
	OrganizationPage orgPage=new OrganizationPage();
	UserListPage userPage=new UserListPage();
	NewsPage newsPage=new NewsPage();
	PanelPage panelPage=new PanelPage();
	TrainingPage trainingPage=new TrainingPage();

	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		log.info("Application gets launched");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successfully into application");
	}
	
	@Test
	public void verifyWellskyLogo()
	{
		Assert.assertTrue(homePage.verifyLogo());
	}
	
	@Test
	public void verifyOrganizationPage()
	{
		homePage.navigationThroughChapters("Manage_Organizations");
		Assert.assertEquals(orgPage.orgnizationPageUrl(), prop.get("orgPageURL"));
	}
	
	@Test
	public void verifyUserPage()
	{
		homePage.navigationThroughChapters("Manage_Users");
		Assert.assertEquals(userPage.userPageUrl(), prop.get("userPageURL"));
	}
	
	@Test
	public void verifyNewsPage()
	{
		homePage.navigationThroughChapters("WellSky_News_Management");
		Assert.assertEquals(newsPage.newsPageUrl(), prop.get("newsPageURL"));
	}
	
	@Test
	public void verifyPanelPage()
	{
		homePage.navigationThroughChapters("Manage_Panels");
		Assert.assertEquals(panelPage.panelPageUrl(), prop.get("panelPageURL"));
	}
	
	@Test
	public void verifyTrainingPage()
	{
		homePage.navigationThroughChapters("WellSky_Training_Site");
		Assert.assertEquals(trainingPage.trainingPageUrl(), prop.get("trainingPageURL"));
	}


	@AfterMethod
	public void teardown()
	{
		if(driver!=null)
		driver.quit();
	}
	
	
}
