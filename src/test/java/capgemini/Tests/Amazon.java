package capgemini.Tests;

import static org.testng.Assert.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Amazon test = new Amazon();
		test.login();
//		test.verifyTitle();
//		test.fillform();
//		test.verifyLoggedIn();
//		test.closeBrowser();

		test.searchProduct();
		test.selectProduct();
		test.addToCart();
	}

	public void login() throws InterruptedException {
	//	WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		driver.get(
//				"https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
//		
		driver.navigate().to("https://www.amazon.com");
	}

	public void verifyTitle() {

		String actual = driver.getTitle();
		String expected = "Amazon Sign-In";

		assertEquals(actual, expected, "Title do not match");
	}

	public void fillform() throws InterruptedException {

		driver.findElement(By.id("ap_email")).sendKeys("8698581911");
		driver.findElement(By.id("continue")).click();

		WebElement password = driver.findElement(By.id("ap_password"));
		Actions ac = new Actions(driver);
		ac.moveToElement(password).click().build().perform();
		// for entering password manually
		Thread.sleep(4000);

		driver.findElement(By.id("signInSubmit")).click();

		// for OTP
		Thread.sleep(10000);

		driver.findElement(By.id("auth-mfa-remember-device")).click(); // checkbox
		driver.findElement(By.id("auth-signin-button")).click();
	}

	public void verifyLoggedIn() {

		String greetingMessage = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		if (greetingMessage.contains("Pankaj")) {
			assertTrue(true);
		} else {
			assertFalse(false);
		}
	}

	public void searchProduct() {

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("watch");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver
//				.findElements(By.cssSelector("div[class='s-suggestion s-suggestion-ellipsis-direction']"))));

		List<WebElement> searchResults = driver
				.findElements(By.cssSelector("div[class=\"s-suggestion s-suggestion-ellipsis-direction\"]"));
		for (WebElement popupNames : searchResults) {
			
			String resultText = popupNames.getText();

			if (resultText.contains("case")) {
				popupNames.click();
				break;
			}
		}
	}

	public void selectProduct() {
		
	//	WebElement highRate = driver.findElement(By.xpath(""));
		
		List<WebElement> highlyRatedProducts = driver
				.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));

		for (WebElement prod : highlyRatedProducts) {
			
			String prodText = prod.getText();
			
			if (prodText.contains("Amazon Basics")) {
				prod.click();
				break;
			}
		}
		
		
	}
	
	public void addToCart()
	{
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.cssSelector("input[name=\"proceedToRetailCheckout\"]")).click();
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}