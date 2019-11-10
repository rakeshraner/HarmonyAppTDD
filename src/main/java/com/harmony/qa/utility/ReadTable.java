package com.harmony.qa.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.harmony.qa.base.TestBase;

public class ReadTable extends TestBase{
	public static By tableXpath=By.xpath("//table[contains(@id,'rgUserList')]");
	
	public static String readDynamicWebTable(By tableLocator)
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

	public static void main(String[] args) {

		System.out.println(readDynamicWebTable(tableXpath));
		
	}

}
