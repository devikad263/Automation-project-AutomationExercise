package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.cartpage;

public class carttest extends baseclass {

	cartpage cartPg;

	@Test
	public void cartCheckoutTest() throws InterruptedException, IOException {

		test = extent.createTest("Cart Checkout and Payment Test");

		cartPg = new cartpage(driver);
		cartPg.placeorder();

		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after payment submission: " + currentUrl);

		if (currentUrl.contains("payment_done") || currentUrl.contains("automationexercise.com")) {
			test.pass("Checkout and payment completed successfully.");
		} else {

			String path = Reporterclass.screenshotMethod(driver, "cart_checkout_failed");
			test.addScreenCaptureFromPath(path);
			test.fail("Checkout or payment failed. Current URL: " + currentUrl);

			Assert.fail("Cart checkout process failed at URL: " + currentUrl);
		}
	}
}