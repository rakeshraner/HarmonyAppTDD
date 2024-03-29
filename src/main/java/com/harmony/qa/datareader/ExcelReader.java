package com.harmony.qa.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.harmony.qa.base.TestBase;

public class ExcelReader extends TestBase
{
	protected static FileInputStream fis;
	protected static XSSFWorkbook wb;
	protected static DataFormatter formatter = new DataFormatter();

	public static Object[][] getData(String sheetName, String path)
	{
		try
		{
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e)
		{
			log.info("File not Found " + e.getMessage().toString());
		} catch (IOException e)
		{
			log.info("Input Output exception "+ e.getMessage().toString());
		}
		XSSFSheet sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int row = 0; row < sheet.getLastRowNum(); row++)
		{
			for (int col = 0; col < sheet.getRow(row).getLastCellNum(); col++)
			{
				data[row][col] = formatter.formatCellValue(sheet.getRow(row + 1).getCell(col));
			}
		}
		return data;
	}

}
