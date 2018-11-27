package Exercise2;

public class steps_main {

	public static void main(String[] args) {
		steps support = new steps("https://the-internet.herokuapp.com/broken_images");
		support.launchBrowser("chrome");
		support.verifyBrokenImage();
		support.quitBrowser();
	}

}
