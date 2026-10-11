package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement products;
		
    @FindBy(id = "search_product")
    WebElement search;
    
    @FindBy(xpath = "//*[@id=\"submit_search\"]/i")
    WebElement searchbtn;
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    WebElement viewproduct;
    
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addtocart;
    
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    WebElement continuebtn;
    
    public searchpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void searchpdt() throws InterruptedException
    {
    	     products.click();
    	     Thread.sleep(3000);
    	     search.sendKeys("kids");
    	     searchbtn.click();
    	     viewproduct.click();
    	     addtocart.click();
    	     continuebtn.click();
    }
}
