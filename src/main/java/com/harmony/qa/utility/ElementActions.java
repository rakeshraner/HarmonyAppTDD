package com.harmony.qa.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.harmony.qa.base.TestBase;


public class ElementActions extends TestBase
{

	public static void enterText(WebElement ele, String text)
	{
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public static void clickWithJS(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].click();", ele);
	}
	
	public static void selectValueFromDD(WebElement ele, String value)
	{
		Select select=new Select(ele);
		select.selectByValue(value);		
	}
	
	public static void selectIndexFromDD(WebElement ele, String index)
	{
		Select select=new Select(ele);
		select.selectByValue(index);		
	}
	
	public static void selectTextFromDD(WebElement ele, String text)
	{
		Select select=new Select(ele);
		select.selectByValue(text);
	}
	
	public String getTextFromAlert()
	{
		String alertText =driver.switchTo().alert().getText();
		return alertText;
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
		
}