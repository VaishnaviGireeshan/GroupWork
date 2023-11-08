package com.naveenautomation.Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String sheet) throws Exception {
		int rowCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		rowCount = ws.getLastRowNum();
		return rowCount;
	}
	

}
