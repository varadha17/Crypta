package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	
	public excel(String path) throws IOException {
		this.path = path;
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		fis.close();
	}
	
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		
		if(index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}
	
	public String getCellData(int r, int c, String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		String getcell = sheet.getRow(r).getCell(c).getStringCellValue();
		return getcell;		
	}
	
	public void setcellData(int r,int colind,String value,String sheetName) throws IOException {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		sheet.getRow(r).createCell(colind).setCellValue(value);
		fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
	}
	
	public boolean addSheet(String sheetName) throws IOException {
		
		try {
			workbook.createSheet(sheetName);
			fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean removeSheet(String sheetName) throws IOException {
		int index = workbook.getSheetIndex(sheetName);
		workbook.removeSheetAt(index);
		try {
			fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	

	}

