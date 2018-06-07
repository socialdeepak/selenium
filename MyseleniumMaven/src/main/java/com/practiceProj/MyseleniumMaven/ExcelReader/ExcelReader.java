package com.practiceProj.MyseleniumMaven.ExcelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
 public FileOutputStream fileOut=null;
 public FileInputStream fis;
 String path;
 XSSFWorkbook workbook;
 XSSFSheet sheet;
 XSSFRow row;
 XSSFCell cell;
 
 public ExcelReader(String path)
 {
	 this.path=path;
	 try
	 {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
 
 @SuppressWarnings({"deprecation"})
 public String[][] getDataFromSheet(String SheetName,String ExcelName)
 {
	String dataSets[][]=null;
	try
	{
	 XSSFSheet sheet=workbook.getSheet(SheetName);
	 int totalRow=sheet.getLastRowNum()+1;
	 int totalColumn=sheet.getRow(0).getLastCellNum();
	 dataSets=new String [totalRow-1][totalColumn];
	 for (int i = 1; i < totalRow; i++) {
			XSSFRow rows = sheet.getRow(i);
			
			for (int j = 0; j < totalColumn; j++) {
				
				XSSFCell cell = rows.getCell(j);
			
				
				if (cell.getCellType() == cell.CELL_TYPE_STRING)
					dataSets[i - 1][j] = cell.getStringCellValue();
				
				else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					String cellText = String.valueOf(cell.getNumericCellValue());
					dataSets[i - 1][j] = cellText;
				} else
					
					dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
			}

		}
		return dataSets;
	}
    catch(Exception e)
    {
    	System.out.println("Exception in reading Xlsx file" + e.getMessage());
		e.printStackTrace();
    }
	return dataSets;
 }
 
	
}
