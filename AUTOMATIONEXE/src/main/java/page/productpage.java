package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement products;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	WebElement viewproduct;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	WebElement addtocart;
	
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	WebElement continuebtn;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "review")
	WebElement review;
	
	@FindBy(id = "button-review")
	WebElement submit;
	
	public productpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void prd() throws InterruptedException
	{
		products.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400);");
		Thread.sleep(1000);
		Thread.sleep(3000);
		viewproduct.click();
		addtocart.click();
		continuebtn.click();
		name.sendKeys("kavya");
		email.sendKeys("kavya111@gmail.com");
		review.sendKeys("Nice product");
		submit.click();
	}

}
