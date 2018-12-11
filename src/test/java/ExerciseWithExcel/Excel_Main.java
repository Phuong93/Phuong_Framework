package ExerciseWithExcel;

import org.openqa.selenium.WebDriver;

public class Excel_Main {

	public static void main(String[] args) throws Exception {
		
		/**
		 * This function is verify Broken Images
		 * AUTHOR: PHUONG TRAN
		 * SU3
		 * Create excel file to write the result
		 * UPDATED DATE: 6.12.2018
		 */
//		launchBrowserFunction supportBrokenImage = new launchBrowserFunction("https://the-internet.herokuapp.com/broken_images");
//		WebDriver driverBrokenImage = supportBrokenImage.launchBrowser("chrome");
//		verifyBrokenImageFunction image = new verifyBrokenImageFunction(driverBrokenImage);
//		image.verifyBrokenImage();
//		supportBrokenImage.quitBrowser();
		
		/**
		 * This function is register
		 * AUTHOR: PHUONG TRAN
		 * SU3
		 * register from excel file
		 * UPDATED DATE: 8.12.2018
		 */
//		launchBrowserFunction supportRegister = new launchBrowserFunction("http://newtours.demoaut.com/mercuryregister.php");
//		WebDriver driverRegister = supportRegister.launchBrowser("chrome");
//		excelService excelS = new excelService(System.getProperty("user.dir") + "/src/test/dataIn/Elements.xlsx");
//		elementService getE = new elementService(driverRegister);
//		registerFunction register = new registerFunction(excelS, getE);
//		register.register();
//		supportRegister.quitBrowser();
		
		/**
		 * This function is checkout products
		 * AUTHOR: PHUONG TRAN
		 * SU3
		 * implement checkout function
		 * UPDATED DATE: 10.12.2018
		 */
		launchBrowserFunction supportCheckout = new launchBrowserFunction("http://automationpractice.com/index.php");
		WebDriver driverCheckout = supportCheckout.launchBrowser("chrome");
		excelService excelCheckout = new excelService(System.getProperty("user.dir") + "/src/test/dataIn/Elements.xlsx");
		elementService elementsCheckout = new elementService(driverCheckout);
		checkoutFunction checkout = new checkoutFunction(excelCheckout,elementsCheckout);
		checkout.checkout();
		Thread.sleep(2000);
		supportCheckout.quitBrowser();
		
	}

}
