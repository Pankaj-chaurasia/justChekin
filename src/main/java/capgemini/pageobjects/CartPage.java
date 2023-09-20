package capgemini.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import capgemini.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	By checkButtonBy = By.cssSelector(".totalRow button");
	
	public Boolean verifyProductDetails(String productName)
	{
		Boolean match = cartProducts.stream()
				.anyMatch(cpro -> cpro.getText().equals(productName));
		return match;
	}
	
	public CheckOutPage goToCheckout()
	{
		waitForElementToAppear(checkButtonBy);;
		checkoutButton.click();
		CheckOutPage checkPage = new CheckOutPage(driver);
		return checkPage;
	}
	
}
