package nz.co.bka;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import nz.co.bka.util.TestData;

/**
 * The Class EngineeringIndustrialPageTitleTest.
 */
public class EngineeringIndustrialPageTitleTest extends SuperTest {

	/**
	 * Test 1676.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void test1676() throws Exception {
		
		//update Engineering / Industrial Page Title
		driver.get(baseUrl + "/#/content/content/edit/1676");
		driver.findElement(By.id("PageTitle.en-US")).clear();
		driver.findElement(By.id("PageTitle.en-US")).sendKeys(TestData.getEngineeringIndustrialPageTitle());
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		//Refresh page and verify is changed successful
		driver.get(baseUrl + "/#/content/content/edit/1676");
		assertEquals(TestData.getEngineeringIndustrialPageTitle(), driver.findElement(By.id("PageTitle.en-US")).getAttribute("value"));
	}
}
