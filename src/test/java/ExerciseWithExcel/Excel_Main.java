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
		launchBrowserFunction supportRegister = new launchBrowserFunction("http://newtours.demoaut.com/mercuryregister.php");
		WebDriver driverRegister = supportRegister.launchBrowser("chrome");
//		registerFunction register = new registerFunction(driverRegister);
//		register.register();
//		supportRegister.quitBrowser();
		excelService excelS = new excelService(System.getProperty("user.dir") + "/src/test/dataIn/Elements.xlsx");
		elementService getE = new elementService(driverRegister);
		
		registerFunction register = new registerFunction(excelS, getE);
		register.register();
		supportRegister.quitBrowser();
	}

}
