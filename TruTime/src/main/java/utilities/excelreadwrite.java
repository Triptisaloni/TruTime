package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreadwrite {
	public static File src;
	public static String exfilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String val1;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String search_input;
	
	//Read Data From Excel Sheet
	public static int readexcel() {
		try {
			src = new File(exfilepath);
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);

			search_input = (sheet.getRow(1).getCell(0)).getStringCellValue();
			
			System.out.p
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
	}

}
