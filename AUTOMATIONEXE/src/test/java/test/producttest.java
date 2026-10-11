package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.productpage;

public class producttest extends baseclass {

	productpage prodPage;

	@Test
	public void prdTest() throws InterruptedException, IOException {
		test = extent.createTest("Product Navigation, Cart & Review Test");

		prodPage = new productpage(driver);
		prodPage.prd();

		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after submitting product review: " + currentUrl);

		if (currentUrl.contains("product_details") || currentUrl.contains("automationexercise.com")) {
			test.pass("Product added to cart and review submitted successfully.");
		} else {
			String path = Reporterclass.screenshotMethod(driver, "product_test_failed");
			test.addScreenCaptureFromPath(path);
			test.fail("Failed to submit product details or add to cart.");

			Assert.fail("Product test failed at URL: " + currentUrl);
		}
	}
}