package com.harmony.qa.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import com.harmony.qa.base.TestBase;

public class AlertHelper extends TestBase
{

	public Alert getAlert()
	{
		return driver.switchTo().alert();
	}

	public void AcceptAlert()
	{
		getAlert().accept();
	}

	public void DismissAlert()
	{
		getAlert().dismiss();
	}

	public String getAlertText()
	{
		String text = getAlert().getText();
		log.info("Alert text is : " + text);
		return text;
	}

	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			log.info("true");
			return true;
		} catch (NoAlertPresentException e)
		{
			log.info("false");
			return false;
		}
	}

	public void AcceptAlertIfPresent()
	{
		if (!isAlertPresent())
			return;
		AcceptAlert();
		log.info("");
	}

	public void DismissAlertIfPresent()
	{
		if (!isAlertPresent())
			return;
		DismissAlert();
		log.info("");
	}

	public void AcceptPrompt(String text)
	{
		if (!isAlertPresent())
			return;
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		log.info(text);
	}
}