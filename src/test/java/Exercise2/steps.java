package Exercise2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public class steps {
	public String URL;
	private WebDriver driver = null;
	private String rootPath = System.getProperty("user.dir");
	private final String referencesPath = "/src/test/resources/webdriver/";

	public steps(String u) {
		URL = u;
	}

	public void launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", rootPath + referencesPath + "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", rootPath + referencesPath + "geckodriver");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Sorry, this browser is invalid");
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		driver.get(URL);
	}

	public void verifyBrokenImage() {
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		for (WebElement imageElement : imageList) {
			if (imageElement != null) {
				System.out.println(getStatusImage(imageElement));
			}

		}
	}

	public String getStatusImage(WebElement imageElement) {
		String imageSrc = "";
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imageElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {
				imageSrc = imageElement.getAttribute("src");

			}

		} catch (Exception e) {
		}

		return (imageSrc);

	}
	public void quitBrowser() {
		driver.quit();
	}

}
