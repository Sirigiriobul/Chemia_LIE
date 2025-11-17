package com.chemia.inventory.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
		
		public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook workbook;
		public XSSFSheet sheet;
		public XSSFRow row;
		public XSSFCell cell;
		public CellStyle style;
		public String path;
		
		public ExcelUtility(String path) {
			this.path=path;	
		}
		
		public  int getRowCount(String sheetName) throws IOException {
			fi= new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			int rowCount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowCount;
		
		}
		
		public  int getCellCount(String sheetName, int rowNum) throws IOException {
			fi= new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			int cellCount=row.getLastCellNum();
			workbook.close();
			fi.close();
			return cellCount;
		}
		
	public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
			fi= new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(cellNum);
			
			DataFormatter formatter=new DataFormatter();
			String data;
			try {
				//data=cell.toString();
				data=formatter.formatCellValue(cell); // Returns the formatted value of a cell as a string regardless of the cell type
				}
			catch(Exception e)
			{
				data="";
			}
			workbook.close();
			fi.close();
			return data.trim();

	}


	public  void setCellData( String sheetName, int rowNum, int cellNum,String data) throws IOException {
		File xlfile= new File(path);
		if(!xlfile.exists())
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook();
		if (workbook.getSheetIndex(sheetName)==-1) // If sheet not exists Then it create new sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNum)==null)   //If Row not exists, The  it create Row
			sheet.createRow(rowNum);
		row=sheet.getRow(rowNum);
		
		cell=row.createCell(cellNum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}
	
	}







