package com.harmony.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.harmony.qa.base.TestBase;

public class LoginPage extends TestBase
{
	String userNameXpath = "//input[@name='CtrlLogin1$txtUserName']";
	String passwordXpath = "//input[@name='CtrlLogin1$txtPassword']";
	String loginButtonXpath = "//input[@name='CtrlLogin1$cmdLogin']";
	String logOutButtonXpath = "//input[@name='ctrlTopMenu1$cmdSignOut1']";
	
	public HomePage login(String username, String password)
	{
		try
		{
			driver.findElement(By.xpath(userNameXpath)).clear();
			driver.findElement(By.xpath(userNameXpath)).sendKeys(username);
			driver.findElement(By.xpath(passwordXpath)).clear();
			driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
			driver.findElement(By.xpath(loginButtonXpath)).click();
			WebDriverWait waits = new WebDriverWait(driver, 60);
			waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(logOutButtonXpath))));
		} catch (Exception e)
		{
			try
			{
				log.info("Login Fails on 1st attempt, Trying to login again"+ e.getMessage().toString());
				driver.findElement(By.xpath(userNameXpath)).clear();
				driver.findElement(By.xpath(userNameXpath)).sendKeys(username);
				driver.findElement(By.xpath(passwordXpath)).clear();
				driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
				driver.findElement(By.xpath(loginButtonXpath)).click();
			} catch (Exception exp)
			{
				log.info("Login into application Fails in login page "+ e.getMessage().toString());
			}
		}
		log.info("Logged into wellsky application");
		return new HomePage();
	}

	public boolean isAlreadyLogin()
	{
		boolean flag = false;
		if (driver.findElement(By.xpath(logOutButtonXpath)).isDisplayed())
		{
			log.info("User is already logged In");
			flag = true;
		} else
		{
			flag = false;
		}
		return flag;
	}

}
