package com.harmony.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.harmony.qa.base.TestBase;

public class GenericHelper extends TestBase
{
	public static String getCurrentDateTime()
	{

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate()
	{
		return getCurrentDateTime().substring(0, 11);
	}

	public WebElement getElement(By locator)
	{
		log.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);
		try
		{
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re)
		{
			log.error(re);
			throw re;
		}
	}

	public WebElement getElementWithNull(By locator)
	{
		log.info(locator);
		try
		{
			return driver.findElement(locator);
		} catch (NoSuchElementException e)
		{
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator)
	{
		boolean flag = driver.findElements(locator).size() >= 1;
		log.info(flag);
		return flag;
	}
	
	protected String getHeaderXpath(String tableIdoRxPath)
	{
		log.debug(tableIdoRxPath);
		return IsElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='"+ tableIdoRxPath + "']//thead": tableIdoRxPath + "//thead";
	}

	protected String getTableBodyXpath(String tableIdoRxPath)
	{
		log.debug(tableIdoRxPath);
		return IsElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='"+ tableIdoRxPath + "']//tbody": tableIdoRxPath + "//tbody";
	}

	protected WebElement getGridElement(String tableIdoRxPath, int row, int column)
	{
		WebElement element;
		if ((element = getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]//input"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/a"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/button"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
		{
			log.debug(element);
			return element;
		}
		return null;
	}

	protected int searchInGrid(String description, String tableIdoRxPath, int row, final int column)
	{
		WebElement element;
		while ((element = getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
		{
			if (!element.getText().isEmpty())
			{
				log.info(element.getText());
				if (element.getText().trim().contains(description))
					return row;
			}
			row++;
		}

		throw new IllegalArgumentException("No matching description found : "+ description);
	}

	
	public List<String> getGridHeading(String tableIdoRxPath)
	{
		List<String> header = new LinkedList<String>();
		int j = 1;
		WebElement element;
		while ((element = (getElementWithNull(By.xpath(getHeaderXpath(tableIdoRxPath) + "//tr[1]//th[" + j+ "]")))) != null)
		{
			if (!element.getText().isEmpty())
			{
				header.add(element.getText().trim());
				log.info(element.getText().trim());
			}
			j++;
		}
		return header;
	}

	public String getGridColumnText(String tableIdoRxPath, int row, int column)
	{
		log.info(tableIdoRxPath + "," + row + "," + column);
		WebElement element = getGridElement(tableIdoRxPath, row, column);
		return element == null ? "" : element.getText().trim();
	}

	public void typeInGrid(String tableIdoRxPath, int row, int column,
			String value)
	{
		log.info(tableIdoRxPath + "," + row + "," + column + "," + value);
		WebElement element = getGridElement(tableIdoRxPath, row, column);
		element.clear();
		element.sendKeys(value);
	}

	public void typeInGrid(String description, String tableIdoRxPath, int row, int column, String value)
	{
		log.info(tableIdoRxPath + "," + row + "," + column + "," + value + ","+ description);
		int index = searchInGrid(description, tableIdoRxPath, row, column);
		typeInGrid(tableIdoRxPath, index, 3, value);
	}


	public static void captureScreenShot(ITestResult result)
	{
		if (prop.getProperty("browser").equalsIgnoreCase("HtmlUnitBrowser"))
		{
			log.fatal("HtmlUnitDriver Cannot take the ScreenShot");
			return;
		}
		if (ITestResult.FAILURE == result.getStatus())
		{
			try
			{
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + result.getName() + ".png"));
				log.info("Successfully captured a screenshot");
			} catch (Exception e)
			{
				log.info("Exception while taking screenshot " + e.getMessage());
			}
		}
	}

	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//ScreenShot" + System.currentTimeMillis() + ".png"));
	}
	
	public static void readValueFromTable(By tableLocator, By trLocator, By tdLocator)
	{
		 WebElement table_element = driver.findElement(tdLocator);
	        List<WebElement> tr_collection=table_element.findElements(trLocator);

	        log.info("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	        int row_num,col_num;
	        row_num=1;
	        for(WebElement trElement : tr_collection)
	        {
	            List<WebElement> td_collection=trElement.findElements(tdLocator);
	            log.info("NUMBER OF COLUMNS="+td_collection.size());
	            col_num=1;
	            for(WebElement tdElement : td_collection)
	            {
	            	log.info("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	                col_num++;
	            }
	            row_num++;
	        } 
	  }
	
	public static String readDynamicWebTable(By tableLocator, By trLocator, By tdLocator)
	{
		WebElement Table = driver.findElement(tableLocator);
		List<WebElement> TableRows = Table.findElements(By.tagName("tr"));
		int NumberOfRows = TableRows.size();
		String columnValue = null;
		for (int i=0;i<NumberOfRows;i++) 
		{
			List<WebElement> TableColumns = TableRows.get(i).findElements(By.tagName("td"));
			int NumberOfColumns = TableColumns.size();
			log.info("Row " + (i+1));		
			for (int j = 0; j<NumberOfColumns; j++) 
			{
				columnValue = TableColumns.get(j).getText();
			}			
		}
		return columnValue;			
	}
	
}
