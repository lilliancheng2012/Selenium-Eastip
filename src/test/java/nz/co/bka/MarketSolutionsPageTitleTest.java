package nz.co.bka;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import nz.co.bka.util.TestData;

/**
 * The Class MarketSolutionsPageTitleTest.
 */
public class MarketSolutionsPageTitleTest extends SuperTest {

  /**
   * Test modify market solutions page title.
   *
   * @throws Exception the exception
   */
  @Test
  public void testModifyMarketSolutionsPageTitle() throws Exception {
    //update Market Solutions Page Title
    driver.get(baseUrl + "/#/content/content/edit/1673");
    driver.findElement(By.id("PageTitle.en-US")).clear();
    driver.findElement(By.id("PageTitle.en-US")).sendKeys(TestData.getSoultionPageTitle());
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.get(baseUrl + "/#/content/content/edit/1673");
	assertEquals(TestData.getSoultionPageTitle(), driver.findElement(By.id("PageTitle.en-US")).getAttribute("value"));
  }
  
}