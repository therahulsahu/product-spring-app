package ExcelDataUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExcel {
	
	public static int r,c;
	 WebDriver driver;
	 public String[][] testdata;
	
	 
	 public String[][] get_data(String sheetName,int s,int k)
	 {
		 testdata = new String[s][k];
		 try
		 {
			 File f = new File ("src/test/resources/testdata/TestData.xlsx");
			 FileInputStream fis = new FileInputStream(f);
			 XSSFWorkbook wb  = new XSSFWorkbook(fis);
			 XSSFSheet sh  = wb.getSheet(sheetName);
			 
			 for(r=1;r<s+1;r++) 
			 {
				 XSSFRow row = sh.getRow(r);
			 
			 for(c=0;c<k;c++)
			 {
				 //c = row.getRowNum();
				 XSSFCell cell = row.getCell(c);
				 testdata[r-1][c] = cell.getStringCellValue();
				 System.out.println(testdata[r-1][c]);
			 }
			 }
		 }
			 catch (FileNotFoundException e)
			 {
			 
			 }
			   catch (IOException e) 
			   {
				 e.printStackTrace();
			    }
			 
		 
		return testdata;
		 
	 }
	 
		 
	 }		 
	 


