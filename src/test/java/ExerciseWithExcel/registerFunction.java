package ExerciseWithExcel;

import org.openqa.selenium.WebElement;

public class registerFunction {
	excelService excelS;
	elementService getE;

	public registerFunction(excelService e, elementService g) {
		excelS = e;
		getE = g;
	}

	public void register() {
		int index = 1;
		while(excelS.readExcelValue(0, index, 0) != "") {
			if (excelS.readExcelValue(0, index, 0).contains("input")) {
				getE.sendKey(excelS.readExcelValue(0, index, 0), excelS.readExcelValue(0, index, 1), excelS.readExcelValue(0, index, 2));
			} else if (excelS.readExcelValue(0, index, 0).contains("click")) {
				getE.clickEvent(excelS.readExcelValue(0, index, 0), excelS.readExcelValue(0, index, 1));
			} else if (excelS.readExcelValue(0, index, 0).contains("selectOption")) {				
				getE.selectBox(excelS.readExcelValue(0, index, 0), excelS.readExcelValue(0, index, 1), excelS.readExcelValue(0, index, 2));
			}
			index ++;
		}
		
		WebElement title = getE.getElements(excelS.readExcelValue(0, 15, 0), excelS.readExcelValue(0, 15, 1));
		if (title.getText().contains(excelS.readExcelValue(0, 15, 2))) {
			System.out.println("Register success");
		}else {
			System.out.println("Register Failed");
		}
	}
}
