package Exercise;

import org.openqa.selenium.WebDriver;

public class steps_main {

	public static void main(String[] args) {
		
		launchBrowserFunction supportBrokenImage = new launchBrowserFunction("https://the-internet.herokuapp.com/broken_images");
		WebDriver driver = supportBrokenImage.launchBrowser("chrome");
		verifyBrokenImageFunction image = new verifyBrokenImageFunction(driver);
		image.verifyBrokenImage();
		supportBrokenImage.quitBrowser();
		launchBrowserFunction supportRegister = new launchBrowserFunction("http://newtours.demoaut.com/mercuryregister.php");
		WebDriver driver2 = supportRegister.launchBrowser("chrome");
		registerFunction register = new registerFunction(driver2);
		register.register();
		supportRegister.quitBrowser();
	}

}
