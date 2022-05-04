package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.learnautomation.Pages.BaseClass;

public class ExceLProvider  {
	XSSFWorkbook xssf;
	XSSFSheet sheet;
	
	public ExceLProvider() {
		
		
		File src=new File(System.getProperty("user.dir")+"\\TestData\\LoginDetails.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			xssf=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to read exception:"+e.getMessage());
		}
		
		
		
		
		
	}
	
	public String getStringData(String sheetName,int row,int col ) {
		return xssf.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public String getStringData(int sheetIndex,int row,int col ) {
		return xssf.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName,int row,int col) {
		return xssf.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();

		
	}
	
	

}
