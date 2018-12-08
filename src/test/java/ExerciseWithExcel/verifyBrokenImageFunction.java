package ExerciseWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyBrokenImageFunction {
	private WebDriver driver;
	public verifyBrokenImageFunction(WebDriver driverBrokenImage) {
			driver = driverBrokenImage;
	}

	public void verifyBrokenImage() {
		String filePath = System.getProperty("user.dir");
		String filename = filePath + "/src/test/dataOut/verifyImageResult.xlsx";
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		int index = 0;
		for (WebElement imageElement : imageList) {
			if (imageElement != null) {
				try {
					// Specify the path of file
					File src = new File(filename);
					FileInputStream fis = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(fis);
					XSSFSheet sh1 = wb.getSheetAt(0);
					sh1.getRow(index).createCell(0).setCellValue(imageElement.getAttribute("src"));
					int statusImage = getStatusImage(imageElement);					
					CellStyle cellStyle = wb.createCellStyle();
			        Cell cell = sh1.getRow(index).createCell(1);
			        sh1.autoSizeColumn(0);
					if (statusImage == 200) {
						cellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
						cell.setCellValue("Pass");
					} else {
						cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
						cell.setCellValue("Fail");
					}
					
					cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);					
					cell.setCellStyle(cellStyle);
					
					sh1.getRow(index).createCell(2).setCellValue(statusImage);
					
					FileOutputStream fout = new FileOutputStream(new File(filename));
					wb.write(fout);
					fout.close();
					wb.close();
					System.out.println("Write report success!");
					index ++;
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}
	}

	public int getStatusImage(WebElement imageElement) {
		int status = 0;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imageElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			status = response.getStatusLine().getStatusCode();

		} catch (Exception e) {
		}

		return (status);
	}
}
