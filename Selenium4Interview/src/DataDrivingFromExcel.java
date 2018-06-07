import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivingFromExcel 
{
 public static FileInputStream fis;	
 public static XSSFWorkbook wb;
 public static XSSFSheet sh;
 public static XSSFRow row;
 public static XSSFCell cell;
 public static int r,c,r1,c1;
 
 public static void main(String[] args) throws IOException
 {
	 String value=getCellData(0,0);
	 System.out.println(value);
	 
	 String value1=getCellData(1,1);
	 System.out.println(value1);
	 
	 String value2=setCellValue("automation",0,1);
	 System.out.println(value2);
	 
 }

 public static String getCellData(int rowNum,int colNum) throws IOException
 {
	fis=new FileInputStream("E:\\Priti-selenium-practice\\abc.xlsx") ;
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet("sheet1");
	row=sh.getRow(2);
	cell=row.getCell(1);
	
	return cell.getStringCellValue();
 }
 
 public static String setCellValue(String text,int Row,int col) throws IOException
 {
	 
	 fis=new FileInputStream("E:\\Priti-selenium-practice\\abc.xlsx") ;
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet("sheet1");
		row=sh.getRow(1);
		cell=row.getCell(2);
		cell.setCellValue(text);
		String cell1=cell.getStringCellValue();
	     return cell1;
	 
 }
}