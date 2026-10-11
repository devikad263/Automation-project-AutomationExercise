package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement loginLink;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	WebElement loginbtn;
	
	public loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setvalue(String em, String pwd)
	{
		loginLink.click();
		email.clear();
		email.sendKeys(em);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
	}
}