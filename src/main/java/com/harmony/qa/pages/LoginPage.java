package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.TextBoxHelper;
import com.harmony.qa.utility.WaitHelper;

public class LoginPage extends TestBase
{
	TextBoxHelper textbox=new TextBoxHelper();
	ButtonHelper button =new ButtonHelper();
	WaitHelper wait=new WaitHelper();
	GenericHelper generic=new GenericHelper();
	
	protected By userNameXpath =By.xpath("//input[contains(@name,'UsernameTextBox')]");
	protected By passwordXpath =By.xpath("//input[contains(@name,'PasswordTextBox')]");
	protected By loginButtonXpath =By.xpath("//input[contains(@name,'SignIn')]");
	protected By profileButtonXpath =By.xpath("//span[contains(text(),'istretch01@agingnetwork.com')]");
	
	public HomePage login(String username, String password)
	{
		try
		{
			textbox.clearAndSendKeys(userNameXpath, username);
			textbox.clearAndSendKeys(passwordXpath, password);
			button.click(loginButtonXpath);
			wait.elementExistAndVisible(profileButtonXpath, 60, 10);
		} catch (Exception e)
		{
			try
			{
				log.info("Login Fails on 1st attempt, Trying to login again"+ e.getMessage().toString());
				textbox.clearAndSendKeys(userNameXpath, username);
				textbox.clearAndSendKeys(passwordXpath, password);
				button.click(loginButtonXpath);
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
		if (generic.IsElementPresentQuick(profileButtonXpath))
		{
			log.info("User is already logged In");
			flag = true;
		} 
		return flag;
	}

}
