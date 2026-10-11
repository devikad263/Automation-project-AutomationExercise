package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Reporterclass;
import base.baseclass;
import page.loginpage;

public class logintest extends baseclass {
	
	loginpage log;
	
	@DataProvider(name = "loginData")
	public Object[][] getdata() throws IOException {
		String path = "C:\\Users\\admin\\OneDrive\\Desktop\\selinium automation\\automationexe.xlsx";
		return utilitiespkg.utilities.getTestData(path, "Sheet1");
	}
	
	@Test(dataProvider = "loginData", priority = 1)
	public void loginTest(String user, String password) throws IOException, InterruptedException
	{
		driver.get("https://automationexercise.com/");
		
		test = extent.createTest("Login test - " + user);
		log = new loginpage(driver);
		log.setvalue(user, password);
		
		System.out.println("Executed for: " + user);
		
		Thread.sleep(2000);
		String currenturl = driver.getCurrentUrl();
		
		if (currenturl.equals("https://automationexercise.com/"))
		{
			test.pass("Login successful for: " + user);
		}
		else
		{
			String screenshotname = "Login failed_" + user;
			String path = Reporterclass.screenshotMethod(driver, screenshotname);
			test.addScreenCaptureFromPath(path);
			test.fail("Login failed for: " + user);
			
			Assert.fail("Login failed for: " + user + " | Current URL: " + currenturl);				
		}
	}
}