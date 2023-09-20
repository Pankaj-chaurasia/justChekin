package capgemini.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import capgemini.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver; //Parsing driver to this class
		PageFactory.initElements(driver, this); //construct FindBy to use driver of the class
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatalogue loginAction(String emailid, String password)
	{
		email.sendKeys(emailid);
		pass.sendKeys(password);
		submit.click();
		
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
}
