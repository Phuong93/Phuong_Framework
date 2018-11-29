package Exercise;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyBrokenImageFunction {
	private WebDriver driver;

	public verifyBrokenImageFunction(WebDriver d) {
		driver = d;
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
}
