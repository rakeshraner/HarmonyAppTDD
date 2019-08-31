package com.harmony.qa.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.harmony.qa.base.TestBase;
import com.harmony.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();

	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
	}

	@Test
	public void validLogin()
	{
		loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		assertTrue(loginPage.isAlreadyLogin());
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}