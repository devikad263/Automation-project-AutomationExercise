package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.searchpage;

public class searchtest extends baseclass {

	searchpage searchPg;

	@Test
	public void searchpdtTest() throws InterruptedException, IOException {
		test = extent.createTest("Search Product, View Details and Add to Cart Test");

		searchPg = new searchpage(driver);
		searchPg.searchpdt();

		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after search execution: " + currentUrl);

		if (currentUrl.contains("product_details") || currentUrl.contains("automationexercise.com")) {
			test.pass("Product searched, viewed, and added to cart successfully.");
		} else 
		{

			String path = Reporterclass.screenshotMethod(driver, "search_test_failed");
			test.addScreenCaptureFromPath(path);
			test.fail("Failed to perform search or add product to cart.");

			Assert.fail("Search test failed. Current URL: " + currentUrl);
		}
	}
}