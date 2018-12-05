package ExerciseWithExcel;

import org.openqa.selenium.WebDriver;

public class Excel_Main {

	public static void main(String[] args) throws Exception {
		launchBrowserFunction supportBrokenImage = new launchBrowserFunction();
		WebDriver driverBrokenImage = supportBrokenImage.launchBrowser("chrome");
		verifyBrokenImageFunction image = new verifyBrokenImageFunction(driverBrokenImage);
		image.verifyBrokenImage();
		supportBrokenImage.quitBrowser();
		
	}

}
