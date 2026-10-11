package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporterclass {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports sam()
	{
		reporter = new ExtentSparkReporter(".\\Reports\\automationexe.html");
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows11");
		extent.setSystemInfo("tester name", "devika");
		extent.setSystemInfo("browsername", "chrome");
		
		return extent;
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException
	{
		if (test != null) {
			if(result.getStatus() == ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "test case failed is " + result.getName());
				test.log(Status.FAIL, "test case failed is " + result.getThrowable());
				
				if (baseclass.driver != null) {
					String screenshotpath = screenshotMethod(baseclass.driver, result.getName());
					test.addScreenCaptureFromPath(screenshotpath);
				}
			}
			else if(result.getStatus() == ITestResult.SKIP)
			{
				test.log(Status.SKIP, "test case skipped is " + result.getName());
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "test case passed is " + result.getName());
			}
		}
	}

	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination = "./Reports/screenshots/" + screenshotname + ".png";
		FileHandler.copy(src, new File(destination));
		
		return "screenshots/" + screenshotname + ".png";
	}
}