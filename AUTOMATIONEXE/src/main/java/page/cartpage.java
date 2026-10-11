package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cart;
	
	@FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
	WebElement proceedtocart;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	WebElement placeOrderBtn;
	
	@FindBy(name = "name_on_card")
	WebElement nameoncard;
	
	@FindBy(name = "card_number")
	WebElement cardnumber;
	
	@FindBy(name = "cvc")
	WebElement cvc;
	
	@FindBy(name = "expiry_month")
	WebElement expirymonth;
	
	@FindBy(name = "expiry_year")
	WebElement expiryyear;
	
	@FindBy(id = "submit")
	WebElement submit;
	
	public cartpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void placeorder() throws InterruptedException
	{
		cart.click();
		Thread.sleep(1000);
		
		proceedtocart.click();
		Thread.sleep(1000);
		
		placeOrderBtn.click();
		Thread.sleep(1000);
		
		nameoncard.sendKeys("kavya");
		cardnumber.sendKeys("953484657254");
		cvc.sendKeys("875");
		expirymonth.sendKeys("08");
		expiryyear.sendKeys("2036");
		
		submit.click(); 
	}
}