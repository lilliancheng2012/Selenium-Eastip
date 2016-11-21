package nz.co.bka;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import nz.co.bka.util.TestData;

/**
 * The Class UIMarketSolutionPageTitleVerifyTest.
 */
public class UIMarketSolutionPageTitleVerifyTest {

	/** The driver. */
	private WebDriver driver;
	
	/** The base url. */
	private String baseUrl;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://mastip-test.azurewebsites.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Test verify.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testVerify() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Market Solutions")).click();
//		assertEquals("Market Solutions test | Mastip", driver.getTitle());
		assertEquals(TestData.getSoultionPageTitle(), driver.findElement(By.cssSelector("h1")).getText());
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
