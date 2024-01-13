package com.yantraQA.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

	public static void main(String[] args) throws IOException {
		String filePath = "E:\\_AkashStuff\\Automation\\EclipseWorkspace\\AutomationPoCCucumber\\src\\test\\resources\\eCommerceData\\SearchProducts.xlsx";
		String filePathOut = "E:\\_AkashStuff\\Automation\\EclipseWorkspace\\AutomationPoCCucumber\\src\\test\\resources\\eCommerceData\\SearchProducts1.xlsx";
		Object[][] data = FetchExcelFileContent(filePath,"Sheet1");
		CreateNewExcelFile(filePathOut,"Sheet1",data);
		System.out.print("");
	}
	public static Object[][] FetchExcelFileContent(String filePath, String SheetName) throws IOException {
		
		File f = new File(filePath);
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		Sheet sheet = wb.getSheet(SheetName);
		Row r1 = sheet.getRow(0); // assuming excel sheet has uniform data i.e. all row has same num of clm
		int clmNum = r1.getLastCellNum();
		int lastRowNumber = sheet.getLastRowNum();
		Object[][] fullData = new Object[lastRowNumber][clmNum];
		
		for (int i=0;i<lastRowNumber;i++) {

			Row r = sheet.getRow(i);
			int RowclmNum = r.getLastCellNum();
			
			for (int j=0;j<RowclmNum;j++) {
				fullData[i][j] = r.getCell(j).getStringCellValue();
			}
		
		}//end for
		
		wb.close();
		wb = null;
		sheet = null;
		r1= null;

		return fullData;
		
	}//end method
	
	public static void CreateNewExcelFile(String filePath, String SheetName, Object[][] data) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(SheetName);
		
		for(int i=0;i<data.length;i++) {
			
			Row r = sheet.createRow(i);
			for (int j=0;j<data[i].length;j++) {
				r.createCell(j).setCellValue((String)data[i][j]);
			}
		}
		
		File f = new File(filePath);
		FileOutputStream out = new FileOutputStream(f);
		wb.write(out);
		out.close();
		
	}
}//end class