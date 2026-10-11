package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class baseclass {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public String url = "https://automationexercise.com/";
	
	@BeforeTest
	public void Browser_Launch() throws InterruptedException
	{
		extent = Reporterclass.sam();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown()
	{
		if (driver != null) {
			driver.quit();
		}
		if (extent != null) {
			extent.flush();
		}
	}
}