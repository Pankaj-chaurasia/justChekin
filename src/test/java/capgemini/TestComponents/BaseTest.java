package capgemini.TestComponents;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import capgemini.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("/SeleniumFrameworkDesign/src/main/java/capgemini/Resources/GlobalData.properties");
//		prop.load(fis);
//		String browserName = "chrome";
		
//		if(browserName.equalsIgnoreCase("chrome"))
//		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pchauras\\eclipse-workspace\\TestNg\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		return driver;
	}
	
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
}
