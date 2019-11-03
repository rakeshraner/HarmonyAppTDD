package com.harmony.qa.utility;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harmony.qa.base.TestBase;

public class GridHelper extends TestBase
{
	GenericHelper helper = new GenericHelper();

	protected String getHeaderXpath(String tableIdoRxPath)
	{
		log.debug(tableIdoRxPath);
		return helper.IsElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='"+ tableIdoRxPath + "']//thead": tableIdoRxPath + "//thead";
	}

	protected String getTableBodyXpath(String tableIdoRxPath)
	{
		log.debug(tableIdoRxPath);
		return helper.IsElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='"+ tableIdoRxPath + "']//tbody": tableIdoRxPath + "//tbody";
	}

	protected WebElement getGridElement(String tableIdoRxPath, int row, int column)
	{
		WebElement element;
		if ((element = helper.getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]//input"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = helper.getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/a"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = helper.getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/button"))) != null)
		{
			log.debug(element);
			return element;
		} else if ((element = helper.getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
		{
			log.debug(element);
			return element;
		}
		return null;
	}

	protected int searchInGrid(String description, String tableIdoRxPath, int row, final int column)
	{
		WebElement element;
		while ((element = helper.getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
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
		while ((element = (helper.getElementWithNull(By.xpath(getHeaderXpath(tableIdoRxPath) + "//tr[1]//th[" + j+ "]")))) != null)
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

}
