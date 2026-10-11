package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.titlelogovalpage;

public class titlelogovaltest extends baseclass {

	titlelogovalpage validationPage;

	@Test(priority = 1)
	public void titleValidationTest() throws IOException {
		test = extent.createTest("Page Title Validation Test");

		validationPage = new titlelogovalpage(driver);

		String expectedTitle = "Automation Exercise";
		String actualTitle = validationPage.getPageTitle();
		System.out.println("Actual Page Title: " + actualTitle);

		if (actualTitle.equals(expectedTitle)) {
			test.pass("Page title verified successfully: " + actualTitle);
		} else {
			String path = Reporterclass.screenshotMethod(driver, "title_validation_failed");
			test.addScreenCaptureFromPath(path);
			test.fail("Title mismatch. Expected: " + expectedTitle + " | Actual: " + actualTitle);
			
			Assert.assertEquals(actualTitle, expectedTitle, "Page title validation failed!");
		}
	}

	@Test(priority = 2)
	public void logoValidationTest() throws IOException {
		test = extent.createTest("Page Logo Validation Test");

		validationPage = new titlelogovalpage(driver);

		boolean logoPresent = validationPage.isLogoDisplayed();
		System.out.println("Is Logo Displayed? " + logoPresent);

		if (logoPresent) {
			test.pass("Site logo is displayed successfully.");
		} else {
			String path = Reporterclass.screenshotMethod(driver, "logo_validation_failed");
			test.addScreenCaptureFromPath(path);
			test.fail("Site logo is missing or not visible on the page.");
			
			Assert.assertTrue(logoPresent, "Logo validation failed!");
		}
	}
}