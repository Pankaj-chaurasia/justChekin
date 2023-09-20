package capgemini.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import capgemini.*;
import capgemini.TestComponents.*;
import capgemini.pageobjects.CartPage;
import capgemini.pageobjects.CheckOutPage;
import capgemini.pageobjects.ConfirmationPage;
import capgemini.pageobjects.LandingPage;
import capgemini.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrder extends BaseTest{

	@Test
	public void main() throws IOException {
		
		String productName = "ADIDAS ORIGINAL";
		
		LandingPage lp = launchApplication();
		lp.goTo();
		ProductCatalogue pc = lp.loginAction("pankajch9021@gmail.com", "Pankaj@11");
		pc.getProductList();
		
		pc.addProductToCart(productName);
		CartPage cartpage = pc.goToCart();
		Boolean match =  cartpage.verifyProductDetails(productName);
		Assert.assertTrue(match);
		CheckOutPage checkPage = cartpage.goToCheckout();
		checkPage.selectCountry("India");	
		ConfirmationPage cnfPage = checkPage.placeOrder();
		String text = cnfPage.verifyConfirmationText();
		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
}