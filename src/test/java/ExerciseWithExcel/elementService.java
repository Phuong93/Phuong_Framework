package ExerciseWithExcel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class elementService {
	WebDriver driver;
	public elementService(WebDriver driverGetElement) {
		driver = driverGetElement;
	}

	public WebElement getElements(String eName, String eLocator) {
		WebElement e = null;
		if (eName.toLowerCase().endsWith("-id")) {
			e = driver.findElement(By.id(eLocator));
		} else if (eName.toLowerCase().endsWith("-name")) {
			e = driver.findElement(By.name(eLocator));
		} else if (eName.toLowerCase().endsWith("-xpath")) {
			e = driver.findElement(By.xpath(eLocator));
		} else if (eName.toLowerCase().endsWith("-class")) {
			e = driver.findElement(By.className(eLocator));
		} else if (eName.toLowerCase().endsWith("-css")) {
			e = driver.findElement(By.cssSelector(eLocator));
		} else if (eName.toLowerCase().endsWith("-tagname")) {
			e = driver.findElement(By.tagName(eLocator));
		} else {
			System.out.println("eName is invalid, please check");
		}
		return e;
	}
	
	public void sendKey(String eName, String eLocator, String value) {
		WebElement e = getElements(eName, eLocator);
		e.clear();
		e.sendKeys(value);
	}
	
	public void clickEvent(String eName, String eLocator) {
		WebElement e = getElements(eName, eLocator);
		e.click();
	}
	
	public List<WebElement> getElementsByList(String eName, String eLocator) {
		List<WebElement> e = null;
		if (eName.toLowerCase().endsWith("-id")) {
			e = driver.findElements(By.id(eLocator));
		} else if (eName.toLowerCase().endsWith("-name")) {
			e = driver.findElements(By.name(eLocator));
		} else if (eName.toLowerCase().endsWith("-xpath")) {
			e = driver.findElements(By.xpath(eLocator));
		} else if (eName.toLowerCase().endsWith("-class")) {
			e = driver.findElements(By.className(eLocator));
		} else if (eName.toLowerCase().endsWith("-css")) {
			e = driver.findElements(By.cssSelector(eLocator));
		} else if (eName.toLowerCase().endsWith("-tagname")) {
			e = driver.findElements(By.tagName(eLocator));
		} else {
			System.out.println("eName is invalid, please check");
		}
		return e;
	}
	
	public void selectBox(String eName, String eLocator, String value) {
		List<WebElement> list_element = getElementsByList(eName, eLocator);
		for (WebElement element : list_element) {
			if (element.getText().contains(value))  {
				element.click();
			}

		}
	}
	
}
