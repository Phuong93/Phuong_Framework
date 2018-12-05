package Exercise;

import org.openqa.selenium.WebDriver;

public class steps_main {

	public static void main(String[] args) {
		
		launchBrowserFunction supportBrokenImage = new launchBrowserFunction("https://the-internet.herokuapp.com/broken_images");
		WebDriver driverBrokenImage = supportBrokenImage.launchBrowser("chrome");
		verifyBrokenImageFunction image = new verifyBrokenImageFunction(driverBrokenImage);
		image.verifyBrokenImage();
		supportBrokenImage.quitBrowser();
		launchBrowserFunction supportRegister = new launchBrowserFunction("http://newtours.demoaut.com/mercuryregister.php");
		WebDriver driverRegister = supportRegister.launchBrowser("chrome");
		registerFunction register = new registerFunction(driverRegister);
		register.register();
		supportRegister.quitBrowser();
	}

}
