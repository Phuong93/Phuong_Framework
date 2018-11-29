package Exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerFunction {
	private WebDriver driver;
	public registerFunction(WebDriver d2) {
		driver = d2;
		}
	public void register() {
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.clear();
		firstName.sendKeys("Tran");
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.clear();
		lastName.sendKeys("Phuong");
		WebElement phone = driver.findElement(By.name("phone"));
		phone.clear();
		phone.sendKeys("0123456789");
		WebElement userName = driver.findElement(By.name("userName"));
		userName.clear();
		userName.sendKeys("phuongtranthi@gmail.com");
		WebElement address1 = driver.findElement(By.name("address1"));
		address1.clear();
		address1.sendKeys("Quan 12");
		WebElement address2 = driver.findElement(By.name("address2"));
		address2.clear();
		address2.sendKeys("Tan Binh");
		WebElement city = driver.findElement(By.name("city"));
		city.clear();
		city.sendKeys("Ho Chi Minh");
		WebElement state = driver.findElement(By.name("state"));
		state.clear();
		state.sendKeys("Sai Gon");
		WebElement postalCode = driver.findElement(By.name("postalCode"));
		postalCode.clear();
		postalCode.sendKeys("70000");
		List<WebElement> countryList = driver.findElements(By.tagName("option"));
		for (WebElement countryElement : countryList) {
			if (countryElement.getText().contains("UNITED STATES"))  {
				countryElement.click();
			}

		}
		
		WebElement email = driver.findElement(By.name("email"));
		email.clear();
		email.sendKeys("Tran Thi Phuong");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("12345678");
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.clear();
		confirmPassword.sendKeys("12345678");
		WebElement register = driver.findElement(By.name("register"));
		register.click();
		WebElement title = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]"));
		if (title.getText().contains("Thank you for registering. ")) {
			System.out.println("Register success");
		}
		
		
	}

}
