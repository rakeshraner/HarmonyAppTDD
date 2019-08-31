package com.harmony.qa.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.harmony.qa.base.TestBase;

public class ReadData extends TestBase
{
	protected static FileInputStream fis;
	protected static XSSFWorkbook wb;
	protected static DataFormatter formatter = new DataFormatter();

	public static Object[][] getData(String sheetName)
	{
		try
		{
			fis = new FileInputStream(
					"//Users//rakeshrane//HarmonyQA//HarmonyQA//src//main//java//dataSource//Credentials.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e)
		{
			System.out.println("File not Found " + e.getMessage().toString());
		} catch (IOException e)
		{
			System.out.println("Input Output exception "
					+ e.getMessage().toString());
		}
		XSSFSheet sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0)
				.getLastCellNum()];
		for (int row = 0; row < sheet.getLastRowNum(); row++)
		{
			for (int col = 0; col < sheet.getRow(row).getLastCellNum(); col++)
			{
				data[row][col] = formatter.formatCellValue(sheet
						.getRow(row + 1).getCell(col));
			}
		}
		return data;
	}

}
