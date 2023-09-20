package capgemini.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IITdAutomation {
	
	WebDriver driver;
	
	@Test
	public void invokeBrowser() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pchauras\\eclipse-workspace\\TestNg\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://web.iitd.ac.in/~srz238152/");
		
		driver.findElement(By.xpath("//nav/div[2]/ul/li[4]")).click();
		
		WebElement poster = driver.findElement(By.cssSelector("a[href=\"Poster.html\"]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(poster));
		
		poster.click();
		String title = driver.getTitle();
		String respCode = title.split(" ")[0];
		
		System.out.println(respCode);
		System.out.println("Pankaj Changes this files for demo purpose");
		System.out.println("just checking again");
	}
	
	public void checkForBrokenLinks() {
		
		
	}
}
