package com.harmony.qa.utility;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harmony.qa.base.TestBase;

public class ReadTable extends TestBase{
	public static By tableXpath=By.xpath("//div/table[contains(@id,'dlViewDetails')]");
	
	public static String readDynamicWebTable()
	{
		WebElement Table = driver.findElement(By.xpath("//div/table[contains(@id,'dlViewDetails')]"));
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
	
	public String readTable()
	{
		List<WebElement>rows=driver.findElements(By.xpath("//div/table[contains(@id,'dlViewDetails')]//tr//td//span"));
		Iterator<WebElement> i = rows.iterator();
		while(i.hasNext())
		{
			WebElement row=i.next();
			System.out.println(row.getText());
			return row.getText();
		}
		return null;
	}
	
	public String readDynamicTable()
	{
		WebElement Table = driver.findElement(By.xpath("//div/table[contains(@id,'dlViewDetails')]"));
		List<WebElement> tableRows = Table.findElements(By.tagName("tr"));
		int numberOfRows = tableRows.size();
		System.out.println("Number of Rows in table is " +numberOfRows);
		String columnValue = null;
		for (int i=0;i<numberOfRows;i++) 
		{
			List<WebElement> tableColumns = tableRows.get(i).findElements(By.tagName("td").tagName("span"));
			int numberOfColumns = tableColumns.size();
			System.out.println("Number of columns in table is " +numberOfColumns);
			log.info("Row " + (i+1));		
			for (int j = 0; j<numberOfColumns; j++) 
			{
				columnValue = tableColumns.get(j).getText();
			}			
		}
		return columnValue;			
	}



}
