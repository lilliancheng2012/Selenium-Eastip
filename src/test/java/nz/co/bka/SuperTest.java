package nz.co.bka;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * The Class SuperTest.
 */
public abstract class SuperTest {

	/** The driver. */
	static WebDriver driver;
	
	/** The base url. */
	static String baseUrl;

	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://mastip-test.azurewebsites.net/umbraco";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login
		driver.get(baseUrl + "/#/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("*****password");
		driver.findElement(By.cssSelector("button.btn")).click();
		assertEquals("Welcome to The Friendly CMS", driver.findElement(By.cssSelector("strong")).getText());
	}

	  /**
  	 * Tear down.
  	 *
  	 * @throws Exception the exception
  	 */
  	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
