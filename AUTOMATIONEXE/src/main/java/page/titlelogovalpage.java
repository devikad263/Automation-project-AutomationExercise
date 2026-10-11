package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class titlelogovalpage {
	
	WebDriver driver;

	@FindBy(xpath = "//img[@alt='Website for automation practice']")
	WebElement siteLogo;

	public titlelogovalpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isLogoDisplayed() {
		try {
			return siteLogo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}