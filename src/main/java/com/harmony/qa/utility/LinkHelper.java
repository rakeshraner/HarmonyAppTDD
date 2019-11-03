package com.harmony.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.harmony.qa.base.TestBase;

public class LinkHelper extends TestBase
{
	GenericHelper helper = new GenericHelper();

	public void clickLink(String linkText)
	{
		log.info(linkText);
		helper.getElement(By.linkText(linkText)).click();
	}

	public void clickPartialLink(String partialLinkText)
	{
		log.info(partialLinkText);
		helper.getElement(By.partialLinkText(partialLinkText)).click();
	}

	public String getHyperLink(By locator)
	{
		log.info(locator);
		return getHyperLink(helper.getElement(locator));
	}

	public String getHyperLink(WebElement element)
	{
		String link = element.getAttribute("hreg");
		log.info("Element : " + element + " Value : " + link);
		return link;
	}
}
