package nz.co.bka;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import nz.co.bka.util.TestData;

/**
 * The Class SearchFunctionTest.
 */
public class SearchFunctionTest {
	
	/** The driver. */
	static WebDriver driver;
	
	/** The base url. */
	static String baseUrl; 
	
	/**
	 * Sets the up.
	 */
	@Before
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://mastip-test.azurewebsites.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  /**
  	 * Test search.
  	 *
  	 * @throws Exception the exception
  	 */
  	@Test
	  public void testSearch() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.cssSelector("button.searchbar-trigger")).click();
	    driver.findElement(By.id("mobilequery")).clear();
	    driver.findElement(By.id("mobilequery")).sendKeys(TestData.getSearchKeywords());
	    driver.findElement(By.id("mobilequery")).sendKeys(Keys.ENTER);
	    
	    //Verify search result title
	    assertTrue(driver.findElement(By.cssSelector("h1.search-results-title.text-xs-center")).getText().contains(TestData.getSearchKeywords()));
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