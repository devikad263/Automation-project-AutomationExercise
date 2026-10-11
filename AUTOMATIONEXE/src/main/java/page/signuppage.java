package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class signuppage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement signup;
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signupbtn;
	
	@FindBy(id = "uniform-id_gender2")
	WebElement title;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement day;
	
	@FindBy(id = "months")
	WebElement month;
	
	@FindBy(id = "years")
	WebElement year;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "address2")
	WebElement address2;
	
	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "state")
	WebElement state;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "zipcode")
	WebElement zipcode;
	
	@FindBy(id = "mobile_number")
	WebElement mobnumber;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
	WebElement createacc;
	
	public signuppage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean data() throws InterruptedException
	{
		signup.click();
		name.sendKeys("Keerthy");
		email.sendKeys("Keerthy988@gmail.com");
		Thread.sleep(2000);
		signupbtn.click();
		Thread.sleep(2000);

		
		if (driver.getPageSource().contains("Email Address already exist!")) {
			System.out.println("ERROR: Email Address already exists!");
			return false; 
		}

		title.click();
		password.sendKeys("keerthy988");
		
		Select selectDay = new Select(day);
		selectDay.selectByValue("10");
		
		Select selectmonth = new Select(month);
		selectmonth.selectByValue("8");
		
		Select selectyear = new Select(year);
		selectyear.selectByValue("2005");
		
		firstname.sendKeys("Keerthy");
		lastname.sendKeys("kiran");
		company.sendKeys("abc");
		address1.sendKeys("keerthy bhavan");
		address2.sendKeys("keerthy bhavan");
		
		Select selectcountry = new Select(country);
		selectcountry.selectByValue("India");
		
		state.sendKeys("kerala");
		city.sendKeys("Thrivandrum");
		zipcode.sendKeys("681647");
		mobnumber.sendKeys("9836572857");
		
		createacc.click();
		Thread.sleep(3000); 
		return true;
	}
}