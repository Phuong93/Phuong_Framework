package ExerciseWithExcel;

import java.util.List;

import org.openqa.selenium.WebElement;

public class checkoutFunction {
	excelService excelCheckout;
	elementService elementsCheckout;
	public checkoutFunction(excelService exS, elementService elS) {
		excelCheckout = exS;
		elementsCheckout = elS;
	}

	public void checkout() throws InterruptedException {
		List<WebElement> listProducts = elementsCheckout.getElementsByList(excelCheckout.readExcelValue(1, 2, 0), excelCheckout.readExcelValue(1, 2, 1));
		elementsCheckout.moveToEvent(excelCheckout.readExcelValue(1, 1, 0), excelCheckout.readExcelValue(1, 1, 1));
		for(WebElement e: listProducts) {			
			elementsCheckout.hoverToEvent(e);		
			elementsCheckout.clickEventByElement(e, excelCheckout.readExcelValue(1, 3, 0), excelCheckout.readExcelValue(1, 3, 1));
			Thread.sleep(7000);
			elementsCheckout.switchIframeEvent(excelCheckout.readExcelValue(1, 4, 0), excelCheckout.readExcelValue(1, 4, 1));
			
			elementsCheckout.clickEvent(excelCheckout.readExcelValue(1, 5, 0), excelCheckout.readExcelValue(1, 5, 1));
			elementsCheckout.waitEvent(excelCheckout.readExcelValue(1, 6, 0), excelCheckout.readExcelValue(1, 6, 1));
			elementsCheckout.clickEvent(excelCheckout.readExcelValue(1, 7, 0), excelCheckout.readExcelValue(1, 7, 1));
		}
	}

}
