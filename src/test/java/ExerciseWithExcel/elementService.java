package ExerciseWithExcel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
	
	public WebElement getElementsByAnotherElement(WebElement anotherElement, String eName, String eLocator) {
		WebElement e = null;
		if (eName.toLowerCase().endsWith("-id")) {
			e = anotherElement.findElement(By.id(eLocator));
		} else if (eName.toLowerCase().endsWith("-name")) {
			e = anotherElement.findElement(By.name(eLocator));
		} else if (eName.toLowerCase().endsWith("-xpath")) {
			e = anotherElement.findElement(By.xpath(eLocator));
		} else if (eName.toLowerCase().endsWith("-class")) {
			e = anotherElement.findElement(By.className(eLocator));
		} else if (eName.toLowerCase().endsWith("-css")) {
			e = anotherElement.findElement(By.cssSelector(eLocator));
		} else if (eName.toLowerCase().endsWith("-tagname")) {
			e = anotherElement.findElement(By.tagName(eLocator));
		} else {
			System.out.println("eName is invalid, please check");
		}
		return e;
	}
	
	public void sendKeyEvent(String eName, String eLocator, String value) {
		WebElement e = getElements(eName, eLocator);
		e.clear();
		e.sendKeys(value);
	}
	
	public void clickEvent(String eName, String eLocator) {
		WebElement e = getElements(eName, eLocator);
		e.click();
	}
	
	public void clickEventByElement(WebElement e, String eName, String eLocator) {
		getElementsByAnotherElement(e, eName, eLocator).click();
	}
	
	public void moveToEvent(String eName, String eLocator)  {
		WebElement e = getElements(eName, eLocator);
		if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView(true);", e);
	    }
	}
	
	public void hoverToEvent(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e);
		actions.perform();
	}
	
	public void switchIframeEvent(String eName, String eLocator) {
		WebElement iframe = getElements(eName, eLocator);
		driver.switchTo().frame(iframe);
	}
	
	public void waitEvent(String eName, String eLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);		
		if (eName.toLowerCase().endsWith("-id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(eLocator)));
		} else if (eName.toLowerCase().endsWith("-name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(eLocator)));
		} else if (eName.toLowerCase().endsWith("-xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eLocator)));
		} else if (eName.toLowerCase().endsWith("-class")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(eLocator)));
		} else if (eName.toLowerCase().endsWith("-css")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(eLocator)));
		} else if (eName.toLowerCase().endsWith("-tagname")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(eLocator)));
		} else {
			System.out.println("eName is invalid, please check");
		}
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
