package com.harmony.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.datareader.ExcelReader;
import com.harmony.qa.pages.AddUserPage;
import com.harmony.qa.pages.HomePage;
import com.harmony.qa.pages.LoginPage;
import com.harmony.qa.pages.UserListPage;

public class AddUserPageTest extends TestBase
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage= new HomePage();
	UserListPage userPage=new UserListPage();
	AddUserPage addUserPage=new AddUserPage();
	
	@DataProvider
	public Object[][] passData()
	{
		Object[][] data= ExcelReader.getData("Sheet1", "/Users/rakeshrane/Documents/HarmonyQA/HarmonyQA/src/main/java/dataSource/AddNewUserData.xlsx");
		return data;
	}
	
	@BeforeMethod
	public void setup()
	{
		TestBase.launchApp();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Successfully into application");	
		homePage.clickOnUserLink();
		userPage.clickOnAddNewUserButton("AD 4 RC");
	}
	
	@AfterMethod
	public void teardown()

	{
		TestBase.quiteBrowser();
	}

	@Test(dataProvider="passData")
	public void addNewUserSuccessfully(String uName, String pass, String cPass, String fName, String lName, String mName, String fullName, String eMail, 
			String addrs, String notes, String requestPerson, String state, String town, String zip, String workPhone, String homePhone, String invoice)
	{
		addUserPage.addNewUser(uName, pass, cPass, fName, lName, mName, fullName, eMail, addrs, notes, requestPerson, state, town, zip, workPhone, homePhone, invoice);
		Assert.assertTrue(addUserPage.isUserSavedSuccessfullyMessageDisplayed());
	}

}
