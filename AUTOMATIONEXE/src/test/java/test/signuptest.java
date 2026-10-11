package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.signuppage;

public class signuptest extends baseclass {
	
	signuppage sup;
	
	@Test
	public void test() throws InterruptedException, IOException
	{
		test = extent.createTest("Signup Validation Test");
		
		sup = new signuppage(driver);
		sup.data();
		
		String expectedUrl = "https://automationexercise.com/account_created";
		String actualUrl = driver.getCurrentUrl();
		
		System.out.println("Actual URL after submission: " + actualUrl);
		
		if (actualUrl.equals(expectedUrl))
		{
			test.pass("Signup successful - Account created successfully.");
		}
		else
		{
			String screenshotPath = Reporterclass.screenshotMethod(driver, "signup_validation_failed");	
			test.addScreenCaptureFromPath(screenshotPath);
			test.fail("Signup process failed. Expected: " + expectedUrl + " | Actual: " + actualUrl);
			
			Assert.assertEquals(actualUrl, expectedUrl, "Signup process failed: Account was not created!");
		}
	}
}