package capgemini.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import capgemini.TestComponents.BaseTest;
import capgemini.pageobjects.CartPage;
import capgemini.pageobjects.CheckOutPage;
import capgemini.pageobjects.ConfirmationPage;
import capgemini.pageobjects.LandingPage;
import capgemini.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 extends BaseTest{

	
	//@Test
	public void placeOrder() throws IOException {

		String productName = "ADIDAS ORIGINAL";	
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pchauras\\eclipse-workspace\\TestNg\\driver\\chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
//		LandingPage lp = launchApplication();
//	//	lp.goTo();
//		ProductCatalogue pc = lp.loginAction("pankajch9021@gmail.com", "Pankaj@11");
//	//	pc.getProductList();
//		pc.addProductToCart(productName);
//		CartPage crtpage = pc.goToCart();
//		Boolean match =  crtpage.verifyProductDetails(productName);
//		Assert.assertTrue(match);
//		
//		CheckOutPage checkPage = crtpage.goToCheckout();
//		checkPage.selectCountry("India");
//		ConfirmationPage cnfPage = checkPage.placeOrder();
//		String text = cnfPage.verifyConfirmationText();
//		
//		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
//		launchApplication();
	}

}
