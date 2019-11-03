package com.harmony.qa.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();

	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		log.info("Application gets launched");
	}

	@Test
	public void validLogin()
	{
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successful");
		assertTrue(loginPage.isAlreadyLogin());
	}

	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		driver.quit();
	}
}
