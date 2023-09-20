package capgemini.Tests;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		String productName = "ADIDAS ORIGINAL";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pchauras\\eclipse-workspace\\TestNg\\driver\\chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");

		driver.findElement(By.id("userEmail")).sendKeys("pankajch9021@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pankaj@11");

		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// System.out.println(products.size());
		List<WebElement> filteredProduct = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.collect(Collectors.toList());

		// System.out.println(filteredProduct.size());

		for (WebElement product : filteredProduct) {
			product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}

		// WebElement cart =
		// driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		// cart.click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartWrap"));

		Boolean match = cartProducts.stream()
				.anyMatch(cpro -> cpro.findElement(By.cssSelector("h3")).getText().equals(productName));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions ac = new Actions(driver);
		
		ac.sendKeys(driver.findElement(By.cssSelector(".form-group")), "India").build().perform();
		
		
//		WebElement searchCountry = driver.findElement(By.cssSelector(".form-group"));
//		ac.moveToElement(searchCountry).click().sendKeys("India").build().perform();
		
		List<WebElement> country = driver.findElements(By.cssSelector(".list-group-item"));
		
//		System.out.println(country.size());
//		for(WebElement c: country)
//		{
//			System.out.println(c.getText());
//		}
		WebElement countryName = country.stream().filter(c->c.getText().equalsIgnoreCase("India")).findAny().orElse(null);

	//	System.out.println(countryName.size());
		countryName.click();
		
		
		driver.findElement(By.cssSelector("a[class*='submit']")).click();
		String confirmMessage = driver.findElement(By.cssSelector("h1")).getText();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		Thread.sleep(5000);
		driver.quit();
	}

}
