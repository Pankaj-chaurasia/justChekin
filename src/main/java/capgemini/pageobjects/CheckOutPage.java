package capgemini.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import capgemini.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder=\"Select Country\"]")
	WebElement countryInputBox;
	
	@FindBy(css = ".list-group-item")
	List<WebElement> countries;
	
	@FindBy(css = "a[class*='submit']")
	WebElement submitButton;
	
	By placeOrder = By.cssSelector("a[class*='submit']");
	

	public void selectCountry(String country)
	{
		Actions ac = new Actions(driver);
		ac.sendKeys(countryInputBox, country).build().perform();
		
		countries.stream().filter(c->c.getText().equalsIgnoreCase("India")).findFirst().orElse(null).click();
	}
	
	public ConfirmationPage placeOrder()
	{
		waitForElementToBeClickable(placeOrder);
		scrollBy();
		submitButton.click();
		ConfirmationPage cnfPage = new ConfirmationPage(driver);
		return cnfPage;
		
	}
}
