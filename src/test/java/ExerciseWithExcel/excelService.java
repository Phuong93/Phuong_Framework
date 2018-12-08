package ExerciseWithExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelService {
	String file_name = "";
	
	public excelService(String f) {
		file_name = f;
	}
	
	public String readExcelValue(int sheetNumber, int row, int column) {
		String value = "";
		try {
			File src = new File(file_name);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(sheetNumber);
			sh1.autoSizeColumn(0 & 1 & 2);
			value = sh1.getRow(row).getCell(column).getStringCellValue();
			wb.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
}
