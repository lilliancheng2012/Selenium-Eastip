package nz.co.bka;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

/**
 * The Class MarketSolutionsSummaryOverviewTextTest.
 */
public class MarketSolutionsSummaryOverviewTextTest extends SuperTest {
	
	/**
	 * Test market solutions summary overview text.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testMarketSolutionsSummaryOverviewText() throws Exception {
		//update Market Solutions Summary Overview Text
		driver.get(baseUrl + "/#/content/content/edit/1673");
        driver.findElement(By.linkText("Summary")).click();
        driver.findElement(By.name("item_0")).clear();
        driver.findElement(By.name("item_0")).sendKeys("Overview Text");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        
        //Refresh page and verify is changed successful
        driver.get(baseUrl + "/#/content/content/edit/1673");
        assertEquals("Overview Text", driver.findElement(By.name("item_0")).getAttribute("value"));
	}

}
